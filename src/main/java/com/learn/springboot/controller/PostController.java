package com.learn.springboot.controller;

import com.learn.springboot.pojo.Post;
import com.learn.springboot.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostServiceImpl ps;

    @GetMapping("/posts")
    public String list(){
        return ps.getRecent().toString();
    }

    @GetMapping("/posts/{pid}")
    public String get(@PathVariable("pid") int pid) throws Exception {
        return ps.get(pid).toString();
    }
}
