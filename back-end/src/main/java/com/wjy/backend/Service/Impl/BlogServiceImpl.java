package com.wjy.backend.Service.Impl;

import com.wjy.backend.Entity.pojo.Blog;
import com.wjy.backend.Entity.vo.BlogVO;
import com.wjy.backend.Mapper.BlogMapper;
import com.wjy.backend.Mapper.UserMapper;
import com.wjy.backend.Service.BlogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 20:01
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    BlogMapper blogMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public int addNewBlog(Blog blog) {
        return blogMapper.insertNewBlog(blog);
    }

    @Override
    public List<BlogVO> getOrderByBlogs() {
        List<BlogVO> result = new ArrayList<>();
        for (Blog blog : blogMapper.getBlogsOrderById()) {
            result.add(new BlogVO(blog, userMapper.getUsernameById(blog.getAuthorId())));
        }
        return result;
    }

    @Override
    public BlogVO getBlogById(int id) {
        Blog blog = blogMapper.getBlogById(id);
        return new BlogVO(blog, userMapper.getUsernameById(blog.getAuthorId()));
    }
}
