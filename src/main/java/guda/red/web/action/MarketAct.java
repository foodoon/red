package guda.red.web.action;

import guda.red.common.security.AppContexHolder;
import guda.red.common.util.CommonResultCode;
import guda.red.common.util.ErrorCode;
import guda.red.dao.AccountDOMapper;
import guda.red.dao.AccountDetailDOMapper;
import guda.red.dao.domain.AccountDO;
import guda.red.dao.domain.AccountDOCriteria;
import guda.red.web.form.MarketForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by foodoon on 2015/2/3.
 */
@Controller
public class MarketAct {

    @Autowired
    private AccountDOMapper accountDOMapper;
    @Autowired
    private AccountDetailDOMapper accountDetailDOMapper;

    @RequestMapping(value = "market/index.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap, MarketForm marketForm,
                         BindingResult result, Map<String,Object> model) {
        return "market/index.vm";
    }

    @RequestMapping(value = "market/doSend.htm", method = RequestMethod.POST)
    public String doSend(HttpServletRequest request, ModelMap modelMap,  MarketForm marketForm,
                        BindingResult result, Map<String,Object> model) {

        //校验
        if(marketForm.getSendType() == 0){
            if(!StringUtils.hasText(marketForm.getOrderType())){
                result.reject("orderType", ErrorCode.getMessage(CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
            if(!StringUtils.hasText(marketForm.getMsgText())){
                result.reject("msgText", ErrorCode.getMessage(CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
        }else{
            if(!StringUtils.hasText(marketForm.getRecvPhone())){
                result.reject("recvPhone", ErrorCode.getMessage(CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
            if(!StringUtils.hasText(marketForm.getMsgText2())){
                result.reject("msgText2", ErrorCode.getMessage(CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
            String recv = marketForm.getRecvPhone();
            String[] recvArray = recv.split(";");
            if(recvArray.length == 1){
                recvArray = recv.split("；");
            }
            AccountDO accountDO  = queryAccount();
            if(accountDO == null){
                model.put("errorMsg", ErrorCode.getMessage(CommonResultCode.ACCOUNT_NOT_FOUND));
                return "market/sendResult.vm";
            }
            if(accountDO.getAmount() <recvArray.length){
                model.put("errorMsg", ErrorCode.getMessage(CommonResultCode.ACCOUNT_NOT_ENOUGH));
                return "market/sendResult.vm";
            }
            //冻结账户
            accountDO.setFreeze(accountDO.getFreeze() + recvArray.length);
            accountDO.setAmount(accountDO.getAmount() - recvArray.length);
            accountDOMapper.updateByPrimaryKeySelective(accountDO);
            //发送短信
            


        }
        //短信模版渲染


        return "market/sendResult.vm";
    }

    private AccountDO queryAccount(){

        AccountDOCriteria accountDOCriteria = new AccountDOCriteria();
        accountDOCriteria.createCriteria().andTaobaoSellerIdEqualTo(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId());
        List<AccountDO> accountDOs = accountDOMapper.selectByExample(accountDOCriteria);
        if(accountDOs.size()  != 1){
            return null;
        }
        AccountDO accountDO = accountDOs.get(0);
        return accountDO;
    }

}
