package com.learn.springboot.mapper;

import com.learn.springboot.pojo.User;

public interface UserMapper {
    void add(User u);

    void get(int uid);

    void delete(int uid);
}
