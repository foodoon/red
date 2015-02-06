package guda.red.web.action;

import guda.red.biz.vo.AjaxResponce;
import guda.red.common.security.AppContexHolder;
import guda.red.common.util.DateHelper;
import guda.red.dao.MsgOutDOMapper;
import guda.red.dao.domain.MsgOutDOCriteria;
import guda.tools.web.page.BizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by foodoon on 15/2/6.
 */
@Controller
public class StatJsonAct extends BaseAjaxAction{

    @Autowired
    private MsgOutDOMapper msgOutDOMapper;

    @RequestMapping(value = "/stat.json", method = RequestMethod.POST)
    public void stat(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        //查询今日发送量，昨日发送量，今日订单，昨日订单
        long sellerId = AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId();
        MsgOutDOCriteria msgOutDOCriteria = new MsgOutDOCriteria();
        msgOutDOCriteria.createCriteria().andGmtCreateBetween(DateHelper.cleanMHS(new Date()),new Date())
        .andTaobaoSellerIdEqualTo(sellerId);
        int todaySendCount = msgOutDOMapper.countByExample(msgOutDOCriteria);

        msgOutDOCriteria = new MsgOutDOCriteria();
        msgOutDOCriteria.createCriteria().andGmtCreateBetween(DateHelper.cleanMHS(DateHelper.getLastDay()),DateHelper.endMHS(DateHelper.getLastDay()))
                .andTaobaoSellerIdEqualTo(sellerId);
        int lastSendCount = msgOutDOMapper.countByExample(msgOutDOCriteria);

        Map<String,Integer> stat = new HashMap<String,Integer>();
        stat.put("todaySendCount",todaySendCount);
        stat.put("lastSendCount",lastSendCount);
        stat.put("todayOrder",0);
        stat.put("lastOrder",0);
        super.ajaxReturn(new AjaxResponce(true,stat),response);


    }
}
