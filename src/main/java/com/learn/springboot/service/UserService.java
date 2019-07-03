package com.learn.springboot.service;

import com.learn.springboot.pojo.User;

public interface UserService {
    void addUser(User user);

    boolean login(String username, String password);

    User get(int uid);

    int getCount();
}
