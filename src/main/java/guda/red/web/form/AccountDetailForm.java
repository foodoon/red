package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.AccountDetailDO;
import javax.validation.constraints.NotNull;

public class AccountDetailForm {

    public AccountDetailDO toDO(){
       AccountDetailDO accountDetailDO  = new AccountDetailDO();
       return accountDetailDO;
}

}
