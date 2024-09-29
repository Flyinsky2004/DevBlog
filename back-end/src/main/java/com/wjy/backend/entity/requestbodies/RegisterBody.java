package com.wjy.backend.entity.requestbodies;

import lombok.Data;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/25 20:52
 */
@Data
public class RegisterBody {
    private String username, password, email;

    public RegisterBody(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
