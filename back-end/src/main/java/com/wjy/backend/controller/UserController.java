package com.wjy.backend.controller;

import com.wjy.backend.entity.pojo.RestBean;
import com.wjy.backend.entity.pojo.User;
import com.wjy.backend.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Resource
    UserService userService;
    @GetMapping("myinfo")
    public RestBean<User> getMyInfo(HttpServletRequest request) {
        User user = userService.getUserById((Integer) request.getAttribute("id"));
        user.setPassword(null);
        return RestBean.success("cg", user);
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
