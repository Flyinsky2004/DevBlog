package com.wjy.backend.Mapper;

import com.wjy.backend.Entity.pojo.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 19:54
 */
@Mapper
public interface BlogMapper {
    @Insert("INSERT INTO tb_blogs(title, authorId, updateDate, content) VALUES (#{title},#{authorId},#{updateDate},#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertNewBlog(Blog blog);

    @Select("SELECT title,authorId,substring(content,1,200) AS content FROM tb_blogs ORDER BY id DESC LIMIT 50")
    List<Blog> getBlogsOrderById();

    @Select("SELECT * FROM tb_blogs WHERE id = #{id}")
    Blog getBlogById(int id);
}
