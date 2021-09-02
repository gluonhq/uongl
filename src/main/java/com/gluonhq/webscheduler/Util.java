/*
 * Copyright (c) 2021, Gluon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.webscheduler;

import com.sun.glass.ui.web.WebGLView;
import com.sun.glass.ui.web.WebWindow;
import com.sun.javafx.sg.web.Fridge;
import com.sun.prism.es2.GLContext;
import com.sun.prism.es2.GLFactory;
import com.sun.prism.es2.WebGLContext;
import com.sun.prism.es2.WebGLFactory;
import org.apidesign.bck2brwsr.core.JavaScriptBody;

public class Util {

    static WebGLFactoryStub webGLFactoryStub;
    static GLFactoryStub GLFactoryStub;
    static WebGLContextStub webGLContextStub;
    static GLContextStub GLContextStub;
    static WebWindowStub webWindowStub;
    static WebGLViewStub webGLViewStub;
    static FridgeStub fridgeStub;
    static {
        System.setProperty("prism.order", "es2");
        System.setProperty("glass.platform", "Web");
        System.setProperty("glass.disableThreadChecks", "true");
        System.setProperty("java.vendor","bck2brwsr");

        Object patchThread = new TargetThread(); // this call initializes the `Thread.start()` and `Thread.currentThread()` hooks.
        System.out.println("[SUBS] thread.start has been patched");
        System.out.println("[SUBS] Patching " + GLFactory.class);
        GLFactoryStub = new GLFactoryStub();
        System.out.println("[SUBS] Patching " + WebGLFactory.class);
        webGLFactoryStub = new WebGLFactoryStub();
        System.out.println("[SUBS] Patching " + GLContext.class);
        GLContextStub = new GLContextStub();
        System.out.println("[SUBS] Patching " + WebGLContext.class);
        webGLContextStub = new WebGLContextStub();
        System.out.println("[SUBS] Patching " + WebWindow.class);
        webWindowStub = new WebWindowStub();
        System.out.println("[SUBS] Patching " + WebGLView.class);
        webGLViewStub = new WebGLViewStub();
        System.out.println("[SUBS] Patching " + Fridge.class);
        fridgeStub = new FridgeStub();
    }

    public static void warmup() {
        System.out.println("[SUBS] warming up");
    }

    public static void uploadPixels(long ptr, int[] pixels, int offset, int width, int height) {
    }

    @JavaScriptBody(args = "r", body
            = "window.setTimeout(function() {\n"
            + "  console.log('[UONGL] WebScheduler will run '+r);\n"
            + "  r.run__V();\n"
            + "}, 10);\n"
    )
    public static native void schedule(Runnable r);

    @JavaScriptBody(args = "r", body
            = "window.setInterval(function() {\n"
            + "  console.log('[UONGL] IntervalScheduler [10Hz] will run '+r);\n"
            + "  r.run__V();\n"
            + "}, 100);\n"
    )
    public static native void interval(Runnable r);

    @org.apidesign.bck2brwsr.core.JavaScriptPrototype(
            container = "vm.java_lang_Thread(false)", // this instructs Bck2Brwsr to replace methods in `java.lang.Thread` class
            prototype = "" // there is a special handling for empty prototype since f79794b
    )

    static class TargetThread {

        private static Thread latestThread = new Thread("main"); // this field is added to `java.lang.Thread` class

        public TargetThread() { // constructors are called in the context of `TargetThread` class.
        }

        public void setDaemon(boolean b) {
System.out.println("[SUBS] Thread.setDaemon called with " + b);
        }

        public void setName(String s) {
System.out.println("[SUBS] Thread.setName called, set name to " + s);
        }

        public final void checkAccess() {}

        public static void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh) {
            System.out.println("[SUBS] Thread.setDefaultUncaughtExceptionHandler called");
        }

        public void start() { // this method replaces the `Thread.start()` as soon as `TargetThread` constructor is called
            Thread self = (Thread) (Object) this;
            System.err.println("[SUBSTITUTE] starting thread with " + self.getName());
            setTimeout(() -> {
                Thread prev = latestThread;
                try {
                    latestThread = self;
                    self.run();
                } finally {
                    latestThread = prev;
                }
            });
        }

        public static Thread currentThread() { // this method replaces `Thread.currentThread()`
            return latestThread;
        }

        @JavaScriptBody(args = {"r"}, body = ""
                + "return window.setTimeout(function() {\n"
                + "  r.run__V();\n"
                + "}, 0);\n"
        )
        private static native Object setTimeout(Runnable r);
    }
}
