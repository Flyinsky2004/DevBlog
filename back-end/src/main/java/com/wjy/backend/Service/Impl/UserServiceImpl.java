package com.wjy.backend.Service.Impl;

import com.wjy.backend.Entity.pojo.User;
import com.wjy.backend.Mapper.UserMapper;
import com.wjy.backend.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/9 20:09
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource//资源
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }
}
