package com.peanut.jwt_learning.Service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.peanut.jwt_learning.Entity.User;
import com.peanut.jwt_learning.Service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(User user) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1);
        Date expiresDate = nowTime.getTime();

        String token="";
        token= JWT.create()
                .withAudience(user.getId().toString())
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(user.getPassword()));
        System.out.println("token:" + token);
        return token;
    }

}
