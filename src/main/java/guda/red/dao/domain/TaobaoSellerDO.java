package guda.red.dao.domain;

import java.util.Date;

public class TaobaoSellerDO {
    private Long id;

    private String taobaoUserId;

    private String nick;

    private String sex;

    private Long level;

    private Long score;

    private Long totalNum;

    private Long goodNum;

    private String type;

    private String promotedType;

    private String status;

    private Integer consumerProtection;

    private Integer isGoldenSeller;

    private Date gmtCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaobaoUserId() {
        return taobaoUserId;
    }

    public void setTaobaoUserId(String taobaoUserId) {
        this.taobaoUserId = taobaoUserId == null ? null : taobaoUserId.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Long getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Long goodNum) {
        this.goodNum = goodNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPromotedType() {
        return promotedType;
    }

    public void setPromotedType(String promotedType) {
        this.promotedType = promotedType == null ? null : promotedType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getConsumerProtection() {
        return consumerProtection;
    }

    public void setConsumerProtection(Integer consumerProtection) {
        this.consumerProtection = consumerProtection;
    }

    public Integer getIsGoldenSeller() {
        return isGoldenSeller;
    }

    public void setIsGoldenSeller(Integer isGoldenSeller) {
        this.isGoldenSeller = isGoldenSeller;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}