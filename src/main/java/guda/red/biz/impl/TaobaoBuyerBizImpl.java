package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.TaobaoBuyerBiz;
import guda.red.dao.TaobaoBuyerDOMapper;
import guda.red.dao.domain.TaobaoBuyerDO;
import guda.red.dao.domain.TaobaoBuyerDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class TaobaoBuyerBizImpl implements TaobaoBuyerBiz{

    private final static Logger logger = LoggerFactory.getLogger(TaobaoBuyerBizImpl.class);

    @Autowired
    private TaobaoBuyerDOMapper taobaoBuyerDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            TaobaoBuyerDO taobaoBuyerDO = taobaoBuyerDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("taobaoBuyerDO", taobaoBuyerDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query TaobaoBuyer error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            TaobaoBuyerDOCriteria taobaoBuyerDOCriteria = new TaobaoBuyerDOCriteria();
            taobaoBuyerDOCriteria.setStartRow(baseQuery.getStartRow());
            taobaoBuyerDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = taobaoBuyerDOMapper.countByExample(taobaoBuyerDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<TaobaoBuyerDO> taobaoBuyerDOList = taobaoBuyerDOMapper.selectByExample(taobaoBuyerDOCriteria);
            bizResult.data.put("taobaoBuyerDOList", taobaoBuyerDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view TaobaoBuyer list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            taobaoBuyerDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete taobaoBuyer error", e);
        }
        return bizResult;
    }

    public BizResult create(TaobaoBuyerDO taobaoBuyerDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoBuyerDOMapper.insert(taobaoBuyerDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create TaobaoBuyer error", e);
        }
        return bizResult;
    }

    public BizResult update(TaobaoBuyerDO taobaoBuyerDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = taobaoBuyerDOMapper.updateByPrimaryKeySelective(taobaoBuyerDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update TaobaoBuyer error", e);
        }
        return bizResult;
    }

    }
