package guda.red.dao;

import guda.red.dao.domain.TaobaoBuyerDO;
import guda.red.dao.domain.TaobaoBuyerDOCriteria;
import java.util.List;

public interface TaobaoBuyerDOMapper {
    int countByExample(TaobaoBuyerDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TaobaoBuyerDO record);

    int insertSelective(TaobaoBuyerDO record);

    List<TaobaoBuyerDO> selectByExample(TaobaoBuyerDOCriteria example);

    TaobaoBuyerDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaobaoBuyerDO record);

    int updateByPrimaryKey(TaobaoBuyerDO record);
}