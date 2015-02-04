package guda.red.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import guda.red.dao.domain.TemplateDO;
import javax.validation.constraints.NotNull;

public class TemplateForm {
                    @NotEmpty(message = "{不能为空}")
            private String templateText;

                    @NotEmpty(message = "{不能为空}")
            private String templateName;

    public String getTemplateText() {
       return templateText;
    }

    public void setTemplateText(String templateText) {
       this.templateText = templateText;
    }
    public String getTemplateName() {
       return templateName;
    }

    public void setTemplateName(String templateName) {
       this.templateName = templateName;
    }

    public TemplateDO toDO(){
       TemplateDO templateDO  = new TemplateDO();
            templateDO.setTemplateText(this.templateText);
                templateDO.setTemplateName(this.templateName);
           return templateDO;
}

}
