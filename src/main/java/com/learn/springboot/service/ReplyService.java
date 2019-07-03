package com.learn.springboot.service;

import com.learn.springboot.pojo.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplies(int pid);

    boolean addReply(Reply reply);

    int getCount(int pid);
}
