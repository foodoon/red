package guda.red.dao;

import guda.red.dao.domain.TemplateDO;
import guda.red.dao.domain.TemplateDOCriteria;
import java.util.List;

public interface TemplateDOMapper {
    int countByExample(TemplateDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TemplateDO record);

    int insertSelective(TemplateDO record);

    List<TemplateDO> selectByExampleWithBLOBs(TemplateDOCriteria example);

    List<TemplateDO> selectByExample(TemplateDOCriteria example);

    TemplateDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TemplateDO record);

    int updateByPrimaryKeyWithBLOBs(TemplateDO record);

    int updateByPrimaryKey(TemplateDO record);
}