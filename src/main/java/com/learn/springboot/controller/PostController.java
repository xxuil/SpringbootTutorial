package com.learn.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.springboot.pojo.Post;
import com.learn.springboot.service.impl.PostServiceImpl;
import com.learn.springboot.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("listPost")
    public ModelAndView listPost(Page page){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Post> cs= ps.getAll();
        int total = (int)new PageInfo<>(cs).getTotal();

        page.caculateLast(total);

        mav.addObject("cs", cs);
        mav.setViewName("listPost");
        return mav;
    }
}
