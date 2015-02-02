package guda.red.dao;

import guda.red.dao.domain.TaobaoOrderDO;
import guda.red.dao.domain.TaobaoOrderDOCriteria;
import java.util.List;

public interface TaobaoOrderDOMapper {
    int countByExample(TaobaoOrderDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TaobaoOrderDO record);

    int insertSelective(TaobaoOrderDO record);

    List<TaobaoOrderDO> selectByExample(TaobaoOrderDOCriteria example);

    TaobaoOrderDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaobaoOrderDO record);

    int updateByPrimaryKey(TaobaoOrderDO record);
}