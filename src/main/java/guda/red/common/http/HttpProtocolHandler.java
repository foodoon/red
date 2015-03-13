package guda.red.common.http;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class HttpProtocolHandler {

    private static String charset = "UTF-8";
    private static HttpProtocolHandler httpProtocolHandler = new HttpProtocolHandler();
    private int connectTimeout = 8000;
    private int timeOut = 30000;
    private int connectionTimeout = 60000;
    private int maxConnectionsPerHost = 30;
    private int maxTotalConnections = 80;
    private HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();

    private HttpProtocolHandler() {
        this.httpConnectionManager.getParams().setDefaultMaxConnectionsPerHost(this.maxConnectionsPerHost);
        this.httpConnectionManager.getParams().setMaxTotalConnections(this.maxTotalConnections);
        IdleConnectionTimeoutThread idleConnectionTimeoutThread = new IdleConnectionTimeoutThread();
        idleConnectionTimeoutThread.addConnectionManager(this.httpConnectionManager);
        idleConnectionTimeoutThread.setConnectionTimeout(this.connectionTimeout);
        idleConnectionTimeoutThread.start();
    }

    public static HttpProtocolHandler getInstance() {
        return httpProtocolHandler;
    }

    public HttpResponse execute(HttpRequest paramHttpRequest, String paramString1, String paramString2)
            throws HttpException, IOException {
        HttpClient httpClient = new HttpClient(this.httpConnectionManager);
        int i = this.connectTimeout;
        if (paramHttpRequest.getConnectionTimeout() > 0) {
            i = paramHttpRequest.getConnectionTimeout();
        }
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(i);
        int j = this.timeOut;
        if (paramHttpRequest.getTimeout() > 0)
            j = paramHttpRequest.getTimeout();
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(j);
        httpClient.getParams().setConnectionManagerTimeout(3000L);
        String str = paramHttpRequest.getCharset();
        str = str == null ? charset : str;
        HttpMethod httpMethod = null;
        if (paramHttpRequest.getMethod().equals("GET")) {
            httpMethod = new GetMethod(paramHttpRequest.getUrl());
            httpMethod.getParams().setCredentialCharset(str);
            httpMethod.setQueryString(paramHttpRequest.getQueryString());
        } else if ((paramString1.equals("")) && (paramString2.equals(""))) {
            httpMethod = new PostMethod(paramHttpRequest.getUrl());
            ((PostMethod) httpMethod).addParameters(paramHttpRequest.getParameters());
            httpMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=" + str);
        } else {
            httpMethod = new PostMethod(paramHttpRequest.getUrl());
            List paramList = new ArrayList();
            for (int k = 0; k < paramHttpRequest.getParameters().length; k++) {
                paramList.add(new StringPart(paramHttpRequest.getParameters()[k].getName(), paramHttpRequest.getParameters()[k].getValue(), str));
            }
            paramList.add(new FilePart(paramString1, new FilePartSource(new File(paramString2))));
            ((PostMethod) httpMethod).setRequestEntity(new MultipartRequestEntity((Part[]) (paramList).toArray(new Part[0]), new HttpMethodParams()));
        }
        httpMethod.addRequestHeader("User-Agent", "Mozilla/4.0");
        HttpResponse response = new HttpResponse();
        try {
            httpClient.executeMethod(httpMethod);
            if (paramHttpRequest.getResultType().equals(HttpResultType.STRING)) {
                response.setStringResult((httpMethod).getResponseBodyAsString());
            } else if (paramHttpRequest.getResultType().equals(HttpResultType.BYTES)) {
                response.setByteResult(httpMethod.getResponseBody());
            }
            response.setResponseHeaders(httpMethod.getResponseHeaders());
        } catch (UnknownHostException localUnknownHostException) {
            return null;
        } catch (IOException localIOException) {
            return null;
        } catch (Exception localException) {
            return null;
        } finally {
            httpMethod.releaseConnection();
        }
        return response;
    }

    protected String toString(NameValuePair[] valuePairs) {
        if ((valuePairs == null) || (valuePairs.length == 0))
            return "null";
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < valuePairs.length; i++) {
            NameValuePair pair = valuePairs[i];
            if (i == 0) {
                buff.append(pair.getName() + "=" + pair.getValue());
            } else {
                buff.append("&" + pair.getName() + "=" + pair.getValue());
            }
        }
        return buff.toString();
    }
}

