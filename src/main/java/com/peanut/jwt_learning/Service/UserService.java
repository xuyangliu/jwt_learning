package com.peanut.jwt_learning.Service;

import com.peanut.jwt_learning.Entity.User;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
public interface UserService {

    User one_by_id(int id);

    User one_by_name(String username);

}
