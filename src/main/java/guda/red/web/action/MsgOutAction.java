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

import guda.red.biz.MsgOutBiz;
import guda.red.dao.domain.MsgOutDO;
import guda.red.web.form.MsgOutEditForm;
import guda.red.web.form.MsgOutForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;


@Controller
public class MsgOutAction {


    @Autowired
    private MsgOutBiz msgOutBiz;

    @RequestMapping(value = "msgOut/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = msgOutBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "msgOut/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "msgOut/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, MsgOutEditForm msgOutEditForm,
        BindingResult result, Map<String,Object> model) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = msgOutBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            msgOutEditForm.initForm(((MsgOutDO)bizResult.data.get("msgOutDO")));
            return "msgOut/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "msgOut/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = msgOutBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "msgOut/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "msgOut/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, MsgOutForm msgOutForm,
        BindingResult result, Map<String,Object> model) {
        return "msgOut/create.vm";
    }

    @RequestMapping(value = "msgOut/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid  MsgOutForm msgOutForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "msgOut/create.vm";
        }
        MsgOutDO msgOutDO = msgOutForm.toDO();
        BizResult bizResult = msgOutBiz.create(msgOutDO);
        if (bizResult.success) {
            return "redirect:/msgOut/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "msgOut/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid MsgOutEditForm msgOutEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "msgOut/edit.vm";
        }
        MsgOutDO msgOutDO = msgOutEditForm.toDO();
        BizResult bizResult = msgOutBiz.update(msgOutDO);
        if (bizResult.success) {
            return "redirect:/msgOut/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "msgOut/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        long id = RequestUtil.getLong(request, "id");
        BizResult bizResult = msgOutBiz.delete(id);
        if (bizResult.success) {
            return "msgOut/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
