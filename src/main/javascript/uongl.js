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
    console.log("[UONGL] setFocusable, ptr = " + ptr+" and r = " +r+", g = " +g+", b = " +b);
var red = 256 * r;
var green = 256 * g;
var blue = 256*b;
var canvas = document.getElementById("jfxcanvas");
var ctx = canvas.getContext("2d");
// Add behind elements.
ctx.globalCompositeOperation = 'destination-over'
// Now draw!
ctx.fillStyle = 'color:rgb(red, green, blue)';
ctx.fillRect(0, 0, canvas.width, canvas.height);
}

