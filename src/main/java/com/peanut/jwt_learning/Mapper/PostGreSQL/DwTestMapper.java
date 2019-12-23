package com.peanut.jwt_learning.Mapper.PostGreSQL;

import com.peanut.jwt_learning.Entity.PostGreSQL.DwTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DwTestMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DwTest record);

    int insertSelective(DwTest record);

    DwTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DwTest record);

    int updateByPrimaryKey(DwTest record);
}
