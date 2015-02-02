package guda.red.dao;

import guda.red.dao.domain.TaobaoSellerDO;
import guda.red.dao.domain.TaobaoSellerDOCriteria;
import java.util.List;

public interface TaobaoSellerDOMapper {
    int countByExample(TaobaoSellerDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TaobaoSellerDO record);

    int insertSelective(TaobaoSellerDO record);

    List<TaobaoSellerDO> selectByExample(TaobaoSellerDOCriteria example);

    TaobaoSellerDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaobaoSellerDO record);

    int updateByPrimaryKey(TaobaoSellerDO record);
}