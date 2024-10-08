package com.wjy.backend.controller;

import com.wjy.backend.entity.pojo.Blog;
import com.wjy.backend.entity.pojo.RestBean;
import com.wjy.backend.entity.pojo.User;
import com.wjy.backend.entity.vo.BlogVO;
import com.wjy.backend.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
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
            HttpServletRequest request,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        if (blogService.addNewBlog(new Blog(title, (Integer) request.getAttribute("id"), new Date(), content)) > 0)
            return RestBean.success("发布成功～");
        else return RestBean.failure(503, "出现错误，请联系管理员");
    }

    @GetMapping("getInroduce")
    public RestBean<List<BlogVO>> getInroduceBlog() {
        return RestBean.success("获取成功", blogService.getOrderByBlogs());
    }

    @GetMapping("getBlog")
    public RestBean<BlogVO> getBlog(@RequestParam("id") int id,
                                    HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("id");
        return RestBean.success("cg", blogService.getBlogById(id, userId));
    }

    @PostMapping("like")
    public RestBean<String> likeBlog(@RequestParam("id") int id,
                                     HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        String s = blogService.doNewLike(userId, id);
        if (s == null) return RestBean.success("点赞成功！");
        else return RestBean.failure(500, s);
    }

    @PostMapping("unlike")
    public RestBean<String> unlikeBlog(@RequestParam("id") int id,
                                       HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        String s = blogService.deleteLike(userId, id);
        if (s == null) return RestBean.success("取消点赞成功！");
        else return RestBean.failure(500, s);
    }

    @GetMapping("check")
    public RestBean<Integer> checkLikedBlog(@RequestParam("id") int id,
                                            HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("id");
        return RestBean.success("", blogService.checkUserLikedBlog(userId, id));
    }

}
