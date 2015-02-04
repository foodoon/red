package guda.red.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import guda.red.web.form.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guda.red.biz.TaobaoBuyerBiz;
import guda.red.dao.domain.TaobaoBuyerDO;
import guda.red.web.form.TaobaoBuyerEditForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;


@Controller
public class TaobaoBuyerAction {


    @Autowired
    private TaobaoBuyerBiz taobaoBuyerBiz;

    @RequestMapping(value = "taobaoBuyer/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = taobaoBuyerBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoBuyer/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoBuyer/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, TaobaoBuyerEditForm taobaoBuyerEditForm,
        BindingResult result, Map<String,Object> model) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoBuyerBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            taobaoBuyerEditForm.initForm(((TaobaoBuyerDO)bizResult.data.get("taobaoBuyerDO")));
            return "taobaoBuyer/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoBuyer/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoBuyerBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoBuyer/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoBuyer/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, MemberForm memberForm,
        BindingResult result, Map<String,Object> model) {
        return "taobaoBuyer/create.vm";
    }

    @RequestMapping(value = "taobaoBuyer/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid MemberForm memberForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoBuyer/create.vm";
        }
        TaobaoBuyerDO taobaoBuyerDO = memberForm.toDO();
        BizResult bizResult = taobaoBuyerBiz.create(taobaoBuyerDO);
        if (bizResult.success) {
            return "redirect:/taobaoBuyer/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoBuyer/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid TaobaoBuyerEditForm taobaoBuyerEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoBuyer/edit.vm";
        }
        TaobaoBuyerDO taobaoBuyerDO = taobaoBuyerEditForm.toDO();
        BizResult bizResult = taobaoBuyerBiz.update(taobaoBuyerDO);
        if (bizResult.success) {
            return "redirect:/taobaoBuyer/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoBuyer/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoBuyerBiz.delete(id);
        if (bizResult.success) {
            return "taobaoBuyer/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
