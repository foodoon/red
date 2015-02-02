package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.AccountDO;
import javax.validation.constraints.NotNull;

public class AccountForm {

    public AccountDO toDO(){
       AccountDO accountDO  = new AccountDO();
       return accountDO;
}

}
