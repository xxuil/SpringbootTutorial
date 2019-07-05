package com.learn.springboot.controller;

import com.learn.springboot.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;
}
