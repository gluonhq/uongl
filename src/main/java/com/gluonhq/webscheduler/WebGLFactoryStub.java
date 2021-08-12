package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;
import com.sun.glass.ui.web.WebApplication;
import com.sun.prism.es2.WebGLFactory;


@JavaScriptPrototype(prototype = "", container = "vm.com_sun_prism_es2_WebGLFactory(false)")
final class WebGLFactoryStub {
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
