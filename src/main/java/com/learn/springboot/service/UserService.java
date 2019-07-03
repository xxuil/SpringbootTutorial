package com.learn.springboot.service;

import com.learn.springboot.pojo.User;

public interface UserService {
    boolean addUser(User user);

    boolean updateUser(User user);

    int login(String username, String password);

    boolean check(String username);

    User get(int uid);

    int getCount();
}
