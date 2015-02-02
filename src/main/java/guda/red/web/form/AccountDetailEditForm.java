package guda.red.web.form;

import guda.red.dao.domain.AccountDetailDO;


public class AccountDetailEditForm extends AccountDetailForm{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDetailDO toDO(){
        AccountDetailDO accountDetailDO  =super.toDO();
        accountDetailDO.setId(this.id);
        return accountDetailDO;
    }

    public void initForm(AccountDetailDO accountDetailDO){
        if(accountDetailDO == null){
        return ;
    }
}

}
