function native_com_sun_prism_es2_GLFactory_nIsGLExtensionSupported(a) {
    console.log("NISGLEXTENSIONSUPPOERTED!!! a = " + a);
    return true;
}

function native_com_sun_glass_ui_web_WebApplication__invokeAndWait(r) {
    console.log("INVOKEANDWAIT!" + r);
    r.run__V();
    console.log("INVOKEANDWAIT DONE!" + r);
}

function native_com_sun_glass_ui_web_WebWindow__setResizable(ptr, resizable) {
    console.log("[UONGL] setResizable, ptr = " + ptr+" and r = " +resizable);
}

function native_com_sun_glass_ui_web_WebWindow__setFocusable(ptr, f) {
    console.log("[UONGL] setFocusable, ptr = " + ptr+" and f = " +f);
}

function native_com_sun_glass_ui_web_WebWindow__setBackground(ptr, r, g, b) {
    console.log("[UONGL] setBGColor, ptr = " + ptr+" and r = " +r+", g = " +g+", b = " +b);
    var red = 256 * r;
    var green = 256 * g;
    var blue = 256*b;
    var canvas = document.getElementById("jfxcanvas");
    var ctx = canvas.getContext("2d");
    ctx.globalCompositeOperation = 'destination-over'
    ctx.fillStyle = 'rgb('+red+','+ green+','+ blue+')';
    ctx.fillRect(0, 0, canvas.width, canvas.height);
}

function native_com_sun_prism_es2_GLContext_nBindFBO(nativeCtxInfo, nativeFBOID) {
    console.log("[UONGL] nBindFBO");
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

function native_com_sun_prism_es2_GLContext_nEnableVertexAttributes(){
    console.log("[UONGL] nEnableVertexAttr ");
}
function native_com_sun_prism_es2_GLContext_nCreateIndexBuffer16 () {
    console.log("[UONGL] ncreateIndexBuffer16 ");
}

