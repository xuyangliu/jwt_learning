package com.peanut.jwt_learning.Service;

import com.peanut.jwt_learning.Entity.User;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
public interface AuthService {

    String getToken(User user);

    boolean checkToken(String token);

    boolean checkPassword(String login_password, String true_password);

}
