package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.TemplateBiz;
import guda.red.dao.TemplateDOMapper;
import guda.red.dao.domain.TemplateDO;
import guda.red.dao.domain.TemplateDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class TemplateBizImpl implements TemplateBiz{

    private final static Logger logger = LoggerFactory.getLogger(TemplateBizImpl.class);

    @Autowired
    private TemplateDOMapper templateDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            TemplateDO templateDO = templateDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("templateDO", templateDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query Template error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            TemplateDOCriteria templateDOCriteria = new TemplateDOCriteria();
            templateDOCriteria.setStartRow(baseQuery.getStartRow());
            templateDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = templateDOMapper.countByExample(templateDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<TemplateDO> templateDOList = templateDOMapper.selectByExample(templateDOCriteria);
            bizResult.data.put("templateDOList", templateDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view Template list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            templateDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete template error", e);
        }
        return bizResult;
    }

    public BizResult create(TemplateDO templateDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = templateDOMapper.insert(templateDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create Template error", e);
        }
        return bizResult;
    }

    public BizResult update(TemplateDO templateDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = templateDOMapper.updateByPrimaryKeySelective(templateDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update Template error", e);
        }
        return bizResult;
    }

    }
