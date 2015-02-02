package guda.red.dao;

import guda.red.dao.domain.TaobaoTokenDO;
import guda.red.dao.domain.TaobaoTokenDOCriteria;
import java.util.List;

public interface TaobaoTokenDOMapper {
    int countByExample(TaobaoTokenDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TaobaoTokenDO record);

    int insertSelective(TaobaoTokenDO record);

    List<TaobaoTokenDO> selectByExample(TaobaoTokenDOCriteria example);

    TaobaoTokenDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaobaoTokenDO record);

    int updateByPrimaryKey(TaobaoTokenDO record);
}