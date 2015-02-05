package guda.red.dao;

import guda.red.dao.domain.OrderInfoDO;
import guda.red.dao.domain.OrderInfoDOCriteria;
import java.util.List;

public interface OrderInfoDOMapper {
    int countByExample(OrderInfoDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderInfoDO record);

    int insertSelective(OrderInfoDO record);

    List<OrderInfoDO> selectByExample(OrderInfoDOCriteria example);

    OrderInfoDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfoDO record);

    int updateByPrimaryKey(OrderInfoDO record);
}