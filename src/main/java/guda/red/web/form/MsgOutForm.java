package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.MsgOutDO;

import javax.validation.constraints.NotNull;

public class MsgOutForm {
    @NotEmpty(message = "{不能为空}")
    private String msgText;

    @NotNull
    private Date gmtCreate;

    @NotEmpty(message = "{不能为空}")
    private String recv;

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getRecv() {
        return recv;
    }

    public void setRecv(String recv) {
        this.recv = recv;
    }

    public MsgOutDO toDO() {
        MsgOutDO msgOutDO = new MsgOutDO();
        msgOutDO.setMsgText(this.msgText);
        msgOutDO.setGmtCreate(this.gmtCreate);
        msgOutDO.setRecv(this.recv);
        return msgOutDO;
    }

}
