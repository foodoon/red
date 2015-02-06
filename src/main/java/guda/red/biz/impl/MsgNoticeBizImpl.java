package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.MsgNoticeBiz;
import guda.red.dao.MsgNoticeDOMapper;
import guda.red.dao.domain.MsgNoticeDO;
import guda.red.dao.domain.MsgNoticeDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class MsgNoticeBizImpl implements MsgNoticeBiz{

    private final static Logger logger = LoggerFactory.getLogger(MsgNoticeBizImpl.class);

    @Autowired
    private MsgNoticeDOMapper msgNoticeDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            MsgNoticeDO msgNoticeDO = msgNoticeDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("msgNoticeDO", msgNoticeDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query MsgNotice error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            MsgNoticeDOCriteria msgNoticeDOCriteria = new MsgNoticeDOCriteria();
            msgNoticeDOCriteria.setStartRow(baseQuery.getStartRow());
            msgNoticeDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = msgNoticeDOMapper.countByExample(msgNoticeDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<MsgNoticeDO> msgNoticeDOList = msgNoticeDOMapper.selectByExample(msgNoticeDOCriteria);
            bizResult.data.put("msgNoticeDOList", msgNoticeDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view MsgNotice list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            msgNoticeDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete msgNotice error", e);
        }
        return bizResult;
    }

    public BizResult create(MsgNoticeDO msgNoticeDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = msgNoticeDOMapper.insert(msgNoticeDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create MsgNotice error", e);
        }
        return bizResult;
    }

    public BizResult update(MsgNoticeDO msgNoticeDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = msgNoticeDOMapper.updateByPrimaryKeySelective(msgNoticeDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update MsgNotice error", e);
        }
        return bizResult;
    }

    }
