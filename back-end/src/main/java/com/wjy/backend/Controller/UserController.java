package com.wjy.backend.Controller;

import com.wjy.backend.Entity.RestBean;
import com.wjy.backend.Entity.User;
import com.wjy.backend.Service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

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
    //Post 提交表单 提交数据 Get 获取数据
    //Session会话 存服务器 《======》Coockie 浏览器 缓存数据
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
            return RestBean.success("登陆成功", "登陆成功");
        }
    }

    @GetMapping("myinfo")
    public RestBean<User> getMyInfo(HttpSession session) {
        if (session.getAttribute("user") == null) return RestBean.failure(401, "未登陆");
        User theUser = (User) session.getAttribute("user");
        return RestBean.success("cg", theUser);
    }
}
