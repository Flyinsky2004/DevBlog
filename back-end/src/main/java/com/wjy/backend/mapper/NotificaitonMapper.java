package com.wjy.backend.mapper;

import com.wjy.backend.entity.pojo.Notification;
import com.wjy.backend.entity.pojo.NotificationQueryObject;
import com.wjy.backend.entity.pojo.NotificationRS;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/10/11 20:23
 */
@Mapper
public interface NotificaitonMapper {
    @Insert("INSERT INTO tb_notification (title,content,type,createTime) VALUES " +
            "(#{title},#{content},#{type},#{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertNewNotificaitonData(Notification notification);

    @Insert("INSERT INTO rs_notification (userId,notiId,isRead) VALUES (#{userId},#{notiId},#{isRead})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertNewNotificaitonRS(NotificationRS notificationRS);

    @Select("SELECT COUNT(*) as 'CNT' FROM rs_notification WHERE userId = #{userId};")
    int getUnreadNotificationCountByUserId(Integer userId);

    @Select("SELECT a.id, a.content, a.title, a.createTime, a.type, b.isRead\n" +
            "FROM tb_notification a\n" +
            "INNER JOIN rs_notification b ON a.id = b.notiId\n" +
            "WHERE b.userId = #{userId};")
    List<NotificationQueryObject> getAllNotificationByUserId(Integer userId);

}
