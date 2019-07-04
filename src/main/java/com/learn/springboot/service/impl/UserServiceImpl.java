package com.learn.springboot.service.impl;

import com.learn.springboot.mapper.UserMapper;
import com.learn.springboot.pojo.User;
import com.learn.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.add(user);
    }

    @Override
    public boolean login(String username, String password) {
        return userMapper.check(username).getPassword().equals(password);
    }

    @Override
    public User get(int uid) {
        return userMapper.get(uid);
    }

    @Override
    public int getCount() {
        return userMapper.getUserCount();
    }

    @Override
    public User getByName(String username) {
        return userMapper.check(username);
    }
}
