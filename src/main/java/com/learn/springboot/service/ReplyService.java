package com.learn.springboot.service;

import com.learn.springboot.pojo.Reply;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    List<Reply> getReplies(int pid);

    void addReply(Reply reply);

    int getCount(int pid);
}
