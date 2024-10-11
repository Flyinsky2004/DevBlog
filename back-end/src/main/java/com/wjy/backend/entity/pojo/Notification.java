package com.wjy.backend.entity.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/10/11 20:21
 */
@Data
public class Notification {
    private Integer id, type;
    private String title, content;
    Date createTime;

    public Notification() {
    }

    public Notification(Integer type, String title, String content, Date createTime) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }
}
