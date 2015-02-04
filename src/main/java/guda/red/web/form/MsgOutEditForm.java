package guda.red.web.form;

import guda.red.dao.domain.MsgOutDO;


public class MsgOutEditForm extends MsgOutForm{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MsgOutDO toDO(){
        MsgOutDO msgOutDO  =super.toDO();
        msgOutDO.setId(this.id);
        return msgOutDO;
    }

    public void initForm(MsgOutDO msgOutDO){
        if(msgOutDO == null){
        return ;
    }
    this.setMsgText(msgOutDO.getMsgText());
    this.setGmtCreate(msgOutDO.getGmtCreate());
    this.setRecv(msgOutDO.getRecv());
}

}
