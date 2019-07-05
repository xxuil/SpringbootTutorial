package com.learn.springboot.controller;


import com.learn.springboot.pojo.LoginLog;
import com.learn.springboot.pojo.User;
import com.learn.springboot.service.LoginLogService;
import com.learn.springboot.service.PostService;
import com.learn.springboot.service.UserService;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    public LoginLogService loginLogService;

    @Autowired
    public PostService postService;

//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    @RequestMapping("/check")
//    public String check(@ModelAttribute("username") String username, @ModelAttribute("password") String password){
//        return "check";
//    }
//
//    @RequestMapping("/register")
//    public String register() {
//        return "register";
//    }

    @RequestMapping("/user/add/do")
    public String addUser(HttpServletRequest request) {
        User u = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        u.setUid(0);
        u.setUsername(username);
        u.setPassword(password);
        userService.addUser(u);
        return "redirect:/";
    }


    @RequestMapping("/user/login/do")
    public String login( HttpServletRequest request, HttpSession session) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean check = userService.login(username, password);
        HashMap<String,String> res = new HashMap<>();

        if(check) {
            User u = userService.getByName(username);
            session.setAttribute("userId", u.getUid());
            session.setAttribute("username", username);

            String ip = gerRemoteIP(request);
            UserAgent agent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            String userbrowser = agent.getBrowser().toString();

            LoginLog log = new LoginLog();
            log.setLid(0);
            log.setDevice(userbrowser);
            log.setIp(ip);
            log.setUserId(u.getUid());
            log.setLoginTime(String.valueOf(System.currentTimeMillis()));
            loginLogService.addLog(log);

            return "redirect:/";
        }

        else {
            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("username");
        return "redirect:/";
    }


    public String gerRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

}
