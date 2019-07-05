package com.learn.springboot.controller;

import com.learn.springboot.pojo.Reply;
import com.learn.springboot.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/reply/add", method = RequestMethod.POST)
    public ModelAndView addReply(HttpServletRequest request, HttpSession session) {
        int postId = Integer.parseInt(request.getParameter("postId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String content = request.getParameter("content");

        Reply r = new Reply();
        r.setRid(0);
        r.setContent(content);
        r.setPostId(postId);
        r.setUserId(userId);
        r.setTime(String.valueOf(System.currentTimeMillis()));
        replyService.addReply(r);

        ModelAndView replyPage = new ModelAndView("redirect:/p/" + postId);
        return replyPage;
    }
}
