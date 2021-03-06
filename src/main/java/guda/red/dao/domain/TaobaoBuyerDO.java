package guda.red.dao.domain;

import java.util.Date;

public class TaobaoBuyerDO {
    private Long id;

    private String taobaoUserId;

    private String taobaoNick;

    private Long taobaoSellerId;

    private String email;

    private String phone;

    private String address;

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

    public String getTaobaoNick() {
        return taobaoNick;
    }

    public void setTaobaoNick(String taobaoNick) {
        this.taobaoNick = taobaoNick == null ? null : taobaoNick.trim();
    }

    public Long getTaobaoSellerId() {
        return taobaoSellerId;
    }

    public void setTaobaoSellerId(Long taobaoSellerId) {
        this.taobaoSellerId = taobaoSellerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}