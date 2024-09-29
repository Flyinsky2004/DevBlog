package com.wjy.backend.service;

import com.wjy.backend.entity.pojo.User;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/9 20:09
 */
public interface UserService {
    User login(String username, String password);

    User getUserById(int id);
}
