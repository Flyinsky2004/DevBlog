package com.wjy.backend.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/10/8 20:02
 */
@Mapper
public interface LikeMapper {
    @Insert("INSERT INTO rp_like (userId,blogId,likeTime) VALUES (#{userId},#{blogId},CURRENT_TIMESTAMP)")
    int addNewLikeRecord(Integer userId, Integer blogId);

    @Select("SELECT id FROM rp_like WHERE userId = #{userId} AND blogId = #{blogId}")
    Integer checkUserLikedBlog(Integer userId, Integer blogId);

    @Delete("DELETE FROM rp_like WHERE userId = #{userId} AND blogId = #{blogId}")
    int deleteLikeRecord(Integer userId, Integer blogId);
}
