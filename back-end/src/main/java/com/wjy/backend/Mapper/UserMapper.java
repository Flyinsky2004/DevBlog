package com.wjy.backend.Mapper;

import com.wjy.backend.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/9 20:05
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM tb_users WHERE username = #{username} AND password = #{password}")
    User getUserByUsernameAndPassword(String username,String password);
}
