package guda.red.common.util;


import guda.red.common.http.HttpProtocolHandler;
import guda.red.common.http.HttpRequest;
import guda.red.common.http.HttpResponse;
import guda.red.common.http.HttpResultType;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.NameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class AlipayHelper {
    private static final String ALIPAY_GATE_WAY = "https://mapi.alipay.com/gateway.do?";
    private static final String ALIPAY_GATE_WAY_NOTIFY_VERIFY = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static String buildRequestMysign(Map<String, String> paramMap, String sellerKey) {
        String str1 = createQueryString(paramMap);
        return sign(str1, sellerKey);
    }

    private static Map<String, String> appendSign(Map<String, String> paramMap, String sellerKey) {
        Map localMap = paraFilter(paramMap);
        String str = buildRequestMysign(localMap, sellerKey);
        localMap.put("sign", str);
        localMap.put("sign_type", "MD5");
        return localMap;
    }

    public static String buildRequest(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3) {
        Map localMap = appendSign(paramMap, paramString1);
        ArrayList localArrayList = new ArrayList(localMap.keySet());
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATE_WAY + "_input_charset=utf-8\" method=\"" + paramString2 + "\">");
        for (int i = 0; i < localArrayList.size(); i++) {
            String str1 = (String) localArrayList.get(i);
            String str2 = (String) localMap.get(str1);
            localStringBuffer.append("<input type=\"hidden\" name=\"" + str1 + "\" value=\"" + str2 + "\"/>");
        }
        localStringBuffer.append("<input type=\"submit\" value=\"" + paramString3 + "\" style=\"display:none;\"></form>");
        localStringBuffer.append("<script>document.forms['alipaysubmit'].submit();</script>");
        return localStringBuffer.toString();
    }

    public static String buildRequest(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
            throws Exception {
        Map localMap = appendSign(paramMap, paramString3);
        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
        HttpRequest httpRequest = new HttpRequest(HttpResultType.BYTES);
        httpRequest.setCharset(DEFAULT_CHARSET);
        httpRequest.setParameters(buildParam(localMap));
        httpRequest.setUrl(ALIPAY_GATE_WAY + "_input_charset=" + DEFAULT_CHARSET);
        HttpResponse localHttpResponse = httpProtocolHandler.execute(httpRequest, paramString1, paramString2);
        if (localHttpResponse == null)
            return null;
        String str = localHttpResponse.getStringResult();
        return str;
    }

    private static NameValuePair[] buildParam(Map<String, String> paramMap) {
        NameValuePair[] arrayOfNameValuePair = new NameValuePair[paramMap.size()];
        int i = 0;
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext()) {
            Entry localEntry = (Entry) localIterator.next();
            arrayOfNameValuePair[(i++)] = new NameValuePair((String) localEntry.getKey(), (String) localEntry.getValue());
        }
        return arrayOfNameValuePair;
    }

    public static boolean verify(Map<String, String> paramMap, String paramString1, String paramString2) {
        String str1 = "true";
        if (paramMap.get("notify_id") != null) {
            String str2 = paramMap.get("notify_id");
            str1 = appendPartner(str2, paramString1);
        }
        String str2 = "";
        if (paramMap.get("sign") != null)
            str2 = paramMap.get("sign");
        boolean bool = appendCharset(paramMap, str2, paramString2);
        return (bool) && (str1.equals("true"));
    }

    private static boolean appendCharset(Map<String, String> paramMap, String paramString1, String paramString2) {
        Map localMap = paraFilter(paramMap);
        String str = createQueryString(localMap);

        return verify(str, paramString1, paramString2);

    }

    private static String appendPartner(String paramString1, String paramString2) {
        String str = ALIPAY_GATE_WAY_NOTIFY_VERIFY + "&partner=" + paramString2 + "&notify_id=" + paramString1;
        return requestUrl(str);
    }

    private static String requestUrl(String paramString) {
        String str;
        try {
            URL localURL = new URL(paramString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) localURL.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            str = bufferedReader.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        return str;
    }

    public static Map<String, String> paraFilter(Map<String, String> paramMap) {
        HashMap<String, String> map = new HashMap<String, String>();
        if ((paramMap == null) || (paramMap.size() <= 0))
            return map;
        Iterator<String> it = paramMap.keySet().iterator();
        while (it.hasNext()) {
            String str1 = it.next();
            String str2 = paramMap.get(str1);
            if ((str2 != null) && (!str2.equals("")) && (!str1.equalsIgnoreCase("sign")) && (!str1.equalsIgnoreCase("sign_type")))
                map.put(str1, str2);
        }
        return map;
    }

    public static String createQueryString(Map<String, String> paramMap) {
        List<String> paramList = new ArrayList<String>(paramMap.keySet());
        Collections.sort(paramList);
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < paramList.size(); i++) {
            String key = paramList.get(i);
            String val = paramMap.get(key);
            if (i == paramList.size() - 1) {
                buf.append(key).append("=").append(val);
            } else {
                buf.append(key).append("=").append(val).append("&");
            }
        }
        return buf.toString();
    }

    public static String sign(String queryString, String sellerKey) {
        queryString = queryString + sellerKey;
        return DigestUtils.md5Hex(getBytes(queryString));
    }

    public static boolean verify(String queryString, String sign, String code) {
        queryString = queryString + code;
        String str = DigestUtils.md5Hex(getBytes(queryString));
        return str.equals(sign);
    }

    private static byte[] getBytes(String queryString) {

        try {
            return queryString.getBytes(DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
        throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + DEFAULT_CHARSET);
    }
}
