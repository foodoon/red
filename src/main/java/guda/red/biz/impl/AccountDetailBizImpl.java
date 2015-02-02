package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.AccountDetailBiz;
import guda.red.dao.AccountDetailDOMapper;
import guda.red.dao.domain.AccountDetailDO;
import guda.red.dao.domain.AccountDetailDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class AccountDetailBizImpl implements AccountDetailBiz{

    private final static Logger logger = LoggerFactory.getLogger(AccountDetailBizImpl.class);

    @Autowired
    private AccountDetailDOMapper accountDetailDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            AccountDetailDO accountDetailDO = accountDetailDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("accountDetailDO", accountDetailDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query AccountDetail error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            AccountDetailDOCriteria accountDetailDOCriteria = new AccountDetailDOCriteria();
            accountDetailDOCriteria.setStartRow(baseQuery.getStartRow());
            accountDetailDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = accountDetailDOMapper.countByExample(accountDetailDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<AccountDetailDO> accountDetailDOList = accountDetailDOMapper.selectByExample(accountDetailDOCriteria);
            bizResult.data.put("accountDetailDOList", accountDetailDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view AccountDetail list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            accountDetailDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete accountDetail error", e);
        }
        return bizResult;
    }

    public BizResult create(AccountDetailDO accountDetailDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = accountDetailDOMapper.insert(accountDetailDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create AccountDetail error", e);
        }
        return bizResult;
    }

    public BizResult update(AccountDetailDO accountDetailDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = accountDetailDOMapper.updateByPrimaryKeySelective(accountDetailDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update AccountDetail error", e);
        }
        return bizResult;
    }

    }
