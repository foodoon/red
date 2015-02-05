package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.OrderInfoBiz;
import guda.red.dao.OrderInfoDOMapper;
import guda.red.dao.domain.OrderInfoDO;
import guda.red.dao.domain.OrderInfoDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class OrderInfoBizImpl implements OrderInfoBiz{

    private final static Logger logger = LoggerFactory.getLogger(OrderInfoBizImpl.class);

    @Autowired
    private OrderInfoDOMapper orderInfoDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            OrderInfoDO orderInfoDO = orderInfoDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("orderInfoDO", orderInfoDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query OrderInfo error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            OrderInfoDOCriteria orderInfoDOCriteria = new OrderInfoDOCriteria();
            orderInfoDOCriteria.setStartRow(baseQuery.getStartRow());
            orderInfoDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = orderInfoDOMapper.countByExample(orderInfoDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<OrderInfoDO> orderInfoDOList = orderInfoDOMapper.selectByExample(orderInfoDOCriteria);
            bizResult.data.put("orderInfoDOList", orderInfoDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view OrderInfo list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            orderInfoDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete orderInfo error", e);
        }
        return bizResult;
    }

    public BizResult create(OrderInfoDO orderInfoDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = orderInfoDOMapper.insert(orderInfoDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create OrderInfo error", e);
        }
        return bizResult;
    }

    public BizResult update(OrderInfoDO orderInfoDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = orderInfoDOMapper.updateByPrimaryKeySelective(orderInfoDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update OrderInfo error", e);
        }
        return bizResult;
    }

    }
