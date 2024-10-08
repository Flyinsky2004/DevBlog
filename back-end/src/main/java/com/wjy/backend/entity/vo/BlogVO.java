package com.wjy.backend.entity.vo;

import com.wjy.backend.entity.pojo.Blog;
import lombok.Data;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 20:41
 */
//View Object
@Data //View Object VO
public class BlogVO {
    private Blog blog;
    private String username, avator;
    private Boolean isLiked, isFav;

    public BlogVO(Blog blog, String username, String avator, Boolean isLiked, Boolean isFav) {
        this.blog = blog;
        this.username = username;
        this.avator = avator;
        this.isLiked = isLiked;
        this.isFav = isFav;
    }

    public BlogVO(Blog blog, String username, String avator) {
        this.blog = blog;
        this.username = username;
        this.avator = avator;
    }
}
