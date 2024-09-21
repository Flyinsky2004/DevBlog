package com.wjy.backend.Mapper;

import com.wjy.backend.Entity.pojo.User;
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

    @Select("SELECT username FROM tb_users WHERE id = #{id}")
    String getUsernameById(Integer id);
}
