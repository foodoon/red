package guda.red.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import guda.red.biz.AccountBiz;
import guda.red.dao.AccountDOMapper;
import guda.red.dao.domain.AccountDO;
import guda.red.dao.domain.AccountDOCriteria;
import guda.tools.web.page.BaseQuery;
import guda.tools.web.page.BizResult;

public class AccountBizImpl implements AccountBiz{

    private final static Logger logger = LoggerFactory.getLogger(AccountBizImpl.class);

    @Autowired
    private AccountDOMapper accountDOMapper;

    public BizResult detail(long id) {
        BizResult bizResult = new BizResult();
        try{
            AccountDO accountDO = accountDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("accountDO", accountDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query Account error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            AccountDOCriteria accountDOCriteria = new AccountDOCriteria();
            accountDOCriteria.setStartRow(baseQuery.getStartRow());
            accountDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = accountDOMapper.countByExample(accountDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<AccountDO> accountDOList = accountDOMapper.selectByExample(accountDOCriteria);
            bizResult.data.put("accountDOList", accountDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view Account list error", e);
        }
            return bizResult;
     }

    public BizResult delete(long id) {
        BizResult bizResult = new BizResult();
        try {
            accountDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete account error", e);
        }
        return bizResult;
    }

    public BizResult create(AccountDO accountDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = accountDOMapper.insert(accountDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create Account error", e);
        }
        return bizResult;
    }

    public BizResult update(AccountDO accountDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = accountDOMapper.updateByPrimaryKeySelective(accountDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update Account error", e);
        }
        return bizResult;
    }

    }
