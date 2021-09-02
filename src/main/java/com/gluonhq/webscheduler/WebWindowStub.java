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

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.View;


@JavaScriptPrototype(prototype = "", container = "vm.com_sun_glass_ui_web_WebWindow(false)")
final class WebWindowStub {

    public WebWindowStub() {
    }

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setAlpha(ptr, alpha);", args = {"ptr", "alpha"})
    native protected void _setAlpha(long ptr, float alpha);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setIcon(ptr, pixels);", args = {"ptr", "pixels"})
    native protected void _setIcon(long ptr, Pixels pixels);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setResizable(ptr, resizable);", args = {"ptr", "resizable"})
    native protected boolean _setResizable(long ptr, boolean resizable);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setFocusable(ptr, f);", args = {"ptr", "f"})
    native protected void _setFocusable(long ptr, boolean isFocusable);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__requestFocus(ptr, f);", args = {"ptr", "f"})
    native protected boolean _requestFocus(long ptr, int event);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setBackground(ptr, r, g, b);", args = {"ptr", "r", "g", "b"})
    native protected boolean _setBackground(long ptr, float r, float g, float b);
    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setVisible(ptr, f);", args = {"ptr", "f"})
    native protected boolean _setVisible(long ptr, boolean visible);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setMinimumSize(ptr, width, height);", args = {"ptr", "width", "height"})
    native protected boolean _setMinimumSize(long ptr, int width, int height);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setMaximumSize(ptr, width, height);", args = {"ptr", "width", "height"})
    native protected boolean _setMaximumSize(long ptr, int width, int height);

    @JavaScriptBody(body = "native_com_sun_glass_ui_web_WebWindow__setView(ptr, view);", args = {"ptr", "view"})
    native protected boolean _setView(long ptr, View view);

}
