package com.peanut.jwt_learning.Service;

import com.peanut.jwt_learning.Entity.User;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
public interface TokenService {

    String getToken(User user);

    Boolean checkToken(String token);

}
