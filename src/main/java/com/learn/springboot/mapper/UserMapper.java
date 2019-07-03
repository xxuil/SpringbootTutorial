package com.learn.springboot.mapper;

import com.learn.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (uid, username, password) values (#{uid}, #{username}, #{password})")
    void add(User u);

    @Update("update user set username = #{username}, password = #{password} where uid = #{uid}")
    void update(User u);

    @Select("select * from user where uid = #{uid}")
    User get(int uid);

    @Select("select * from user where username = #{username, jdbcType=VARCHAR}")
    User get(String username);

    @Delete("delete from user where uid = #{uid}")
    void delete(int uid);

    @Select("select COUNT(*) from user")
    int getUserCount();
}
