package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.TaobaoOrderBiz;
import guda.red.dao.TaobaoOrderDOMapper;
import guda.red.dao.domain.TaobaoOrderDO;
import guda.red.dao.domain.TaobaoOrderDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class TaobaoOrderBizImpl implements TaobaoOrderBiz{

    private final static Logger logger = LoggerFactory.getLogger(TaobaoOrderBizImpl.class);

    @Autowired
    private TaobaoOrderDOMapper taobaoOrderDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            TaobaoOrderDO taobaoOrderDO = taobaoOrderDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("taobaoOrderDO", taobaoOrderDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query TaobaoOrder error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            TaobaoOrderDOCriteria taobaoOrderDOCriteria = new TaobaoOrderDOCriteria();
            taobaoOrderDOCriteria.setStartRow(baseQuery.getStartRow());
            taobaoOrderDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = taobaoOrderDOMapper.countByExample(taobaoOrderDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<TaobaoOrderDO> taobaoOrderDOList = taobaoOrderDOMapper.selectByExample(taobaoOrderDOCriteria);
            bizResult.data.put("taobaoOrderDOList", taobaoOrderDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view TaobaoOrder list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            taobaoOrderDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete taobaoOrder error", e);
        }
        return bizResult;
    }

    public BizResult create(TaobaoOrderDO taobaoOrderDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoOrderDOMapper.insert(taobaoOrderDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create TaobaoOrder error", e);
        }
        return bizResult;
    }

    public BizResult update(TaobaoOrderDO taobaoOrderDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoOrderDOMapper.updateByPrimaryKeySelective(taobaoOrderDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update TaobaoOrder error", e);
        }
        return bizResult;
    }

    }
