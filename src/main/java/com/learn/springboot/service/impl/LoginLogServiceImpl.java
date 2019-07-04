package com.learn.springboot.service.impl;

import com.learn.springboot.mapper.LoginLogMapper;
import com.learn.springboot.pojo.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl {
    @Autowired
    LoginLogMapper mapper;

    public void addLog(LoginLog log) {
        mapper.add(log);
    }
}
