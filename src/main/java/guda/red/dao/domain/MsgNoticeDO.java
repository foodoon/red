package guda.red.dao.domain;

import java.util.Date;

public class MsgNoticeDO {
    private Long id;

    private Long taobaoSellerId;

    private Integer sendItem;

    private Integer recvItem;

    private Integer refund;

    private Integer waitPay;

    private Integer positiveComment;

    private Integer sign;

    private Date gmtCreated;

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

    public Integer getSendItem() {
        return sendItem;
    }

    public void setSendItem(Integer sendItem) {
        this.sendItem = sendItem;
    }

    public Integer getRecvItem() {
        return recvItem;
    }

    public void setRecvItem(Integer recvItem) {
        this.recvItem = recvItem;
    }

    public Integer getRefund() {
        return refund;
    }

    public void setRefund(Integer refund) {
        this.refund = refund;
    }

    public Integer getWaitPay() {
        return waitPay;
    }

    public void setWaitPay(Integer waitPay) {
        this.waitPay = waitPay;
    }

    public Integer getPositiveComment() {
        return positiveComment;
    }

    public void setPositiveComment(Integer positiveComment) {
        this.positiveComment = positiveComment;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}