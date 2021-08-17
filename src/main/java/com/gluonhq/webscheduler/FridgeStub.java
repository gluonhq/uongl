package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;
import com.sun.javafx.sg.web.Fridge;


@JavaScriptPrototype(prototype = "", container = "vm.com_sun_javafx_sg_web_Fridge(false)")
final class FridgeStub {
    public FridgeStub() {
    }

    @JavaScriptBody(body = "var el = document.createElement(tag);\n " +
                           "var t = document.createTextNode('hellofx')\n" +
                           "el.appendChild(t);\n" + 
                           "window.document.head.appendChild(el);\n" +
                           "var uuid = el.getAttribute('id');\n return uuid;",
                    args = {"tag"})
    private static native String createBckElement(String tag);


    @JavaScriptBody(body = "var divEl = document.createElement('div');\n " +
                           "divEl.setAttribute('id', id);\n" +
                           "divEl.style.position='absolute';\n" +
                           "window.document.body.appendChild(divEl);\n",
                    args = {"id"})
    private static native void createBckTextElement(String id);

    @JavaScriptBody(body = "var divEl = document.getElementById(id);\n " +
                           "divEl.innerHTML=text;\n",
                    args = {"id", "text"})
    private static native void setBckInnerText(String id, String text);

    @JavaScriptBody(body = "var divEl = document.getElementById(id);\n " +
                           "var totVal = val + document.getElementById('jfxcanvas').getBoundingClientRect().left;\n" +
                           "var pleft = totVal+'px';\n" +
                           "divEl.style.left=pleft;\n",
                    args = {"id", "val"})
    private static native void setDivLeft(String id, float val);

    @JavaScriptBody(body = "var divEl = document.getElementById(id);\n " +
                           "var totVal = val + document.getElementById('jfxcanvas').getBoundingClientRect().top;\n" +
                           "var ptop = totVal+'px';\n" +
                           "divEl.style.top=ptop;\n",
                    args = {"id", "val"})
    private static native void setDivTop(String id, float val);


}
