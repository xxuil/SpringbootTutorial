package com.learn.springboot.mapper;

import com.learn.springboot.pojo.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Insert("insert into post (pid,title,content,time) values (#{pid}, #{title}, #{content}, #{time})")
    void add(Post p);

    @Update("update post set title=#{title}, content=#{content}, time=#{time} where pid=#{pid}")
    void update(Post p);

    @Select("select * from post where pid = #{pid}")
    Post get(int pid);

    @Delete("delete from post where pid= #{pid}")
    void delete(int pid);

    @Select("select * from post order by time desc")
    List<Post> findAll();

    @Select("select * from post order by time desc limit 25")
    List<Post> findRecent();
}
