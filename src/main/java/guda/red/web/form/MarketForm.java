package guda.red.web.form;

/**
 * Created by foodoon on 2015/2/3.
 */
public class MarketForm {

    private int sendType;
    private String orderType;
    private String recvPhone;
    private String testPhone;

    private String msgText;
    private int useSign;

    public int getUseSign() {
        return useSign;
    }

    public void setUseSign(int useSign) {
        this.useSign = useSign;
    }

    public int getSendType() {
        return sendType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTestPhone() {
        return testPhone;
    }

    public void setTestPhone(String testPhone) {
        this.testPhone = testPhone;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
}
