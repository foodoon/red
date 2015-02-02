package guda.red.biz.taobao;

/**
 * Created by foodoon on 2014/12/21.
 */
public class TaobaoAPIConfig {

    public  String appKey         = "21568734";

    public  String appSecret      = "f2d1cc25067242ed494759c1dbf96a95";

    private String             taobaoOauthUrl = "https://oauth.taobao.com/authorize";

    private String             taokenUri      = "https://oauth.taobao.com/token";

    private String             redirectUri    = "http://www.ums365.com/taobao/taobaoCall.htm";

    private String             defaultUrl     = "https://oauth.taobao.com/authorize?response_type=code&client_id=21568734&redirect_uri=http://www.ums365.com/taobao/taobaoCall.htm&state=1212&view=web";

    private String           apiUrl;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getTaobaoOauthUrl() {
        return taobaoOauthUrl;
    }

    public void setTaobaoOauthUrl(String taobaoOauthUrl) {
        this.taobaoOauthUrl = taobaoOauthUrl;
    }

    public String getTaokenUri() {
        return taokenUri;
    }

    public void setTaokenUri(String taokenUri) {
        this.taokenUri = taokenUri;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }
}
