console.log("WELCOME UONGL!");
function wgl() {
    var canvas = document.getElementById("jfxcanvas");
    var gl = canvas.getContext("webgl");
    return gl;
}

function native_com_sun_prism_es2_GLFactory_nIsGLExtensionSupported(ptr, a) {
    console.log("NISGLEXTENSIONSUPPOERTED!!! a = " + a);
    return true;
}
console.log("WELCOME UONGL2!");

function native_com_sun_glass_ui_web_WebApplication__invokeAndWait(r) {
    console.log("INVOKEANDWAIT!" + r);
    r.run__V();
    console.log("INVOKEANDWAIT DONE!" + r);
}

function native_com_sun_prism_es2_WebGLContext_getIntParam(param) {
    var gl = wgl();
console.log("MT = " + gl.MAX_TEXTURE_SIZE) ;
    if (param == 123) {
    console.log("[UONGL] getIntParam asked for MAX_TEXTURE " + param);
        var answer = gl.getParameter(gl.MAX_TEXTURE_SIZE);
        // return 128*1024*1024;
    console.log("[UONGL] getIntParam will return " + answer);
        return answer;
    }
    console.log("[UONGL] getIntParam asked for " + param);
    return 1;
}

// ------------
// WEBGLVIEW 
// ------------

function native_com_sun_glass_ui_web_WebGLView__getNativeView(ptr) {
    console.log("[UONGL] getNetiveView, ptr = " + ptr);
    return 1;
}

function native_com_sun_glass_ui_web_WebGLView__getX(ptr) {
    console.log("[UONGL] getX, ptr = " + ptr);
    return 0;
}

function native_com_sun_glass_ui_web_WebGLView__getY(ptr) {
    console.log("[UONGL] getY, ptr = " + ptr);
    return 0;
}

// ------------
// WEBWINDOW 
// ------------

function native_com_sun_glass_ui_web_WebWindow__setAlpha(ptr, alpha) {
    console.log("[UONGL] setApha, ptr = " + ptr+" and alpha = " +alpha);
    var canvas = document.getElementById("jfxcanvas");
    var ctx = canvas.getContext("webgl");
    ctx.globalAlpha = alpha;
}

function native_com_sun_glass_ui_web_WebWindow__setIcon(ptr) {
    console.log("[UONGL] setIcon, ptr = " + ptr);
}

function native_com_sun_glass_ui_web_WebWindow__setResizable(ptr, resizable) {
    console.log("[UONGL] setResizable, ptr = " + ptr+" and r = " +resizable);
}

function native_com_sun_glass_ui_web_WebWindow__setFocusable(ptr, f) {
    console.log("[UONGL] setFocusable, ptr = " + ptr+" and f = " +f);
}

function native_com_sun_glass_ui_web_WebWindow__requestFocus(ptr, evt) {
    console.log("[UONGL] requestFocus, ptr = " + ptr+" and evt = " +evt);
}

function native_com_sun_glass_ui_web_WebWindow__setBackground(ptr, r, g, b) {
    console.log("[UONGL] setBGColor, ptr = " + ptr+" and r = " +r+", g = " +g+", b = " +b);
    var red = 256 * r;
    var green = 256 * g;
    var blue = 256*b;
    var gl = wgl();
    var canvas = document.getElementById("jfxcanvas");
    canvas.style.backgroundColor = 'rgb('+red+','+ green+','+ blue+')';
/*
    var ctx = canvas.getContext("webgl");
    ctx.globalCompositeOperation = 'destination-over'
    ctx.fillStyle = 'rgb('+red+','+ green+','+ blue+')';
    ctx.fillRect(0, 0, canvas.width, canvas.height);
*/
}

function native_com_sun_glass_ui_web_WebWindow__setVisible(ptr, vis) {
    console.log("[UONGL] setVisible, ptr = " + ptr+" and vis = " +vis);
}

function native_com_sun_glass_ui_web_WebWindow__setMinimumSize(ptr, width, height) {
    console.log("[UONGL] setMinimumSize to "+ width+", " + height);
}

function native_com_sun_glass_ui_web_WebWindow__setMaximumSize(ptr, width, height) {
    console.log("[UONGL] setMaximumSize to "+ width+", " + height);
}

function native_com_sun_glass_ui_web_WebWindow__setView(ptr, view) {
    console.log("[UONGL] setView to "+ view);
}

function native_com_sun_glass_ui_web_WebGLView__setParent(ptr, parentptr) {
    console.log("[UONGL] setParentPtr ");
}

// ------------
// GLCONTEXT 
// ------------

function native_com_sun_prism_es2_GLContext_nActiveTexture(nativeCtxInfo, texUnit) {
    console.log("[UONGL] nActiveTexture ctx = "+nativeCtxInfo+", id = "+texUnit);
    var gl = wgl();
    gl.activeTexture(gl.TEXTURE+texUnit);
}

function native_com_sun_prism_es2_GLContext_nBindFBO(nativeCtxInfo, nativeFBOID) {
    console.log("[UONGL] nBindFBO ctx = "+nativeCtxInfo+", id = "+nativeFBOID);
    var gl = wgl();
    if (nativeFBOID == 0) {
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);
    } else {
        gl.bindFramebuffer(gl.FRAMEBUFFER, nativeFBOID);
    }
}

function native_com_sun_prism_es2_GLContext_nCreateFBO () {
    console.log("[UONGL] ncreateFBO ");
}

function native_com_sun_prism_es2_GLContext_nCreateIndexBuffer16 () {
    console.log("[UONGL] ncreateIndexBuffer16 ");
}

function native_com_sun_prism_es2_GLContext_nCreateTexture () {
    console.log("[UONGL] ncreateTexture ");
}

function native_com_sun_prism_es2_GLContext_nEnableVertexAttributes(ptr){
    var gl = wgl();
    for (i = 0; i < 4; i++) {
        gl.enableVertexAttribArray(i);
    }
    console.log("[UONGL] nEnableVertexAttr DONE");
}

function native_com_sun_prism_es2_GLContext_nSetIndexBuffer() {
    console.log("[UONGL] nSetIndexBuffer ");
}

function native_com_sun_prism_es2_GLContext_nUpdateViewport() {
    console.log("[UONGL] nUpdateViewport ");
}

// ------------
// WEBGLCONTEXT 
// ------------

function native_com_sun_prism_es2_WebGLContext_nGetNativeHandle(nativeCtxInfo) {
    console.log("[UONGL] WebGLContext_nGetNativeHandle always return 1");
    return 1;
}

function native_com_sun_prism_es2_WebGLContext_nInitialize(nativeDInfo, nativePFInfo,
            nativeshareCtxHandle, vSyncRequest) {
    console.log("[UONGL] WebGLContext_nInitialize always return 1");
    return 1;
}

function native_com_sun_prism_es2_WebGLContext_nMakeCurrent() {
    console.log("[UONGL] WebGLContext_nMakeCurrent NO-OP");
}


