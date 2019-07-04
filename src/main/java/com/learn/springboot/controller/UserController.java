package com.learn.springboot.controller;


import com.learn.springboot.pojo.User;
import com.learn.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/check")
    public String check(@ModelAttribute("username") String username, @ModelAttribute("password") String password){
        return "check";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute("username") String username, @ModelAttribute("password") String password){
        User u = new User();
        u.setUid(0);
        u.setUsername(username);
        u.setPassword(password);
        userService.addUser(u);
        return "login";
    }

}
