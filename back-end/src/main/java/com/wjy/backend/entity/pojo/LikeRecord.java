package com.wjy.backend.entity.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/10/8 20:02
 */
@Data
public class LikeRecord {
    private Integer id, userId, blogId;
    private Date likeTime;

    public LikeRecord() {
    }
}
