package guda.red.dao;

import guda.red.dao.domain.AccountDO;
import guda.red.dao.domain.AccountDOCriteria;
import java.util.List;

public interface AccountDOMapper {
    int countByExample(AccountDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountDO record);

    int insertSelective(AccountDO record);

    List<AccountDO> selectByExample(AccountDOCriteria example);

    AccountDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountDO record);

    int updateByPrimaryKey(AccountDO record);
}