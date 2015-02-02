package guda.red.web.form;

import guda.red.dao.domain.AccountDO;


public class AccountEditForm extends AccountForm{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDO toDO(){
        AccountDO accountDO  =super.toDO();
        accountDO.setId(this.id);
        return accountDO;
    }

    public void initForm(AccountDO accountDO){
        if(accountDO == null){
        return ;
    }
}

}
