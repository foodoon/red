package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.TaobaoOrderDO;
import javax.validation.constraints.NotNull;

public class TaobaoOrderForm {

    public TaobaoOrderDO toDO(){
       TaobaoOrderDO taobaoOrderDO  = new TaobaoOrderDO();
       return taobaoOrderDO;
}

}
