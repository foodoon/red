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

import guda.red.biz.TaobaoOrderBiz;
import guda.red.dao.domain.TaobaoOrderDO;
import guda.red.web.form.TaobaoOrderEditForm;
import guda.red.web.form.TaobaoOrderForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;


@Controller
public class TaobaoOrderAction {


    @Autowired
    private TaobaoOrderBiz taobaoOrderBiz;

    @RequestMapping(value = "taobaoOrder/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = taobaoOrderBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoOrder/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoOrder/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, TaobaoOrderEditForm taobaoOrderEditForm,
        BindingResult result, Map<String,Object> model) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoOrderBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            taobaoOrderEditForm.initForm(((TaobaoOrderDO)bizResult.data.get("taobaoOrderDO")));
            return "taobaoOrder/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoOrder/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoOrderBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "taobaoOrder/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoOrder/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, TaobaoOrderForm taobaoOrderForm,
        BindingResult result, Map<String,Object> model) {
        return "taobaoOrder/create.vm";
    }

    @RequestMapping(value = "taobaoOrder/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid  TaobaoOrderForm taobaoOrderForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoOrder/create.vm";
        }
        TaobaoOrderDO taobaoOrderDO = taobaoOrderForm.toDO();
        BizResult bizResult = taobaoOrderBiz.create(taobaoOrderDO);
        if (bizResult.success) {
            return "redirect:/taobaoOrder/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoOrder/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid TaobaoOrderEditForm taobaoOrderEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "taobaoOrder/edit.vm";
        }
        TaobaoOrderDO taobaoOrderDO = taobaoOrderEditForm.toDO();
        BizResult bizResult = taobaoOrderBiz.update(taobaoOrderDO);
        if (bizResult.success) {
            return "redirect:/taobaoOrder/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "taobaoOrder/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = taobaoOrderBiz.delete(id);
        if (bizResult.success) {
            return "taobaoOrder/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
