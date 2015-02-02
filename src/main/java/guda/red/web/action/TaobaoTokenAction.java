package guda.red.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guda.red.biz.TaobaoTokenBiz;
import guda.red.dao.domain.TaobaoTokenDO;
import guda.red.web.form.TaobaoTokenEditForm;
import guda.red.web.form.TaobaoTokenForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;


@Controller
public class TaobaoTokenAction {


    @Autowired
    private TaobaoTokenBiz taobaoTokenBiz;

    @RequestMapping(value = "taobaoToken/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = taobaoTokenBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoToken/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoToken/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, TaobaoTokenEditForm taobaoTokenEditForm,
        BindingResult result, Map<String,Object> model) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoTokenBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            taobaoTokenEditForm.initForm(((TaobaoTokenDO)bizResult.data.get("taobaoTokenDO")));
            return "taobaoToken/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoToken/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoTokenBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoToken/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoToken/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, TaobaoTokenForm taobaoTokenForm,
        BindingResult result, Map<String,Object> model) {
        return "taobaoToken/create.vm";
    }

    @RequestMapping(value = "taobaoToken/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid  TaobaoTokenForm taobaoTokenForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoToken/create.vm";
        }
        TaobaoTokenDO taobaoTokenDO = taobaoTokenForm.toDO();
        BizResult bizResult = taobaoTokenBiz.create(taobaoTokenDO);
        if (bizResult.success) {
            return "redirect:/taobaoToken/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoToken/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid TaobaoTokenEditForm taobaoTokenEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoToken/edit.vm";
        }
        TaobaoTokenDO taobaoTokenDO = taobaoTokenEditForm.toDO();
        BizResult bizResult = taobaoTokenBiz.update(taobaoTokenDO);
        if (bizResult.success) {
            return "redirect:/taobaoToken/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoToken/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoTokenBiz.delete(id);
        if (bizResult.success) {
            return "taobaoToken/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
