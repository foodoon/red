package guda.red.web.form;

import guda.red.dao.domain.TaobaoOrderDO;


public class TaobaoOrderEditForm extends TaobaoOrderForm{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaobaoOrderDO toDO(){
        TaobaoOrderDO taobaoOrderDO  =super.toDO();
        taobaoOrderDO.setId(this.id);
        return taobaoOrderDO;
    }

    public void initForm(TaobaoOrderDO taobaoOrderDO){
        if(taobaoOrderDO == null){
        return ;
    }
}

}
