package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.TaobaoTokenBiz;
import guda.red.dao.TaobaoTokenDOMapper;
import guda.red.dao.domain.TaobaoTokenDO;
import guda.red.dao.domain.TaobaoTokenDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class TaobaoTokenBizImpl implements TaobaoTokenBiz{

    private final static Logger logger = LoggerFactory.getLogger(TaobaoTokenBizImpl.class);

    @Autowired
    private TaobaoTokenDOMapper taobaoTokenDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            TaobaoTokenDO taobaoTokenDO = taobaoTokenDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("taobaoTokenDO", taobaoTokenDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query TaobaoToken error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            TaobaoTokenDOCriteria taobaoTokenDOCriteria = new TaobaoTokenDOCriteria();
            taobaoTokenDOCriteria.setStartRow(baseQuery.getStartRow());
            taobaoTokenDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = taobaoTokenDOMapper.countByExample(taobaoTokenDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<TaobaoTokenDO> taobaoTokenDOList = taobaoTokenDOMapper.selectByExample(taobaoTokenDOCriteria);
            bizResult.data.put("taobaoTokenDOList", taobaoTokenDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view TaobaoToken list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            taobaoTokenDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete taobaoToken error", e);
        }
        return bizResult;
    }

    public BizResult create(TaobaoTokenDO taobaoTokenDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoTokenDOMapper.insert(taobaoTokenDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create TaobaoToken error", e);
        }
        return bizResult;
    }

    public BizResult update(TaobaoTokenDO taobaoTokenDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoTokenDOMapper.updateByPrimaryKeySelective(taobaoTokenDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update TaobaoToken error", e);
        }
        return bizResult;
    }

    }
