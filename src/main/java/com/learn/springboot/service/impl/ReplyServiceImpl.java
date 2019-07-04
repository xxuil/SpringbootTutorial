package com.learn.springboot.service.impl;

import com.learn.springboot.mapper.ReplyMapper;
import com.learn.springboot.pojo.Reply;
import com.learn.springboot.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    @Override
    public void addReply(Reply reply) {
        replyMapper.add(reply);
    }

    @Override
    public int getCount(int pid) {
        return replyMapper.getReplyCount(pid);
    }

    @Override
    public List<Reply> getReplies(int pid) {
        return replyMapper.findReplies(pid);
    }
}
