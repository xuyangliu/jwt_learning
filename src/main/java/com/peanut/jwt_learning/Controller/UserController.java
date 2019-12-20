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
            return ResponseUtil.returnBusinessException("用户不存在");
        }else {
            if (!user.getPassword().equals(user.getPassword())){
                return ResponseUtil.returnBusinessException("密码错误");
            }else {
                Map<String, Object> result = new HashMap<>();
                result.put("token", tokenService.getToken(user));

                // 创建session时触发sessionListener的requestInitialized方法
                // 即没有下面这句话，到这里的请求触发不了sessionListener的requestInitialized 方法
                // 但是一般把服务器做成无状态的，即HttpSessionListener只是在此做演示作用。
                // HttpSession session = request.getSession(true);

                return ResponseUtil.returnJson(result);
            }
        }
    }

    @AuthToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return ResponseUtil.returnJson("hello world for jwt。");
    }
}
