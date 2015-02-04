package guda.red.dao.domain;

import guda.gen.GenField;

import java.util.Date;

public class MsgOutDO {
    private Long id;

    private Long taobaoSellerId;
    @GenField(cn="接收方手机号")
    private String recv;

    private Integer status;
    @GenField(cn="发送时间")
    private Date gmtCreate;
    @GenField(cn="短信内容")
    private String msgText;

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

    public String getRecv() {
        return recv;
    }

    public void setRecv(String recv) {
        this.recv = recv == null ? null : recv.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText == null ? null : msgText.trim();
    }
}