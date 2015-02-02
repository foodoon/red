package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.TaobaoSellerDO;
import javax.validation.constraints.NotNull;

public class TaobaoSellerForm {

    public TaobaoSellerDO toDO(){
       TaobaoSellerDO taobaoSellerDO  = new TaobaoSellerDO();
       return taobaoSellerDO;
}

}
