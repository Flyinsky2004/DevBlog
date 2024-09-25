package com.wjy.backend.controller;

import com.wjy.backend.Entity.pojo.RestBean;
import com.wjy.backend.Entity.pojo.User;
import com.wjy.backend.Service.UserService;
import com.wjy.backend.utils.JWTUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/9 20:14
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Resource
    UserService userService;

    //get post
    //前端《=====HTTP====》后端 《===NGINX转发https流量 HTTP ===》GET POST
    //Post 提交表单 提交数据 Get 获取数据
    //Session会话 存服务器 《======》Coockie 浏览器 缓存数据

    /**
     * 1。存储在后端服务器
     * 2.有寿命 有状态
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping("login")
    public RestBean<String> login(@RequestParam String username,
                                  @RequestParam String password,
                                  HttpSession session) {
        User loginUser = userService.login(username, password);
        if( loginUser == null ) {
            return RestBean.failure(401,"账号或密码错误");
        }else{
            loginUser.setPassword("*");
            session.setAttribute("user", loginUser);
            return RestBean.success("登陆成功", JWTUtil.createToken(loginUser));
        }
    }

}
