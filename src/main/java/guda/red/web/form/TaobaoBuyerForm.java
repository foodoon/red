package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.TaobaoBuyerDO;
import javax.validation.constraints.NotNull;

public class TaobaoBuyerForm {

    public TaobaoBuyerDO toDO(){
       TaobaoBuyerDO taobaoBuyerDO  = new TaobaoBuyerDO();
       return taobaoBuyerDO;
}

}
