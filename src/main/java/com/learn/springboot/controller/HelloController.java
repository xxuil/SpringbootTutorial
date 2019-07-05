package com.learn.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello!" +
                "";
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView login() {
        ModelAndView loginPage = new ModelAndView("login");
        return loginPage;
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView registerPage = new ModelAndView("register");

        return registerPage;
    }

    @RequestMapping("/new")
    public ModelAndView newPost() {
        ModelAndView newPostPage = new ModelAndView("new");

        return newPostPage;
    }

    @RequestMapping("*")
    public String notFind(){
        return "404";
    }
}
