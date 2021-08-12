package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;
import com.sun.prism.es2.WebGLContext;
import com.sun.prism.es2.WebGLFactory;
import com.sun.prism.es2.GLContext;
import com.sun.prism.es2.GLFactory;
import com.sun.glass.ui.web.WebWindow;
import com.sun.glass.ui.web.WebGLView;


public class Util {

    static WebGLFactoryStub webGLFactoryStub;
    static GLFactoryStub GLFactoryStub;
    static WebGLContextStub webGLContextStub;
    static GLContextStub GLContextStub;
    static WebWindowStub webWindowStub;
    static WebGLViewStub webGLViewStub;
    static {
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
    }

    public static void warmup() {
        System.out.println("[SUBS] warming up");
    }
public static void uploadPixels(long ptr, int[] pixels, int offset, int width, int height) {
}

/*
@JavaScriptPrototype(prototype = "", container = "vm.com_sun_prism_es2_WebGLFactory(false)")
static final class WebGLFactoryStub {
    public WebGLFactoryStub() {
    }

    @JavaScriptBody(body = "console.info('SUBS - nGetISGL2 asked'); return true;",
                    args = "ptr")
    private static native boolean nGetIsGL2(long nativeCtxInfo);

    @JavaScriptBody(body = "console.info('SUBS - getAdapterCount'); return 1;",
                    args = {})
    public static native int nGetAdapterCount();

    @JavaScriptBody(body = "console.info('ISEXTSUP'); return true;",
                    args = { "ctx", "str"})
    public static native boolean nIsGLExtensionSupported(long nativeContextObject, String glExtStr);
}
*/

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
            + "}, 1000);\n"
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
