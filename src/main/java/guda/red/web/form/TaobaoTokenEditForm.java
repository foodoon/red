package guda.red.web.form;

import guda.red.dao.domain.TaobaoTokenDO;


public class TaobaoTokenEditForm extends TaobaoTokenForm{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaobaoTokenDO toDO(){
        TaobaoTokenDO taobaoTokenDO  =super.toDO();
        taobaoTokenDO.setId(this.id);
        return taobaoTokenDO;
    }

    public void initForm(TaobaoTokenDO taobaoTokenDO){
        if(taobaoTokenDO == null){
        return ;
    }
}

}
