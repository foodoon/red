package guda.red.common.http;

import org.apache.commons.httpclient.Header;

import java.io.UnsupportedEncodingException;

public class HttpResponse {
    private Header[] headers;
    private String stringResult;
    private byte[] byteResult;

    public Header[] getResponseHeaders() {
        return this.headers;
    }

    public void setResponseHeaders(Header[] paramArrayOfHeader) {
        this.headers = paramArrayOfHeader;
    }

    public byte[] getByteResult() {
        if (this.byteResult != null)
            return this.byteResult;
        if (this.stringResult != null)
            return this.stringResult.getBytes();
        return null;
    }

    public void setByteResult(byte[] paramArrayOfByte) {
        this.byteResult = paramArrayOfByte;
    }

    public String getStringResult()
            throws UnsupportedEncodingException {
        if (this.stringResult != null)
            return this.stringResult;
        if (this.byteResult != null)
            return new String(this.byteResult, "utf-8");
        return null;
    }

    public void setStringResult(String paramString) {
        this.stringResult = paramString;
    }
}

