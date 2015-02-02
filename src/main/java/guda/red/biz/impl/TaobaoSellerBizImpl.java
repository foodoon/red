package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.TaobaoSellerBiz;
import guda.red.dao.TaobaoSellerDOMapper;
import guda.red.dao.domain.TaobaoSellerDO;
import guda.red.dao.domain.TaobaoSellerDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class TaobaoSellerBizImpl implements TaobaoSellerBiz{

    private final static Logger logger = LoggerFactory.getLogger(TaobaoSellerBizImpl.class);

    @Autowired
    private TaobaoSellerDOMapper taobaoSellerDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            TaobaoSellerDO taobaoSellerDO = taobaoSellerDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("taobaoSellerDO", taobaoSellerDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query TaobaoSeller error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            TaobaoSellerDOCriteria taobaoSellerDOCriteria = new TaobaoSellerDOCriteria();
            taobaoSellerDOCriteria.setStartRow(baseQuery.getStartRow());
            taobaoSellerDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = taobaoSellerDOMapper.countByExample(taobaoSellerDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<TaobaoSellerDO> taobaoSellerDOList = taobaoSellerDOMapper.selectByExample(taobaoSellerDOCriteria);
            bizResult.data.put("taobaoSellerDOList", taobaoSellerDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view TaobaoSeller list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            taobaoSellerDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete taobaoSeller error", e);
        }
        return bizResult;
    }

    public BizResult create(TaobaoSellerDO taobaoSellerDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoSellerDOMapper.insert(taobaoSellerDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create TaobaoSeller error", e);
        }
        return bizResult;
    }

    public BizResult update(TaobaoSellerDO taobaoSellerDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoSellerDOMapper.updateByPrimaryKeySelective(taobaoSellerDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update TaobaoSeller error", e);
        }
        return bizResult;
    }

    }
