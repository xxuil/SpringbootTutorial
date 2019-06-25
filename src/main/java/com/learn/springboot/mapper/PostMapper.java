package com.learn.springboot.mapper;

import com.learn.springboot.pojo.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
public interface PostMapper {
    @Insert("insert into post (id,title,content,time) values (#{id}, #{title}, #{content}, #{time})")
    void add(Post p);

    @Update("update post set title=#{title}, content=#{content}, time=#{time} where id=#{id}")
    void update(Post p);

    @Select("select * from post order by time desc")
    List<Post> findAll();

    @Select("select * from post order by time desc limit 10")
    List<Post> findFirst();

    @Delete("delete from post where id= #{id}")
    void delete(int id);

}
