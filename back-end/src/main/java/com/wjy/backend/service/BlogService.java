package com.wjy.backend.service;

import com.wjy.backend.entity.pojo.Blog;
import com.wjy.backend.entity.vo.BlogVO;

import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 20:01
 */
public interface BlogService {
    int addNewBlog(Blog blog);

    List<BlogVO> getOrderByBlogs();

    BlogVO getBlogById(int id, int userId);

    String doNewLike(Integer userId, Integer blogId);

    String deleteLike(Integer userId, Integer blogId);

    int checkUserLikedBlog(Integer userId, Integer blogId);
}
