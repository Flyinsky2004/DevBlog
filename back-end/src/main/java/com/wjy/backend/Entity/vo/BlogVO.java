package com.wjy.backend.Entity.vo;

import com.wjy.backend.Entity.pojo.Blog;
import lombok.Data;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 20:41
 */
//View Object
@Data
public class BlogVO {
    private Blog blog;
    private String username, avator;

    public BlogVO(Blog blog, String username, String avator) {
        this.blog = blog;
        this.username = username;
        this.avator = avator;
    }
}
