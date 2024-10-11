package com.wjy.backend.entity.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/10/11 21:51
 */
@Data
public class NotificationQueryObject {
    private Integer id, type;
    private Boolean isRead;
    private String title, content;
    private Date createTime;

    public NotificationQueryObject() {
    }
}
