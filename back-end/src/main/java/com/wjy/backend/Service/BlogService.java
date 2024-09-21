package com.wjy.backend.Service;

import com.wjy.backend.Entity.pojo.Blog;
import com.wjy.backend.Entity.vo.BlogVO;

import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 20:01
 */
public interface BlogService {
    int addNewBlog(Blog blog);

    List<BlogVO> getOrderByBlogs();

    BlogVO getBlogById(int id);
}
