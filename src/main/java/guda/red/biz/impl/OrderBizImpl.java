package guda.red.biz.impl;

import guda.red.biz.OrderBiz;
import guda.red.biz.taobao.TaobaoSerivce;
import guda.red.common.security.AppContexHolder;
import guda.red.dao.TaobaoOrderDOMapper;
import guda.red.dao.domain.TaobaoOrderDO;
import guda.red.dao.domain.TaobaoOrderDOCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by foodoon on 2015/2/3.
 */
public class OrderBizImpl implements OrderBiz {

    @Autowired
    private TaobaoSerivce taobaoSerivce;
    @Autowired
    private TaobaoOrderDOMapper taobaoOrderDOMapper;

    @Override
    public void loadOrder(String sessionKey) {
        String taobaoUserId = AppContexHolder.getContext().getUserProfile().getTaobaoUserId();
        TaobaoOrderDOCriteria taobaoOrderDOCriteria = new TaobaoOrderDOCriteria();
        taobaoOrderDOCriteria.createCriteria().andTaobaoUserIdEqualTo(taobaoUserId);
        taobaoOrderDOCriteria.setOrderByClause("gmt_created desc");
        taobaoOrderDOCriteria.setStartRow(0);
        taobaoOrderDOCriteria.setPageSize(1);
        List<TaobaoOrderDO> taobaoOrderDOs = taobaoOrderDOMapper.selectByExample(taobaoOrderDOCriteria);
        if(taobaoOrderDOs.size() == 0){
            
        }
    }
}
