package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;
import com.sun.glass.ui.web.WebApplication;


@JavaScriptPrototype(prototype = "", container = "vm.com_sun_glass_ui_web_WebGLView(false)")
final class WebGLViewStub {
    public WebGLViewStub() {
    }

    @JavaScriptBody(body = "return  native_com_sun_glass_ui_web_WebGLView__getNativeView(ptr);", args = "ptr")
    protected native long _getNativeView(long ptr);

    @JavaScriptBody(body = "return  native_com_sun_glass_ui_web_WebGLView__getX(ptr);", args = "ptr")
    protected native long _getX(long ptr);

    @JavaScriptBody(body = "return  native_com_sun_glass_ui_web_WebGLView__getY(ptr);", args = "ptr")
    protected native long _getY(long ptr);

    @JavaScriptBody(body = "return  native_com_sun_glass_ui_web_WebGLView__setParent(ptr, parentptr);", args = {"ptr", "parentptr"})
    protected native void _setParent(long ptr, long parentPtr);


}
