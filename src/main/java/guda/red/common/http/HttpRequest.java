package guda.red.common.http;

import org.apache.commons.httpclient.NameValuePair;

public class HttpRequest {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    private String url = null;
    private String method = "POST";
    private int timeout = 0;
    private int connectionTimeout = 0;
    private NameValuePair[] nameValuePairs = null;
    private String queryString = null;
    private String charset = "UTF-8";
    private String clientIp;
    private HttpResultType httpResultType = HttpResultType.BYTES;

    public HttpRequest(HttpResultType paramHttpResultType) {
        this.httpResultType = paramHttpResultType;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String paramString) {
        this.clientIp = paramString;
    }

    public NameValuePair[] getParameters() {
        return this.nameValuePairs;
    }

    public void setParameters(NameValuePair[] paramArrayOfNameValuePair) {
        this.nameValuePairs = paramArrayOfNameValuePair;
    }

    public String getQueryString() {
        return this.queryString;
    }

    public void setQueryString(String paramString) {
        this.queryString = paramString;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String paramString) {
        this.method = paramString;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int paramInt) {
        this.connectionTimeout = paramInt;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int paramInt) {
        this.timeout = paramInt;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String paramString) {
        this.charset = paramString;
    }

    public HttpResultType getResultType() {
        return this.httpResultType;
    }

    public void setResultType(HttpResultType paramHttpResultType) {
        this.httpResultType = paramHttpResultType;
    }
}

