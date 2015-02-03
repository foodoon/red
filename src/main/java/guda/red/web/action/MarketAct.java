package guda.red.web.action;

import guda.red.common.util.CommonResultCode;
import guda.red.common.util.ErrorCode;
import guda.red.web.form.MarketForm;
import guda.red.web.form.TaobaoBuyerForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by foodoon on 2015/2/3.
 */
@Controller
public class MarketAct {

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
                result.reject("orderType", ErrorCode.getMessage(CommonResultCode.PARAM_CANNOT_BLANK));
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

        }
        //短信模版渲染


        return "market/sendResult.vm";
    }

}
