package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;

public class Util {

@JavaScriptBody(args = "r", body =
        "window.setTimeout(function() {\n" +
        "  console.log('[UONGL] WebScheduler will run '+r);\n" + 
        "  r.run__V();\n" +
        "}, 10);\n"
    )
 public static native void schedule(Runnable r);

@JavaScriptBody(args = "r", body =
        "window.setInterval(function() {\n" +
        "  console.log('[UONGL] IntervalScheduler [10Hz] will run '+r);\n" + 
        "  r.run__V();\n" +
        "}, 100);\n"
    )
 public static native void interval(Runnable r);

}
