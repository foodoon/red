package guda.red.web.action;

import guda.red.biz.enums.OrderStatusEnum;
import guda.red.common.security.AppContexHolder;
import guda.red.dao.OrderInfoDOMapper;
import guda.red.dao.domain.OrderInfoDO;
import guda.tools.web.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by foodoon on 2015/2/5.
 */
@Controller
public class ChargeAct {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderInfoDOMapper orderInfoDOMapper;

    @RequestMapping(value = "charge/before.htm", method = RequestMethod.POST)
    public String before(HttpServletRequest request, ModelMap modelMap) {
        long fee = RequestUtil.getLong(request, "fee");
        if (fee < 1) {
            return "common/error.vm";
        }
        OrderInfoDO order = new OrderInfoDO();
        order.setStatus(OrderStatusEnum.INIT.getValue());
        order.setTaobaoSellerId(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId());
        order.setFee(fee);
        order.setGmtCreated(new Date());
        order.setGmtModified(new Date());
        try {
            orderInfoDOMapper.insert(order);
            return "redirect:/alipay/pay.htm?fee=" + fee + "&orderId=" + order.getId();
        } catch (Exception e) {
            log.error("", e);
        }

        return "common/error.vm";
    }

}
