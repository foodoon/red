package guda.red.web.action;

import guda.red.biz.config.AlipayConfig;
import guda.red.common.util.AlipayHelper;
import guda.red.common.util.RequestHelper;
import guda.tools.web.util.RequestUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by foodoon on 2015/2/5.
 */
@Controller
public class AlipayAct {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private AlipayConfig alipayConfig;

    @RequestMapping(value = {"alipay/pay.htm"})
    public String pay( HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        long fee = RequestUtil.getLong(request,"fee");
        long orderId = RequestUtil.getLong(request,"orderId");
        if(orderId < 1 || fee < 1){
            return "common/error.vm";
        }
        PrintWriter out = null;
        try {
            String aliURL = alipayapi(orderId,fee, request, model);
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.print(aliURL);
        } catch (IOException e) {
            log.error("",e);
        } finally {
            out.close();
        }
        return null;
    }



    @RequestMapping({"/alipay/alipayBack.htm"})
    public String alipayBack(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws UnsupportedEncodingException {
        Map params = new HashMap();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr =
                        valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

        Long orderId = Long.valueOf(Long.parseLong(out_trade_no));
      //  Order order = this.manager.findById(orderId);
//        if (AlipayHelper.verify(params, alipayConfig.getPartner(), alipayConfig.getSellerKey())) {
//            if (trade_status.equals("TRADE_FINISHED")) {
//                order.setPaymentStatus(Integer.valueOf(2));
//                this.manager.updateByUpdater(order);
//                return FrontUtils.showMessage(request, model, "付款成功，请等待发货！");
//            }
//            if (trade_status.equals("TRADE_SUCCESS")) {
//                order.setPaymentStatus(Integer.valueOf(2));
//                this.manager.updateByUpdater(order);
//                return FrontUtils.showMessage(request, model, "付款成功，请等待发货！");
//            }
//        } else {
//            return FrontUtils.showMessage(request, model, "验证失败！");
//        }
//        return FrontUtils.showMessage(request, model, "付款异常！");
        return "/alipay/alipayBack.vm";
    }

    private String alipayapi(Long orderId,long fee, HttpServletRequest request, ModelMap model) {
        String payment_type = "1";
        String notify_url = RequestHelper.getBasePath(request) + "/alipay/alipayBack.htm";
        String return_url = RequestHelper.getBasePath(request) + "/alipay/alipayBack.htm";
        String seller_email = alipayConfig.getSellerEmail();
        String out_trade_no = String.valueOf(orderId);
        String subject = "(" + orderId + ")";
        String total_fee = String.valueOf(fee);
        String body = "(" + orderId + ")";
        String show_url = RequestHelper.getBasePath(request) ;
        String anti_phishing_key = "";
        String exter_invoke_ip = getIpAddr(request);
        Map sParaTemp = new HashMap();
        sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", alipayConfig.getPartner());
        sParaTemp.put("_input_charset", "utf-8");
        sParaTemp.put("payment_type", payment_type);
        sParaTemp.put("notify_url", notify_url);
        sParaTemp.put("return_url", return_url);
        sParaTemp.put("seller_email", seller_email);
        sParaTemp.put("out_trade_no", out_trade_no);
        sParaTemp.put("subject", subject);
        sParaTemp.put("total_fee", total_fee);
        sParaTemp.put("body", body);
        sParaTemp.put("show_url", show_url);
        sParaTemp.put("anti_phishing_key", anti_phishing_key);
        sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
        String sHtmlText = AlipayHelper.buildRequest(sParaTemp, alipayConfig.getSellerKey(), "get", "确认");
        System.out.println(sHtmlText);

        return sHtmlText;
    }

    public static String getIpAddr(HttpServletRequest paramHttpServletRequest) {
        String str = paramHttpServletRequest.getHeader("X-Real-IP");
        if ((!StringUtils.isBlank(str)) && (!"unknown".equalsIgnoreCase(str)))
            return str;
        str = paramHttpServletRequest.getHeader("X-Forwarded-For");
        if ((!StringUtils.isBlank(str)) && (!"unknown".equalsIgnoreCase(str))) {
            int i = str.indexOf(',');
            if (i != -1)
                return str.substring(0, i);
            return str;
        }
        return paramHttpServletRequest.getRemoteAddr();
    }
}
