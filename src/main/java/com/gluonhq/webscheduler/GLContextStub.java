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

@JavaScriptPrototype(prototype = "", container = "vm.com_sun_prism_es2_GLContext(false)")
final class GLContextStub {

    public GLContextStub() {
    }

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nActiveTexture(ptr, texUnit);",
                    args = {"ptr", "texUnit"})
    private static native void nActiveTexture(long nativeCtxInfo, int texUnit);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nBindFBO(nativeCtxInfo, nativeFBOID);", args = {"nativeCtxInfo", "nativeFBOID"})
    private static native void nBindFBO(long nativeCtxInfo, int nativeFBOID);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nBindTexture(nativeCtxInfo, texID);", args = {"nativeCtxInfo", "texID"})
    private static native void nBindTexture(long nativeCtxInfo, int texID);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nBlendFunc(cf, df);", args = {"cf", "df"})
    private static native void nBlendFunc(int sFactor, int dFactor);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nClearBuffers (ctxInfo, red, green, blue, alpha, clearColor, clearDepth, ignoreScissor);", args = {"ctxInfo", "red", "green", "blue", "alpha", "clearColor", "clearDepth", "ignoreScissor"})
    private static native void nClearBuffers(long nativeCtxInfo,
            float red, float green, float blue, float alpha,
            boolean clearColor, boolean clearDepth, boolean ignoreScissor);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nCompileShader(ptr, src, vert);", args = {"ptr", "src", "vert"})
    private static native int nCompileShader(long nativeCtxInfo, String src,
            boolean vertex);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nCreateFBO(ptr, texId);", args = {"ptr", "texId"})
    private static native int nCreateFBO(long nativeCtxInfo, int texID);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nCreateIndexBuffer16(ptr, data, n);", args = {"ptr", "data", "n"})
    private static native int nCreateIndexBuffer16(long nativeCtxInfo, short data[], int n);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nCreateProgram(ptr, vertID, fragIDArr, numAttrs, attrs, indexs);", args = {"ptr", "vertID", "fragIDArr", "numAttrs", "attrs", "indexs"})
    private static native int nCreateProgram(long nativeCtxInfo,
            int vertexShaderID, int[] fragmentShaderID,
            int numAttrs, String[] attrs, int[] indexs);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nCreateTexture(ptr, width, height);", args = {"ptr", "width", "height"})
    private static native int nCreateTexture(long nativeCtxInfo, int width,
            int height);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nDrawIndexedQuads(ptr, numVertices, dataf, datab);", args = {"ptr", "numVertices", "dataf", "datab"})
    private static native void nDrawIndexedQuads(long nativeCtxInfo, int numVertices, float dataf[], byte datab[]);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nDisableVertexAttributes(ptr);", args = {"ptr"})
    private static native void nDisableVertexAttributes(long nativeCtxInfo);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nEnableVertexAttributes(ptr);", args = {"ptr"})
    private static native void nEnableVertexAttributes(long nativeCtxInfo);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nGenAndBindTexture(0);", args = {})
    private static native int nGenAndBindTexture();

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nGetUniformLocation(ptr, pid, val);", args = {"ptr", "pid", "val"})
    private static native int nGetUniformLocation(long nativeCtxInfo, int programID, String name);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nPixelStorei(pname, value);", args = {"pname", "value"})
    private static native void nPixelStorei(int pname, int param);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nScissorTest(ctx, enable, x, y, w, h);", args = {"ctx", "enable", "x", "y", "w", "h"})
    private static native void nScissorTest(long nativeCtxInfo, boolean enable, int x, int y, int w, int h);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nSetIndexBuffer(ptr, bufferId);", args = {"ptr", "bufferId"})
    private static native void nSetIndexBuffer(long nativeCtxInfo, int buffer);

    @JavaScriptBody(body = "return native_com_sun_prism_es2_GLContext_nTexImage2D0(target, level, internalFormat, width, heigth, border, format, type, pixels, pixelsByteOffset, useMipmap);", args = {"target", "level", "internalFormat", "width", "heigth", "border", "format", "type", "pixels", "pixelsByteOffset", "useMipmap"})
    private static native boolean nTexImage2D0(int target, int level, int internalFormat, int width, int height, int border, int format, int type, Object pixels, int pixelsByteOffset, boolean useMipmap);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUniformMatrix4fv(ptr, loc, transpose, values);", args = {"ptr", "loc", "transpose", "values"})
    private static native void nUniformMatrix4fv(long nativeCtxInfo, int location, boolean transpose, float values[]);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUpdateViewport(ptr, x, y, w, h);", args = {"ptr", "x", "y", "w", "h"})
    private static native void nUpdateViewport(long nativeCtxInfo, int x, int y, int w, int h);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUpdateWrapState(ptr, texID, wrapMode);", args = {"ptr", "texID", "wrapMode"})
    private static native void nUpdateWrapState(long nativeCtxInfo, int texID,
            int wrapMode);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUseProgram(ptr, programId);", args = {"ptr", "programId"})
    private static native void nUseProgram(long nativeCtxInfo, int pID);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nTexSubImage2D0(target, level, xoffset, yoffset, width, heigth, format, type, pixels, pixelsByteOffset);", args = {"target", "level", "xoffset", "yoffset", "width", "heigth", "format", "type", "pixels", "pixelsByteOffset"})
    private static native void nTexSubImage2D0(int target, int level,
            int xoffset, int yoffset, int width, int height, int format,
            int type, Object pixels, int pixelsByteOffset);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nTexParamsMinMax(min, max);", args = {"min", "max"})
    private static native void nTexParamsMinMax(int min, int max);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUniform1i(ptr, loc, v0);", args = {"ptr", "loc", "v0"})
    private static native void nUniform1i(long nativeCtxInfo, int location, int v0);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUniform1f(ptr, loc, v0);", args = {"ptr", "loc", "v0"})
    private static native void nUniform1f(long nativeCtxInfo, int location, float v0);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUniform2f(ptr, loc, v0, v1);", args = {"ptr", "loc", "v0", "v1"})
    private static native void nUniform2f(long nativeCtxInfo, int location, float v0, float v1);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUniform3f(ptr, loc, v0, v1, v2);", args = {"ptr", "loc", "v0", "v1", "v2"})
    private static native void nUniform3f(long nativeCtxInfo, int location, float v0, float v1, float v2);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUniform4f(ptr, loc, v0, v1, v2, v3);", args = {"ptr", "loc", "v0", "v1", "v2", "v3"})
    private static native void nUniform4f(long nativeCtxInfo, int location, float v0, float v1, float v2, float v3);

    @JavaScriptBody(body = "native_com_sun_prism_es2_GLContext_nUniform4fv1(ptr, loc, count, value, valueByteOffset);", args = {"ptr", "loc", "count", "value", "valueByteOffset"})
    private static native void nUniform4fv1(long nativeCtxInfo, int location, int count, Object value, int valueByteOffset);

}
