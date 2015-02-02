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

import guda.red.biz.TaobaoSellerBiz;
import guda.red.dao.domain.TaobaoSellerDO;
import guda.red.web.form.TaobaoSellerEditForm;
import guda.red.web.form.TaobaoSellerForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;


@Controller
public class TaobaoSellerAction {


    @Autowired
    private TaobaoSellerBiz taobaoSellerBiz;

    @RequestMapping(value = "taobaoSeller/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = taobaoSellerBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoSeller/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoSeller/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, TaobaoSellerEditForm taobaoSellerEditForm,
        BindingResult result, Map<String,Object> model) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoSellerBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            taobaoSellerEditForm.initForm(((TaobaoSellerDO)bizResult.data.get("taobaoSellerDO")));
            return "taobaoSeller/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoSeller/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoSellerBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoSeller/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoSeller/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, TaobaoSellerForm taobaoSellerForm,
        BindingResult result, Map<String,Object> model) {
        return "taobaoSeller/create.vm";
    }

    @RequestMapping(value = "taobaoSeller/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid  TaobaoSellerForm taobaoSellerForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoSeller/create.vm";
        }
        TaobaoSellerDO taobaoSellerDO = taobaoSellerForm.toDO();
        BizResult bizResult = taobaoSellerBiz.create(taobaoSellerDO);
        if (bizResult.success) {
            return "redirect:/taobaoSeller/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoSeller/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid TaobaoSellerEditForm taobaoSellerEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoSeller/edit.vm";
        }
        TaobaoSellerDO taobaoSellerDO = taobaoSellerEditForm.toDO();
        BizResult bizResult = taobaoSellerBiz.update(taobaoSellerDO);
        if (bizResult.success) {
            return "redirect:/taobaoSeller/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoSeller/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoSellerBiz.delete(id);
        if (bizResult.success) {
            return "taobaoSeller/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
