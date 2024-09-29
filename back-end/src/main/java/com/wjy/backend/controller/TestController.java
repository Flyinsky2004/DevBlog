package com.wjy.backend.controller;

import com.wjy.backend.entity.pojo.RestBean;
import com.wjy.backend.entity.requestbodies.RegisterBody;
import com.wjy.backend.service.TestService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/25 20:25
 */

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Resource
    TestService testService;


    //GET 获取资源的 返回比较大的对象/数组         前端提交表单较少
    //POST  提交资源的 返回状态吗或字符串         前端提交比较多

    /**
     * /api/test/login
     * RequestParam. urlencodeded-form
     *
     * @return
     */
    @PostMapping("login")
    public String login(@RequestParam("zhanghao") String username,
                        @RequestParam("mima") String password,
                        @RequestParam(value = "zidongdenglu", required = false) Boolean isTrue) {
        System.out.println(username + password);
        return null;
    }

    /**
     * RequestBody ==> json
     *
     * @return
     */
    @PostMapping("register")
    public String register(@RequestBody RegisterBody registerBody) {
        System.out.println(registerBody);
        return null;
    }

    @GetMapping("getUser/{id}")
    public String getSomeOne(@PathVariable Integer id) {
        System.out.println(id);
        return null;
    }

    @GetMapping("sayHello")
    public RestBean<String> sayHello(@RequestParam String name) {
        return RestBean.success(testService.sayHello(name));
    }
}
