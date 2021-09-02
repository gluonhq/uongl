/*
 * Copyright (c) 2021, Gluon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.webscheduler;

import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.core.JavaScriptPrototype;


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
