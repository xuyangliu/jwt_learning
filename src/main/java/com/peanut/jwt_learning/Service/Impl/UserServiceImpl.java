package com.peanut.jwt_learning.Service.Impl;

import com.peanut.jwt_learning.Entity.User;
import com.peanut.jwt_learning.Service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User one_by_id(int id) {
        if (id == 1){
            return new User().setId(1).setUsername("kenny").setPassword("e10adc3949ba59abbe56e057f20f883e");
        } else {
            return new User().setId(2).setUsername("mike").setPassword("c33367701511b4f6020ec61ded352059");
        }

    }

    @Override
    public User one_by_name(String username) {
        if (username.equals("kenny")){
            return new User().setId(1).setUsername("kenny").setPassword("e10adc3949ba59abbe56e057f20f883e");
        } else {
            return new User().setId(2).setUsername("mike").setPassword("c33367701511b4f6020ec61ded352059");
        }
    }

}
