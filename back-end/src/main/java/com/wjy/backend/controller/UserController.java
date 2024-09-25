package com.wjy.backend.controller;

import com.wjy.backend.Entity.pojo.RestBean;
import com.wjy.backend.Entity.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/25 21:25
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("myinfo")
    public RestBean<User> getMyInfo(HttpSession session) {
        if (session.getAttribute("user") == null) return RestBean.failure(401, "未登陆");
        User theUser = (User) session.getAttribute("user");
        return RestBean.success("cg", theUser);
    }

    @GetMapping("logout")
    public RestBean<String> logout(HttpSession session) {
        User logoinUser = (User) session.getAttribute("user");
        if (logoinUser == null) return RestBean.failure(401, "您尚未登陆");
        else {
            session.removeAttribute("user");
            session.invalidate();
        }
        return RestBean.success("登出成功！");
    }
}
