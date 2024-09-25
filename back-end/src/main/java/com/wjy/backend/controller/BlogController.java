package com.wjy.backend.controller;

import com.wjy.backend.Entity.pojo.Blog;
import com.wjy.backend.Entity.pojo.RestBean;
import com.wjy.backend.Entity.pojo.User;
import com.wjy.backend.Entity.vo.BlogVO;
import com.wjy.backend.Service.BlogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 20:03
 */
@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Resource
    BlogService blogService;

    @PostMapping("addNew")
    public RestBean<String> addNewBlog(
            HttpSession session,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        User user = (User) session.getAttribute("user");
        if (blogService.addNewBlog(new Blog(title, user.getId(), new Date(), content)) > 0)
            return RestBean.success("发布成功～");
        else return RestBean.failure(503, "出现错误，请联系管理员");
    }

    @GetMapping("getInroduce")
    public RestBean<List<BlogVO>> getInroduceBlog() {
        return RestBean.success("获取成功", blogService.getOrderByBlogs());
    }

    @GetMapping("getBlog")
    public RestBean<BlogVO> getBlog(@RequestParam("id") int id) {
        return RestBean.success("cg", blogService.getBlogById(id));
    }

}
