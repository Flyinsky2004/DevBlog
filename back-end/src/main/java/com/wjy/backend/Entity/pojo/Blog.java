package com.wjy.backend.Entity.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 19:50
 */
@Data
public class Blog {
    private Integer id, authorId, watches, likes, favourites;
    private String title, content;
    private Date updateDate;
    private short isPublic; // 公开 私密 封禁 0 1 2

    public Blog() {
    }

    public Blog(String title, Integer authorId, Date updateDate, String content) {
        this.title = title;
        this.authorId = authorId;
        this.updateDate = updateDate;
        this.content = content;
    }
}
