package guda.red.web.action;

import guda.red.biz.MsgOutBiz;
import guda.red.common.security.AppContexHolder;
import guda.red.dao.AccountDOMapper;
import guda.red.dao.domain.AccountDO;
import guda.red.dao.domain.AccountDOCriteria;
import guda.red.dao.domain.TaobaoSellerDO;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;
import guda.tools.web.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by foodoon on 2015/2/3.
 */
@Controller
public class AccountAct {

    @Autowired
    private AccountDOMapper accountDOMapper;

    @Autowired
    private MsgOutBiz msgOutBiz;

    @RequestMapping(value = "account/profile.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap,  Map<String,Object> model) {
        TaobaoSellerDO taobaoSellerDO = AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO();
        AccountDOCriteria accountDOCriteria = new AccountDOCriteria();
        accountDOCriteria.createCriteria().andTaobaoSellerIdEqualTo(taobaoSellerDO.getId());
        List<AccountDO> accountDOs = accountDOMapper.selectByExample(accountDOCriteria);
        if(accountDOs.size()>0){
            model.put("account",accountDOs.get(0));
        }
        return "account/profile.vm";
    }

    @RequestMapping(value = "account/sendList.htm", method = RequestMethod.GET)
    public String sendList(HttpServletRequest request, ModelMap modelMap,  Map<String,Object> model) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        baseQuery.setPageSize(pageSize);
        modelMap.put("query",baseQuery);
        BizResult bizResult = msgOutBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
        }
        return "account/sendList.vm";
    }
}
