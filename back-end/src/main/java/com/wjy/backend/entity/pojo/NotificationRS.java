package com.wjy.backend.entity.pojo;

import lombok.Data;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/10/11 20:22
 */
@Data
public class NotificationRS {
    private Integer id, userId, notiId;
    private boolean isRead;

    public NotificationRS() {
    }

    public NotificationRS(Integer userId, Integer notiId, boolean isRead) {
        this.userId = userId;
        this.notiId = notiId;
        this.isRead = isRead;
    }
}
