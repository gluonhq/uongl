package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;
import com.sun.glass.ui.web.WebApplication;
import com.sun.prism.es2.WebGLContext;


@JavaScriptPrototype(prototype = "", container = "vm.com_sun_prism_es2_WebGLContext(false)")
final class WebGLContextStub {
    public WebGLContextStub() {
    }

    @JavaScriptBody(body = "return native_com_sun_prism_es2_WebGLContext_getIntParam(param);", args = "param")
    native int getIntParam(int param);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_WebGLContext_nGetNativeHandle(param);", args = "param")
    private static native long nGetNativeHandle(long nativeCtxInfo);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_WebGLContext_nInitialize(nativeDInfo, nativePFInfo, nativeshareCtxHandle, vSyncRequest);", args = {"nativeDInfo", "nativePFInfo", "nativeshareCtxHandle", "vSyncRequest"})
    private static native long nInitialize(long nativeDInfo, long nativePFInfo,
            long nativeshareCtxHandle, boolean vSyncRequest);


}
