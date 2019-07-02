package com.learn.springboot.controller;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostMapper postMapper;

    @RequestMapping("/listPost")
    public String listPost(Model m) throws Exception{
        List<Post> posts = postMapper.findAll();
        m.addAttribute("posts", posts);
        return "listPost";
    }
}
