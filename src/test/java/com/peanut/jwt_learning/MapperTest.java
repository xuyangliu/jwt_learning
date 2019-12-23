package com.peanut.jwt_learning;

import com.peanut.jwt_learning.JwtLearningApplication;
import com.peanut.jwt_learning.Mapper.MySQL.DoctorMapper;
import com.peanut.jwt_learning.Mapper.PostGreSQL.DwTestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Kenny Liu
 * @version 2019-12-23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JwtLearningApplication.class)
public class MapperTest {

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private DwTestMapper dwTestMapper;

    @Test
    public void test(){
        System.out.println(doctorMapper.selectByPrimaryKey(10001));
        System.out.println(dwTestMapper.selectByPrimaryKey(1));
    }
}
