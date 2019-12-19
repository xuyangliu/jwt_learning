package com.peanut.jwt_learning.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.peanut.jwt_learning.Annotation.AuthToken;
import com.peanut.jwt_learning.Annotation.PassToken;
import com.peanut.jwt_learning.Entity.User;
import com.peanut.jwt_learning.Exception.AuthException;
import com.peanut.jwt_learning.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = null;
        int uid;
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();
        //检查是否有PassToken注释，有则跳过认证。
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解。
        if (method.isAnnotationPresent(AuthToken.class)) {
            AuthToken userLoginToken = method.getAnnotation(AuthToken.class);
            if (userLoginToken.required()) {
                // 1. 验证 header 中的 token 是否存在
                Optional.ofNullable(token)
                        .orElseThrow( () -> new RuntimeException("无token，请重新登录"));
                // 2. 验证 token 格式是否正确。
                try {
                    uid = Integer.parseInt(JWT.decode(token).getAudience().get(0));
                } catch (JWTDecodeException j) {
                    throw new AuthException("token 格式验证失败");
                }
                // 3. 验证 token 中获得的 uid 所对应的 User 是否存在
                user = Optional.ofNullable(userService.one_by_id(uid))
                        .orElseThrow(() -> new RuntimeException("用户不存在，请重新登录"));
                // 4. 验证 token 内容是否正确。
                try {
                    JWT.require(Algorithm.HMAC256(user.getPassword())).build().verify(token);
                } catch (JWTVerificationException e) {
                    throw new AuthException("token 内容验证失败");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
