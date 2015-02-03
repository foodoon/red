package guda.red.biz.impl;

import com.taobao.api.domain.Trade;
import com.taobao.api.response.TradesSoldGetResponse;
import guda.red.biz.OrderBiz;
import guda.red.biz.taobao.TaobaoSerivce;
import guda.red.common.security.AppContexHolder;
import guda.red.common.util.DateHelper;
import guda.red.dao.TaobaoBuyerDOMapper;
import guda.red.dao.TaobaoOrderDOMapper;
import guda.red.dao.domain.TaobaoBuyerDO;
import guda.red.dao.domain.TaobaoOrderDO;
import guda.red.dao.domain.TaobaoOrderDOCriteria;
import guda.red.dao.domain.TaobaoSellerDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by foodoon on 2015/2/3.
 */
public class OrderBizImpl implements OrderBiz {

    private final static Logger log = LoggerFactory.getLogger(OrderBizImpl.class);
    @Autowired
    private TaobaoSerivce taobaoSerivce;
    @Autowired
    private TaobaoOrderDOMapper taobaoOrderDOMapper;
    @Autowired
    private TaobaoBuyerDOMapper taobaoBuyerDOMapper;

    @Override
    public void loadOrder(String sessionKey) {
        String taobaoUserId = AppContexHolder.getContext().getUserProfile().getTaobaoUserId();
        TaobaoSellerDO taobaoSellerDO = AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO();
        TaobaoOrderDOCriteria taobaoOrderDOCriteria = new TaobaoOrderDOCriteria();
        taobaoOrderDOCriteria.createCriteria().andTaobaoUserIdEqualTo(taobaoUserId);
        taobaoOrderDOCriteria.setOrderByClause("gmt_created desc");
        taobaoOrderDOCriteria.setStartRow(0);
        taobaoOrderDOCriteria.setPageSize(1);
        List<TaobaoOrderDO> taobaoOrderDOs = taobaoOrderDOMapper.selectByExample(taobaoOrderDOCriteria);
        if(taobaoOrderDOs.size() == 0){
            Date startTime = DateHelper.last3MonDay();
            Date endTime = new Date();
            try {
                long pageNo = 1;
                TradesSoldGetResponse tradesSoldGetResponse = taobaoSerivce.queryTradeSold(sessionKey, startTime,endTime, pageNo, 100);
                while(tradesSoldGetResponse.isSuccess()&& tradesSoldGetResponse.getHasNext()){
                    List<Trade> trades = tradesSoldGetResponse.getTrades();
                    if(trades == null){
                        continue;
                    }
                    for(Trade trade:trades) {
                        TaobaoBuyerDO taobaoBuyerDO = new TaobaoBuyerDO();
                        taobaoBuyerDO.setGmtCreated(new Date());
                        taobaoBuyerDO.setTaobaoNick(trade.getBuyerNick());
                        taobaoBuyerDO.setPhone(trade.getReceiverPhone());
                        taobaoBuyerDO.setAddress(trade.getReceiverAddress());
                        taobaoBuyerDO.setTaobaoSellerId(taobaoSellerDO.getId());
                        taobaoBuyerDOMapper.insert(taobaoBuyerDO);


                    }
                    tradesSoldGetResponse = taobaoSerivce.queryTradeSold(sessionKey, startTime, endTime, ++pageNo, 100);

                }
            }catch(Exception e){
                log.error("",e);
            }
        }
    }
}
