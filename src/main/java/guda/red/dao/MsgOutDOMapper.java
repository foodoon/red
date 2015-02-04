package guda.red.dao;

import guda.red.dao.domain.MsgOutDO;
import guda.red.dao.domain.MsgOutDOCriteria;
import java.util.List;

public interface MsgOutDOMapper {
    int countByExample(MsgOutDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgOutDO record);

    int insertSelective(MsgOutDO record);

    List<MsgOutDO> selectByExampleWithBLOBs(MsgOutDOCriteria example);

    List<MsgOutDO> selectByExample(MsgOutDOCriteria example);

    MsgOutDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgOutDO record);

    int updateByPrimaryKeyWithBLOBs(MsgOutDO record);

    int updateByPrimaryKey(MsgOutDO record);
}