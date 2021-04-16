package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;

public class Util {

@JavaScriptBody(args = "r", body =
        "window.setTimeout(function() {\n" +
        "  console.log('IN SCHEDULER, run '+r);\n" + 
        "  r.run__V();\n" +
        "  console.log('IN SCHEDULER, done with running '+r);\n" + 
        "}, 50);\n"
    )
 public static native void schedule(Runnable r);

@JavaScriptBody(args = "r", body =
        "window.setInterval(function() {\n" +
        "  console.log('IN Interval SCHEDULER, run '+r);\n" + 
        "  r.run__V();\n" +
        "  console.log('IN Interval SCHEDULER, done with running '+r);\n" + 
        "}, 10);\n"
    )
 public static native void interval(Runnable r);

    public static void uploadPixels(long ptr, int[] pixels, int offset, int width, int height) {
        System.err.println("[WEBUTIL] uploadPixels called, ptr = " + ptr);
        System.err.println("[WEBUTIL] uploadPixels called, width = " + width);
        System.err.println("[WEBUTIL] uploadPixels called, height = " + height);
        System.err.println("[WEBUTIL] uploadPixels called, offset = " + offset);
        System.err.println("[WEBUTIL] uploadPixels called, pixels = " + pixels);
        System.err.println("[WEBUTIL] uploadPixels called, pixels.length = " + pixels.length);
int zero = 0;
for (int i =0; i < pixels.length; i++) {
if (pixels[i] != 0) zero++;
}
System.err.println("[WEBUTIL] nonzero pix: " + zero);
        Object id = getImageData();
for (int i = 0; i < 4*width; i++) {
pixels[i] =(int)(256* Math.random());
    setPixel(id, i, pixels[i]);
}
        storeImageData(id, width, height);
        // doUploadPixels(pixels, width, height);
        System.err.println("WEBUTIL] uploadPixels DONE");
    }

    @JavaScriptBody(args = {"data", "index", "value"}, body =
        "data[index] = value;\n")
    public static native void setPixel(Object data, int idx, int val);

  

    @JavaScriptBody(args = {}, body =
        "var canvas = document.getElementById('jfxcanvas');\n"+
        "var ctx = canvas.getContext('2d');\n"+
        "var imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);\n" +
        "return imageData.data;\n"
    )
    public static native Object getImageData();

    @JavaScriptBody(args = {"o", "width", "height"}, body =
        "var canvas = document.getElementById('jfxcanvas');\n"+
        "var ctx = canvas.getContext('2d');\n"+
        "ctx.putImageData(new ImageData(o,width,height), 0, 0);\n"
    )
    public static native Object storeImageData(Object o, int width, int height);


    @JavaScriptBody(args = {"p", "width", "height"}, body =
        "var canvas = document.getElementById('jfxcanvas');\n"+
        "var ctx = canvas.getContext('2d');\n"+
        "var imageData = new ImageData(p, width, height);\n"+
        // "var imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);\n" +

        // "for (i=0; i < 10000;i++) {imageData.data[i] = p[i];}\n" +
        "ctx.putImageData(imageData, 0, 0);\n"
    )
    public static native void doUploadPixels(int[] pixels, int width, int height);
}
