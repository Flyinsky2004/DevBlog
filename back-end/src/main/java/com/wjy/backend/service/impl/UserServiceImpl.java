package com.wjy.backend.service.impl;

import com.wjy.backend.entity.pojo.NotificationQueryObject;
import com.wjy.backend.entity.pojo.User;
import com.wjy.backend.mapper.NotificaitonMapper;
import com.wjy.backend.mapper.UserMapper;
import com.wjy.backend.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/9 20:09
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource//资源
    UserMapper userMapper;
    @Resource
    NotificaitonMapper notificaitonMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int getUnreadNotificationCount(int userId) {
        return notificaitonMapper.getUnreadNotificationCountByUserId(userId);
    }

    @Override
    public List<NotificationQueryObject> getAllUsersNotification(Integer userId) {
        return notificaitonMapper.getAllNotificationByUserId(userId);
    }


}
