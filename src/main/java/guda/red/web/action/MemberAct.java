package guda.red.web.action;

import guda.red.biz.TaobaoBuyerBiz;
import guda.red.common.security.AppContexHolder;
import guda.red.dao.domain.TaobaoBuyerDO;
import guda.red.web.form.MemberForm;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

/**
 * Created by foodoon on 2015/2/3.
 */
@Controller
public class MemberAct {

    @Autowired
    private TaobaoBuyerBiz taobaoBuyerBiz;

    @RequestMapping(value = "member/list.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap, Map<String, Object> model) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        baseQuery.setPageSize(pageSize);
        modelMap.put("query", baseQuery);
        BizResult bizResult = taobaoBuyerBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "member/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "member/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, MemberForm memberForm,
                         BindingResult result, Map<String, Object> model) {
        return "member/create.vm";
    }

    @RequestMapping(value = "member/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap, @Valid MemberForm memberForm,
                           BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            return "member/create.vm";
        }
        TaobaoBuyerDO taobaoBuyerDO = memberForm.toDO();
        taobaoBuyerDO.setTaobaoSellerId(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId());
        taobaoBuyerDO.setGmtCreated(new Date());
        BizResult bizResult = taobaoBuyerBiz.create(taobaoBuyerDO);
        if (bizResult.success) {
            return "redirect:/member/list.htm";
        } else {
            return "common/error.vm";
        }

    }
}
