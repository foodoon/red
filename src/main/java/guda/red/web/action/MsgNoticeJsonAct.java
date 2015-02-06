package guda.red.web.action;

import guda.red.biz.vo.AjaxResponce;
import guda.red.common.security.AppContexHolder;
import guda.red.common.util.CommonResultCode;
import guda.red.common.util.ErrorCode;
import guda.red.dao.MsgNoticeDOMapper;
import guda.red.dao.domain.MsgNoticeDO;
import guda.red.dao.domain.MsgNoticeDOCriteria;
import guda.tools.web.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by foodoon on 2015/2/6.
 */
@Controller
public class MsgNoticeJsonAct extends BaseAjaxAction {

    private Logger log = LoggerFactory.getLogger(MsgNoticeJsonAct.class);

    public static final String wait_pay = "wait_pay";
    public static final String recv_item = "recv_item";
    public static final String send_item = "send_item";
    public static final String sign = "sign";
    public static final String positive_comment = "positive_comment";
    public static final String refund = "refund";

    @Autowired
    private MsgNoticeDOMapper msgNoticeDOMapper;

    @RequestMapping(value = "msgNotice/set.json", method = RequestMethod.POST)
    public void set(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        int action = RequestUtil.getInt(request, "action");
        String t = request.getParameter("t");

        if (action < 0 || action > 1 || t == null) {
            ajaxReturn(new AjaxResponce(false, ErrorCode.getMessage(CommonResultCode.PARAM_MISS)), response);
            return;
        }

        MsgNoticeDOCriteria msgNoticeDOCriteria = new MsgNoticeDOCriteria();
        msgNoticeDOCriteria.createCriteria().andTaobaoSellerIdEqualTo(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId());
        try {
            List<MsgNoticeDO> msgNoticeDOs = msgNoticeDOMapper.selectByExample(msgNoticeDOCriteria);
            if (msgNoticeDOs.size() > 0) {
                MsgNoticeDO msgNoticeDO = msgNoticeDOs.get(0);
                if (wait_pay.equals(t)) {
                    msgNoticeDO.setWaitPay(action);
                    msgNoticeDOMapper.updateByPrimaryKeySelective(msgNoticeDO);
                } else if (recv_item.equals(t)) {
                    msgNoticeDO.setRecvItem(action);
                    msgNoticeDOMapper.updateByPrimaryKeySelective(msgNoticeDO);
                } else if (send_item.equals(t)) {
                    msgNoticeDO.setSendItem(action);
                    msgNoticeDOMapper.updateByPrimaryKeySelective(msgNoticeDO);
                } else if (sign.equals(t)) {
                    msgNoticeDO.setSign(action);
                    msgNoticeDOMapper.updateByPrimaryKeySelective(msgNoticeDO);
                } else if (positive_comment.equals(t)) {
                    msgNoticeDO.setPositiveComment(action);
                    msgNoticeDOMapper.updateByPrimaryKeySelective(msgNoticeDO);
                } else if (refund.equals(t)) {
                    msgNoticeDO.setRefund(action);
                    msgNoticeDOMapper.updateByPrimaryKeySelective(msgNoticeDO);
                }
                ajaxReturn(new AjaxResponce(true), response);
                return;
            }
        } catch (Exception e) {
            log.error("", e);
        }
        ajaxReturn(new AjaxResponce(false, ErrorCode.getMessage(CommonResultCode.UNKOWN_ERROR)), response);

    }
}
