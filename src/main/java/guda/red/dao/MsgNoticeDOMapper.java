package guda.red.dao;

import guda.red.dao.domain.MsgNoticeDO;
import guda.red.dao.domain.MsgNoticeDOCriteria;
import java.util.List;

public interface MsgNoticeDOMapper {
    int countByExample(MsgNoticeDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgNoticeDO record);

    int insertSelective(MsgNoticeDO record);

    List<MsgNoticeDO> selectByExample(MsgNoticeDOCriteria example);

    MsgNoticeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgNoticeDO record);

    int updateByPrimaryKey(MsgNoticeDO record);
}