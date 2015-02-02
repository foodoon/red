package guda.red.web.form;

import guda.red.dao.domain.TaobaoSellerDO;


public class TaobaoSellerEditForm extends TaobaoSellerForm{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaobaoSellerDO toDO(){
        TaobaoSellerDO taobaoSellerDO  =super.toDO();
        taobaoSellerDO.setId(this.id);
        return taobaoSellerDO;
    }

    public void initForm(TaobaoSellerDO taobaoSellerDO){
        if(taobaoSellerDO == null){
        return ;
    }
}

}
