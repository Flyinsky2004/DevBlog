package com.wjy.backend.Controller;

import com.wjy.backend.Entity.RestBean;
import com.wjy.backend.Entity.User;
import com.wjy.backend.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/9 20:14
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;

    //get post
    //前端《=====HTTP====》后端 《===NGINX转发https流量 HTTP ===》GET POST
    @PostMapping("login")
    public RestBean<User> login(@RequestParam String username, @RequestParam String password) {
        User loginUser = userService.login(username, password);
        if( loginUser == null ) {
            return RestBean.failure(401,"账号或密码错误");
        }else{
            return RestBean.success("登陆成功",loginUser);
        }
    }
}
