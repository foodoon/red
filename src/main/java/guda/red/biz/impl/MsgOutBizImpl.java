package guda.red.biz.impl;

import java.util.List;

import guda.red.common.security.AppContexHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.MsgOutBiz;
import guda.red.dao.MsgOutDOMapper;
import guda.red.dao.domain.MsgOutDO;
import guda.red.dao.domain.MsgOutDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class MsgOutBizImpl implements MsgOutBiz{

    private final static Logger logger = LoggerFactory.getLogger(MsgOutBizImpl.class);

    @Autowired
    private MsgOutDOMapper msgOutDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            MsgOutDO msgOutDO = msgOutDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("msgOutDO", msgOutDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query MsgOut error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            MsgOutDOCriteria msgOutDOCriteria = new MsgOutDOCriteria();
            msgOutDOCriteria.createCriteria().andTaobaoSellerIdEqualTo(AppContexHolder.getContext().getUserProfile().getTaobaoSellerDO().getId());
            msgOutDOCriteria.setStartRow(baseQuery.getStartRow());
            msgOutDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = msgOutDOMapper.countByExample(msgOutDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<MsgOutDO> msgOutDOList = msgOutDOMapper.selectByExample(msgOutDOCriteria);
            bizResult.data.put("msgOutDOList", msgOutDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view MsgOut list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            msgOutDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete msgOut error", e);
        }
        return bizResult;
    }

    public BizResult create(MsgOutDO msgOutDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = msgOutDOMapper.insert(msgOutDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create MsgOut error", e);
        }
        return bizResult;
    }

    public BizResult update(MsgOutDO msgOutDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = msgOutDOMapper.updateByPrimaryKeySelective(msgOutDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update MsgOut error", e);
        }
        return bizResult;
    }

    }
