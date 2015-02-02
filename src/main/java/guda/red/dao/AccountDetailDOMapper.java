package guda.red.dao;

import guda.red.dao.domain.AccountDetailDO;
import guda.red.dao.domain.AccountDetailDOCriteria;
import java.util.List;

public interface AccountDetailDOMapper {
    int countByExample(AccountDetailDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountDetailDO record);

    int insertSelective(AccountDetailDO record);

    List<AccountDetailDO> selectByExample(AccountDetailDOCriteria example);

    AccountDetailDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountDetailDO record);

    int updateByPrimaryKey(AccountDetailDO record);
}