package com.learn.springboot.controller;

import com.learn.springboot.service.impl.LoginLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginLogController {
    @Autowired
    LoginLogServiceImpl loginLogService;
}
