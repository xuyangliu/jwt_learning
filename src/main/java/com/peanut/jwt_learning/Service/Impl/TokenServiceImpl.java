package com.peanut.jwt_learning.Service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.peanut.jwt_learning.Entity.User;
import com.peanut.jwt_learning.Exception.AuthException;
import com.peanut.jwt_learning.Service.TokenService;
import com.peanut.jwt_learning.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserService userService;

    @Override
    public String getToken(User user) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1); // 设置过期时间
        Date expiresDate = nowTime.getTime();

        return JWT.create()
                .withAudience(user.getId().toString())
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    @Override
    public Boolean checkToken(String token) {
        try {
            // 1. 验证 token 格式是否正确。
            int uid = Integer.parseInt(JWT.decode(token).getAudience().get(0));
            // 2. 验证 token 中获得的 uid 所对应的 User 是否存在
            User user = Optional.ofNullable(userService.one_by_id(uid))
                    .orElseThrow(() -> new AuthException("用户不存在，请重新登录"));
            // 3. 验证 token 内容是否正确。
            JWT.require(Algorithm.HMAC256(user.getPassword())).build().verify(token);
        } catch (JWTDecodeException j) {
            throw new AuthException("token 格式验证失败");
        } catch (JWTVerificationException e) {
            throw new AuthException("token 内容验证失败");
        }
        return true;
    }

}
