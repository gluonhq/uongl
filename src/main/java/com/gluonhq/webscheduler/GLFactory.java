package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;
import com.sun.prism.es2.GLFactory;


@JavaScriptPrototype(prototype = "", container = "vm.com_sun_prism_es2_GLFactory(false)")
final class GLFactoryStub {
    public GLFactoryStub() {
    }

    @JavaScriptBody(body = "console.info('SUBS - nGetISGLext asked'); return native_com_sun_prism_es2_GLFactory_nIsGLExtensionSupported(ptr, a);",
                    args = {"ptr", "a"})
    private static native boolean nIsGLExtensionSupported(long nativeContextObject, String glExtStr);

    @JavaScriptBody(body = "return 'Gluon WebGL Vendor';",
                    args = {"ptr"})
    private static native String nGetGLVendor(long nativeCtxInfo);

    @JavaScriptBody(body = "return 'Gluon WebGL Renderer';",
                    args = {"ptr"})
    private static native String nGetGLRenderer(long nativeCtxInfo);

    @JavaScriptBody(body = "return 'Gluon WebGL Version 1';",
                    args = {"ptr"})
    private static native String nGetGLVersion(long nativeCtxInfo);


}
