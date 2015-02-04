package guda.red.dao.domain;

import guda.gen.GenField;

import java.util.Date;

public class TemplateDO {

    private Long id;
    private Long taobaoSellerId;
    @GenField(cn="模版名称")
    private String templateName;

    private Date gmtModified;
    @GenField(cn="模版内容")
    private String templateText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaobaoSellerId() {
        return taobaoSellerId;
    }

    public void setTaobaoSellerId(Long taobaoSellerId) {
        this.taobaoSellerId = taobaoSellerId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getTemplateText() {
        return templateText;
    }

    public void setTemplateText(String templateText) {
        this.templateText = templateText == null ? null : templateText.trim();
    }
}