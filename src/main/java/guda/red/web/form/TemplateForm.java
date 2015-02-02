package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.TemplateDO;
import javax.validation.constraints.NotNull;

public class TemplateForm {

    public TemplateDO toDO(){
       TemplateDO templateDO  = new TemplateDO();
       return templateDO;
}

}
