package guda.red.web.action;

import guda.red.common.security.AppContexHolder;
import guda.red.dao.MsgNoticeDOMapper;
import guda.red.dao.domain.MsgNoticeDO;
import guda.red.dao.domain.MsgNoticeDOCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by foodoon on 2015/2/2.
 */
@Controller
public class IndexAction {

    @Autowired
    private MsgNoticeDOMapper msgNoticeDOMapper;

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        MsgNoticeDOCriteria msgNoticeDOCriteria = new MsgNoticeDOCriteria();
        msgNoticeDOCriteria.createCriteria().andTaobaoSellerIdEqualTo(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId());

        List<MsgNoticeDO> msgNoticeDOs = msgNoticeDOMapper.selectByExample(msgNoticeDOCriteria);
        if(msgNoticeDOs.size() == 0){
            MsgNoticeDO msgNoticeDO = new MsgNoticeDO();
            msgNoticeDO.setRefund(0);
            msgNoticeDO.setWaitPay(0);
            msgNoticeDO.setPositiveComment(0);
            msgNoticeDO.setSign(0);
            msgNoticeDO.setRecvItem(0);
            msgNoticeDO.setSendItem(0);
            msgNoticeDO.setTaobaoSellerId(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId());
            msgNoticeDO.setGmtCreated(new Date());
            msgNoticeDOMapper.insert(msgNoticeDO);
            modelMap.put("msgNotice",msgNoticeDO);
        }
        else if(msgNoticeDOs.size()>0){
            modelMap.put("msgNotice",msgNoticeDOs.get(0));
        }
        return "index.vm";
    }
}
