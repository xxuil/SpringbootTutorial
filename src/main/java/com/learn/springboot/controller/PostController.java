package com.learn.springboot.controller;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.pojo.Post;
import com.learn.springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService ps;

    @GetMapping("/posts")
    public String list() throws Exception {
        List<Post> posts = ps.getRecent();
        return null;
    }

    @GetMapping("/posts/{pid}")
    public Post get(@PathVariable("pid") int pid) throws Exception {
        return ps.get(pid);
    }
}
