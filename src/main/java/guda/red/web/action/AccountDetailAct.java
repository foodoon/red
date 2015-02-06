package guda.red.web.action;

import guda.red.biz.AccountDetailBiz;
import guda.red.biz.query.AccountDetailQuery;
import guda.red.common.security.AppContexHolder;
import guda.red.dao.AccountDOMapper;
import guda.red.dao.AccountDetailDOMapper;
import guda.red.dao.domain.*;
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
 * Created by foodoon on 2015/2/6.
 */
@Controller
public class AccountDetailAct {

    @Autowired
    private AccountDetailBiz accountDetailBiz ;

    @Autowired
    private AccountDOMapper accountDOMapper;

    @RequestMapping(value = "account/accountList.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap,  Map<String,Object> model) {
        TaobaoSellerDO taobaoSellerDO = AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO();
        AccountDOCriteria accountDOCriteria = new AccountDOCriteria();
        accountDOCriteria.createCriteria().andTaobaoSellerIdEqualTo(taobaoSellerDO.getId());
        List<AccountDO> accountDOs = accountDOMapper.selectByExample(accountDOCriteria);
        if(accountDOs.size() == 0){
            return "common/error.vm";
        }
        long accountId = accountDOs.get(0).getId();
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        AccountDetailQuery accountDetailQuery = new AccountDetailQuery();
        accountDetailQuery.setAccountId(accountId);
        accountDetailQuery.setPageNo(pageId);
        accountDetailQuery.setPageSize(pageSize);
        modelMap.put("query",accountDetailQuery);

        BizResult bizResult = accountDetailBiz.list(accountDetailQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
        }
        return "account/accountList.vm";
    }

}
