package guda.red.web.form;

import guda.red.dao.domain.TaobaoBuyerDO;


public class TaobaoBuyerEditForm extends MemberForm {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaobaoBuyerDO toDO(){
        TaobaoBuyerDO taobaoBuyerDO  =super.toDO();
        taobaoBuyerDO.setId(this.id);
        return taobaoBuyerDO;
    }

    public void initForm(TaobaoBuyerDO taobaoBuyerDO){
        if(taobaoBuyerDO == null){
        return ;
    }
}

}
