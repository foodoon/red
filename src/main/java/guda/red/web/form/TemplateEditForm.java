package guda.red.web.form;

import guda.red.dao.domain.TemplateDO;


public class TemplateEditForm extends TemplateForm{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TemplateDO toDO(){
        TemplateDO templateDO  =super.toDO();
        templateDO.setId(this.id);
        return templateDO;
    }

    public void initForm(TemplateDO templateDO){
        if(templateDO == null){
        return ;
    }
    this.setTemplateText(templateDO.getTemplateText());
    this.setTemplateName(templateDO.getTemplateName());
}

}
