package guda.red.web.action;

import guda.red.biz.enums.MsgStatusEnum;
import guda.red.common.security.AppContexHolder;
import guda.red.common.util.CommonResultCode;
import guda.red.common.util.ErrorCode;
import guda.red.common.util.VelocityHelper;
import guda.red.dao.AccountDOMapper;
import guda.red.dao.AccountDetailDOMapper;
import guda.red.dao.MsgOutDOMapper;
import guda.red.dao.TaobaoBuyerDOMapper;
import guda.red.dao.domain.*;
import guda.red.web.common.constans.Constants;
import guda.red.web.common.constans.TemplateConstants;
import guda.red.web.form.MarketForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by foodoon on 2015/2/3.
 */
@Controller
public class MarketAct {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountDOMapper accountDOMapper;
    @Autowired
    private AccountDetailDOMapper accountDetailDOMapper;
    @Autowired
    private TaobaoBuyerDOMapper taobaoBuyerDOMapper;
    @Autowired
    private MsgOutDOMapper msgOutDOMapper;

    @RequestMapping(value = "market/index.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap, MarketForm marketForm,
                         BindingResult result, Map<String,Object> model) {
        marketForm.setSendType(1);
        marketForm.setUseSign(1);
        return "market/index.vm";
    }

    @RequestMapping(value = "market/doSend.htm", method = RequestMethod.POST)
    public String doSend(HttpServletRequest request, ModelMap modelMap,  MarketForm marketForm,
                        BindingResult result, Map<String,Object> model) {

        long sellerId = AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId();
        //校验
        if(marketForm.getSendType() == 0){
            if(!StringUtils.hasText(marketForm.getOrderType())){
                result.rejectValue("orderType", (CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
            if(!StringUtils.hasText(marketForm.getMsgText())){
                result.rejectValue("msgText", (CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
            //TODO 查询账户
        }else{
            if(!StringUtils.hasText(marketForm.getRecvPhone())){
                result.rejectValue("recvPhone",(CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
            if(!StringUtils.hasText(marketForm.getMsgText())){
                result.rejectValue("msgText",(CommonResultCode.PARAM_CANNOT_BLANK));
                return "market/index.vm";
            }
            String recv = marketForm.getRecvPhone();
            String[] recvArray = recv.split(";");
            if(recvArray.length == 1){
                recvArray = recv.split("；");
            }
            AccountDO accountDO  = queryAccount();
            if(accountDO == null){
                model.put(Constants.ERROR_MSG_KEY, ErrorCode.getMessage(CommonResultCode.ACCOUNT_NOT_FOUND));
                return "market/sendResult.vm";
            }
            if(accountDO.getAmount() <recvArray.length){
                model.put(Constants.ERROR_MSG_KEY, ErrorCode.getMessage(CommonResultCode.ACCOUNT_NOT_ENOUGH));
                return "market/sendResult.vm";
            }
            try {
                //冻结账户
                accountDO.setFreeze(accountDO.getFreeze() + recvArray.length);
                accountDO.setAmount(accountDO.getAmount() - recvArray.length);
                accountDOMapper.updateByPrimaryKeySelective(accountDO);
                String text = marketForm.getMsgText();
                if (text.contains(Constants.TEMPLATE_REPLACE_PREFIX)) {
                    text = text.replaceAll(Constants.TEMPLATE_REPLACE_PREFIX, Constants.TEMPLATE_PREFIX);
                    text = text.replaceAll(Constants.TEMPLATE_REPLACE_SUFFIX, Constants.TEMPLATE_SUFFIX);
                }
                //发送短信
                int count = 0;
                for (String s : recvArray) {
                    MsgOutDO msgOutDO = new MsgOutDO();
                    msgOutDO.setTaobaoSellerId(sellerId);
                    msgOutDO.setGmtCreate(new Date());
                    String content = renderMsg(s, text);
                    //TODO 增加shop名
                    if(marketForm.getUseSign() == 1){
                        content  = content + "【" + "】";
                    }
                    count += countText(content);
                    msgOutDO.setMsgText(content);
                    msgOutDO.setRecv(s);
                    msgOutDO.setStatus(MsgStatusEnum.INIT.getValue());
                    msgOutDOMapper.insert(msgOutDO);
                }
                modelMap.put(Constants.SUCCESS_MSG_KEY, "成功发送" + count + "条短信.");
                return "market/sendResult.vm";
            }catch(Exception e){
                modelMap.put(Constants.ERROR_MSG_KEY,ErrorCode.getMessage(CommonResultCode.UNKOWN_ERROR));
                log.error("",e);
            }

        }
        //短信模版渲染


        return "market/sendResult.vm";
    }

    private int countText(String text){
        if(text == null){
            return 0;
        }
        int l = text.length()/66;
        int v = text.length()%66;
        if(v == 0){
            return  l;
        }
        return l+1;
    }

    private String renderMsg(String recvPhone,String text){
        if(text == null || recvPhone == null){
            return null;
        }
        if(!text.contains(Constants.TEMPLATE_PREFIX)){
            return text;
        }
        TaobaoBuyerDOCriteria taobaoBuyerDOCriteria = new TaobaoBuyerDOCriteria();
        taobaoBuyerDOCriteria.createCriteria().andTaobaoSellerIdEqualTo(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId())
        .andPhoneEqualTo(recvPhone);
        List<TaobaoBuyerDO> taobaoBuyerDOs = taobaoBuyerDOMapper.selectByExample(taobaoBuyerDOCriteria);
        Map<String,Object> param = new HashMap<String,Object>();
        if(taobaoBuyerDOs.size()>0){
            TaobaoBuyerDO taobaoBuyerDO = taobaoBuyerDOs.get(0);
            param.put(TemplateConstants.MEMBER_USER_NAME,taobaoBuyerDO.getTaobaoNick());
        }
        try {
            return VelocityHelper.renderString(text, param);
        } catch (Exception e) {
            log.error("解析短信模版错误", e);
        }
        return text;
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
