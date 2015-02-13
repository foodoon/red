package guda.red.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import guda.mvc.form.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guda.red.biz.TemplateBiz;
import guda.red.dao.domain.TemplateDO;
import guda.red.web.form.TemplateEditForm;
import guda.red.web.form.TemplateForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;


@Controller
public class TemplateAction {


    @Autowired
    private TemplateBiz templateBiz;

    @RequestMapping(value = "template/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        baseQuery.setPageSize(pageSize);
        modelMap.put("query",baseQuery);
        BizResult bizResult = templateBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "template/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "template/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, TemplateEditForm templateEditForm,
        BindingResult result, Map<String,Object> model) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = templateBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            templateEditForm.initForm(((TemplateDO)bizResult.data.get("templateDO")));
            return "template/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "template/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = templateBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "template/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "template/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, TemplateForm templateForm,
        BindingResult result, Map<String,Object> model) {
        return "template/create.vm";
    }

    @Form
    @RequestMapping(value = "template/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid  TemplateForm templateForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "template/create.vm";
        }
        TemplateDO templateDO = templateForm.toDO();
        BizResult bizResult = templateBiz.create(templateDO);
        if (bizResult.success) {
            return "redirect:/template/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @Form
    @RequestMapping(value = "template/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid TemplateEditForm templateEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "template/edit.vm";
        }
        TemplateDO templateDO = templateEditForm.toDO();
        BizResult bizResult = templateBiz.update(templateDO);
        if (bizResult.success) {
            return "redirect:/template/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "template/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = templateBiz.delete(id);
        if (bizResult.success) {
            return "template/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
