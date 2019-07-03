package com.learn.springboot.controller;

import com.learn.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    @Autowired
    UserMapper userMapper;
}
