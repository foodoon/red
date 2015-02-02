package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.TaobaoTokenDO;
import javax.validation.constraints.NotNull;

public class TaobaoTokenForm {

    public TaobaoTokenDO toDO(){
       TaobaoTokenDO taobaoTokenDO  = new TaobaoTokenDO();
       return taobaoTokenDO;
}

}
