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

import guda.red.biz.AccountBiz;
import guda.red.dao.domain.AccountDO;
import guda.red.web.form.AccountEditForm;
import guda.red.web.form.AccountForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;


@Controller
public class AccountAction {


    @Autowired
    private AccountBiz accountBiz;

    @RequestMapping(value = "account/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = accountBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "account/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "account/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, AccountEditForm accountEditForm,
        BindingResult result, Map<String,Object> model) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = accountBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            accountEditForm.initForm(((AccountDO)bizResult.data.get("accountDO")));
            return "account/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "account/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = accountBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "account/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "account/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, AccountForm accountForm,
        BindingResult result, Map<String,Object> model) {
        return "account/create.vm";
    }

    @RequestMapping(value = "account/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid  AccountForm accountForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "account/create.vm";
        }
        AccountDO accountDO = accountForm.toDO();
        BizResult bizResult = accountBiz.create(accountDO);
        if (bizResult.success) {
            return "redirect:/account/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "account/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid AccountEditForm accountEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "account/edit.vm";
        }
        AccountDO accountDO = accountEditForm.toDO();
        BizResult bizResult = accountBiz.update(accountDO);
        if (bizResult.success) {
            return "redirect:/account/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "account/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = accountBiz.delete(id);
        if (bizResult.success) {
            return "account/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
