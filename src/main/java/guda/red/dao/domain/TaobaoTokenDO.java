package guda.red.dao.domain;

public class TaobaoTokenDO {
    private Long id;

    private Long taobaoSellerId;

    private String taobaoUserNick;

    private String tokenType;

    private String accessToken;

    private Long expiresIn;

    private Long r1ExpiresIn;

    private Long r2ExpiresIn;

    private Long w1ExpiresIn;

    private Long w2ExpiresIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaobaoSellerId() {
        return taobaoSellerId;
    }

    public void setTaobaoSellerId(Long taobaoSellerId) {
        this.taobaoSellerId = taobaoSellerId;
    }

    public String getTaobaoUserNick() {
        return taobaoUserNick;
    }

    public void setTaobaoUserNick(String taobaoUserNick) {
        this.taobaoUserNick = taobaoUserNick == null ? null : taobaoUserNick.trim();
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType == null ? null : tokenType.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getR1ExpiresIn() {
        return r1ExpiresIn;
    }

    public void setR1ExpiresIn(Long r1ExpiresIn) {
        this.r1ExpiresIn = r1ExpiresIn;
    }

    public Long getR2ExpiresIn() {
        return r2ExpiresIn;
    }

    public void setR2ExpiresIn(Long r2ExpiresIn) {
        this.r2ExpiresIn = r2ExpiresIn;
    }

    public Long getW1ExpiresIn() {
        return w1ExpiresIn;
    }

    public void setW1ExpiresIn(Long w1ExpiresIn) {
        this.w1ExpiresIn = w1ExpiresIn;
    }

    public Long getW2ExpiresIn() {
        return w2ExpiresIn;
    }

    public void setW2ExpiresIn(Long w2ExpiresIn) {
        this.w2ExpiresIn = w2ExpiresIn;
    }
}