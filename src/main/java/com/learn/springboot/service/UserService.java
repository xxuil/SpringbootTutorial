package com.learn.springboot.service;

import com.learn.springboot.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void addUser(User user);

    boolean login(String username, String password);

    User get(int uid);

    User getByName(String username);

    int getCount();
}
