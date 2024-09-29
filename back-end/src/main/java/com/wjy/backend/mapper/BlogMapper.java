package com.wjy.backend.mapper;

import com.wjy.backend.entity.pojo.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Flyinsky
 * @email w2084151024@gmail.com
 * @date 2024/9/19 19:54
 */
@Mapper
public interface BlogMapper {
    /**
     * CRUD
     * Select SELECT [查询字段] FROM [表名] WHERE [条件] ORDER BY [字段名] [ASC,DESC]
     * 查询字段 * --全部 title,content...
     * WHERE id = 1 OR username = "123"
     * ORDER BY  ASC  DESC
     * Delete
     * DELETE FROM [表名] WHERE [条件]
     * Update
     * UPDATE [表名] SET [字段名] WHERE [条件]
     * Insert
     * INSERT INTO [表名]([属性1],[属性2],[属性3],[属性4],...) VALUES ([参数1],[参数2],[参数3],[参数4],...)
     *
     * @param blog
     * @return
     */
    @Insert("INSERT INTO tb_blogs(title, authorId, updateDate, content) VALUES (#{title},#{authorId},#{updateDate},#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertNewBlog(Blog blog);

    @Select("SELECT id,title,authorId,substring(content,1,200) AS content FROM tb_blogs ORDER BY id DESC LIMIT 50")
    List<Blog> getBlogsOrderById();

    @Select("SELECT * FROM tb_blogs WHERE id = #{id}")
    Blog getBlogById(int id);

    @Update("UPDATE tb_blogs SET watches = watches + 1 WHERE id = #{id}")
    int updateWatchesById(int id);
}
