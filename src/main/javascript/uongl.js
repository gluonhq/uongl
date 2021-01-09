console.log("WELCOME UONGL!");
var buffers = [];
var bufferIdx = 0;

function wgl() {
    var canvas = document.getElementById("jfxcanvas");
    var gl = canvas.getContext("webgl2");
    return gl;
}

function buff(p) {
    bufferIdx++;
    buffers[bufferIdx] = p;
    return bufferIdx;
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
console.log("[UONGL] getIntParam for " + param) ;
    var answer = 1;
    if (param == 120) {
        answer = gl.getParameter(gl.MAX_FRAGMENT_UNIFORM_VECTORS);
    }
    if (param == 122) {
        answer = gl.getParameter(gl.MAX_TEXTURE_IMAGE_UNITS);
    }
    if (param == 123) {
        answer = gl.getParameter(gl.MAX_TEXTURE_SIZE);
    }
    if (param == 124) {
        answer = gl.getParameter(gl.MAX_VERTEX_ATTRIBS);
    }
    if (param == 125) {
        answer = 4 * gl.getParameter(gl.MAX_VARYING_VECTORS);
    }
    if (param == 127) {
        answer = gl.getParameter(gl.MAX_VERTEX_TEXTURE_IMAGE_UNITS);
    }
    if (param == 128) {
        answer = 4 * gl.getParameter(gl.MAX_VERTEX_UNIFORM_VECTORS);
    }
    console.log("[UONGL] getIntParam asked for " + param+" results in " + answer);
    return answer;
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
    var ctx = canvas.getContext("webgl2");
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
    gl.activeTexture(gl.TEXTURE0+texUnit);
}

function native_com_sun_prism_es2_GLContext_nBindFBO(nativeCtxInfo, nativeFBOID) {
    console.log("[UONGL] nBindFBO ctx = "+nativeCtxInfo+", id = "+nativeFBOID);
    var gl = wgl();
    if (nativeFBOID == 0) {
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);
    } else {
        var buffer = buffers[nativeFBOID];
        gl.bindFramebuffer(gl.FRAMEBUFFER, buffer);
    }
}

function native_com_sun_prism_es2_GLContext_nBindTexture(nativeCtxInfo, texId) {
    var gl = wgl();
    var tex = buffers[texId];
    gl.bindTexture(gl.TEXTURE_2DTEXTURE_2D, tex);
}

function native_com_sun_prism_es2_GLContext_nClearBuffers (ctxInfo,
        red, green, blue, alpha,
        clearColor, clearDepth, ignoreScissor){
console.log("UONGL clearBuffers, cc = " + clearColor+", cd = " + clearDepth+", is = " + ignoreScissor);
console.log("TODO!!!");
    var gl = wgl();
    var clearBIT = null;
    if (clearColor) {
        gl.clearColor(red, green, blue, alpha);
        clearBIT = gl.COLOR_BUFFER_BUT;
    }
    if (clearBIT != null) {
        gl.clear(clearBIT);
    }
}

function native_com_sun_prism_es2_GLContext_nCreateFBO (ptr, texId) {
    console.log("[UONGL] ncreateFBO ");
    var gl = wgl();
    var buffer = gl.createFramebuffer();
    var tex = buffers[texId];
    gl.bindFramebuffer(gl.FRAMEBUFFER, buffer)
    gl.framebufferTexture2D(gl.FRAMEBUFFER, gl.COLOR_ATTACHMENT0, gl.TEXTURE_2D, tex, 0);
console.log("[UONGL] createFBO will return buffer " + buffer);
    bufferIdx++;
    buffers[bufferIdx] = buffer;
    return bufferIdx;
}

function native_com_sun_prism_es2_GLContext_nCreateIndexBuffer16 (ptr, data, n) {
    var gl = wgl();
    var buffer = gl.createBuffer();
    console.log("[UONGL] ncreateIndexBuffer16, n = "+n);
    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, buffer);
    gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, data, gl.STATIC_DRAW);
    console.log("[UONGL] BUFFER will return " + buffer);
    bufferIdx++;
    buffers[bufferIdx] = buffer;
    return bufferIdx;
}

function native_com_sun_prism_es2_GLContext_nCreateTexture (ptr, width, height) {
    var gl = wgl();
    console.log("[UONGL] ncreateTexture w = "+width+", h = "+height);
    var texture = gl.createTexture();
    // gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, width, height, 0, gl.RGBA, gl.UNSIGNED_BYTE, null);
    bufferIdx++;
    buffers[bufferIdx] = texture;
    return bufferIdx;
}

function native_com_sun_prism_es2_GLContext_nEnableVertexAttributes(ptr){
    var gl = wgl();
    for (i = 0; i < 4; i++) {
        gl.enableVertexAttribArray(i);
    }
    console.log("[UONGL] nEnableVertexAttr DONE");
}

function native_com_sun_prism_es2_GLContext_nGenAndBindTexture(ptr){
    var gl = wgl();
    var texture = gl.createTexture();
    var tid = buff(texture);
    gl.bindTexture(gl.TEXTURE_2D, texture);
    return tid;

}
function native_com_sun_prism_es2_GLContext_nPixelStorei(pname, value) {
    var gl = wgl();
    var name = null;
    if (pname == 60) name = gl.UNPACK_ALIGNMENT;
    if (pname == 61) name = gl.UNPACK_ROW_LENGTH;
    if (pname == 62) name = gl.UNPACK_SKIP_PIXELS;
    if (pname == 63) name = gl.UNPACK_SKIP_ROWS;
    gl.pixelStorei(name, value);
}

function native_com_sun_prism_es2_GLContext_nSetIndexBuffer(ptr, bufferId ) {
    var gl = wgl();
    var buffer = buffers[bufferId];
    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, buffer);
    console.log("[UONGL] nSetIndexBuffer done to buffer "+ buffer);
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
