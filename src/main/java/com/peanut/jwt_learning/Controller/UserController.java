package com.peanut.jwt_learning.Controller;

import com.peanut.jwt_learning.Annotation.AuthToken;
import com.peanut.jwt_learning.Annotation.LogAnnotation;
import com.peanut.jwt_learning.Annotation.PassToken;
import com.peanut.jwt_learning.Entity.User;
import com.peanut.jwt_learning.Service.AuthService;
import com.peanut.jwt_learning.Service.UserService;
import com.peanut.jwt_learning.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kenny Liu
 * @version 2019-12-19
 **/

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping("/login")
    @PassToken
    public String login(@RequestBody User login_user){

        User user = userService.one_by_name(login_user.getUsername());
        if(user == null){
            return ResponseUtil.returnBusinessException("用户不存在");
        }else {
            if (authService.checkPassword(login_user.getPassword(), user.getPassword())){
                return ResponseUtil.returnBusinessException("密码错误");
            }else {
                Map<String, Object> result = new HashMap<>();
                result.put("token", authService.getToken(user));
                result.put("uid", user.getId());

                return ResponseUtil.returnJson(result);
            }
        }
    }


    @LogAnnotation
    @GetMapping("/getMessage")
    @AuthToken
    public String getMessage(@RequestHeader(value="uid") String uid){
        return ResponseUtil.returnJson(redisTemplate.opsForValue().get("type") + "-" + uid);
//        return ResponseUtil.returnJson("hello world for jwt。");
    }
}
