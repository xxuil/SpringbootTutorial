package com.learn.springboot.controller;

import com.learn.springboot.pojo.Post;
import com.learn.springboot.pojo.Reply;
import com.learn.springboot.pojo.User;
import com.learn.springboot.service.PostService;
import com.learn.springboot.service.ReplyService;
import com.learn.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class PostController {
    @Autowired
    PostService ps;

    @Autowired
    UserService us;

    @Autowired
    ReplyService rs;

//    @GetMapping("/posts")
//    public String list(){
//        return ps.getRecent().toString();
//    }
//
//    @GetMapping("/posts/{pid}")
//    public String get(@PathVariable("pid") int pid) throws Exception {
//        return ps.get(pid).toString();
//    }
//
//    @RequestMapping("listPost")
//    public ModelAndView listPost(Page page){
//        ModelAndView mav = new ModelAndView();
//        PageHelper.offsetPage(page.getStart(),page.getCount());
//        List<Post> cs= ps.getAll();
//        int total = (int)new PageInfo<>(cs).getTotal();
//
//        page.caculateLast(total);
//
//        mav.addObject("cs", cs);
//        mav.setViewName("listPost");
//        return mav;
//    }

    @RequestMapping("/")
    public ModelAndView toMain(HttpSession session) {
        ModelAndView indexPage = new ModelAndView("main");
        List<Post> posts = ps.getAll();

        if(session.getAttribute("userId") != null) {
            int uid = (int) session.getAttribute("userId");
            User user = us.get(uid);
            indexPage.addObject("user", user);
        }
        indexPage.addObject("posts", posts);
        return indexPage;
    }

    @RequestMapping("/p/{pid}")
    public ModelAndView toPost(@PathVariable("pid")int pid, HttpSession session) {
        Post p = ps.get(pid);
        List<Reply> replies = rs.getReplies(pid);
        ModelAndView postPage = new ModelAndView("detail");
        postPage.addObject("post", p);
        postPage.addObject("replies", replies);
        if(session.getAttribute("userId") != null) {
            int uid = (int) session.getAttribute("userId");
            User user = us.get(uid);
            postPage.addObject("user", user);
        }
        return postPage;
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public ModelAndView addPost(HttpServletRequest request, HttpSession session){
        ModelAndView indexPage;
        if(session.getAttribute("userId") == null) {
            indexPage = new ModelAndView("redirect:/login");
            return indexPage;
        }

        int uid = (int) session.getAttribute("userId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Post p = new Post();
        p.setPid(0);
        p.setTitle(title);
        p.setContent(content);
        p.setUserId(uid);
        p.setTime(String.valueOf(System.currentTimeMillis()));
        p.setViewCount(0);
        p.setReplyCount(0);

        ps.add(p);

        indexPage = new ModelAndView("redirect:/");
        return indexPage;
    }

}
