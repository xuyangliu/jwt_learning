package com.peanut.jwt_learning.Controller;

import com.peanut.jwt_learning.Annotation.AuthToken;
import com.peanut.jwt_learning.Annotation.PassToken;
import com.peanut.jwt_learning.Entity.User;
import com.peanut.jwt_learning.Service.TokenService;
import com.peanut.jwt_learning.Service.UserService;
import com.peanut.jwt_learning.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TokenService tokenService;

    @PassToken
    @PostMapping("/login")
    public String login(@RequestBody User login_user){

        User user = userService.one_by_name(login_user.getUsername());
        if(user == null){
            return ResponseUtil.returnBusinessException("登录失败,用户不存在");
        }else {
            if (!user.getPassword().equals(user.getPassword())){
                return ResponseUtil.returnBusinessException("登录失败,密码错误");
            }else {
                Map<String, Object> result = new HashMap<>();
                String token = tokenService.getToken(user);
                result.put("token", token);
                return ResponseUtil.returnJson(result);
            }
        }
    }

    @AuthToken
    @GetMapping("/getMessage")
    public Map<String, Object> getMessage(){
        Map<String, Object> result = new HashMap<>();
        result.put("message","你已通过验证");
        return result;
    }
}
