package com.learn.springboot.service;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.mapper.ReplyMapper;
import com.learn.springboot.pojo.Post;
import com.learn.springboot.pojo.Reply;
import com.learn.springboot.utils.Redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    PostMapper postMapper;

    @Autowired
    RedisUtil<Reply> replyRedisUtil;

    public void addReply(Reply reply) {
        replyMapper.add(reply);
        postMapper.incrementReply(reply.getPostId());
        updateReplyRedis(reply.getPostId());
        updatePostRedis();
    }

    public int getCount(int pid) {
        String key = String.valueOf(pid);
        return replyRedisUtil.size(key).intValue();
    }

    public List<Reply> getReplies(int pid){
        String key = String.valueOf(pid);
        return replyRedisUtil.getPageList(key, 0, replyRedisUtil.size(key));
    }

    private void updateReplyRedis(int pid) {
        String key = String.valueOf(pid);
        replyRedisUtil.getCatcheList(key);
        List<Reply> list = replyMapper.findReplies(pid);
        replyRedisUtil.setCatcheList(key, list);
    }

    private void updatePostRedis() {
        String key = "newest";
        replyRedisUtil.getCatcheList(key);
        List<Post> list = postMapper.findAll();
        replyRedisUtil.setCatcheList(key, list);
    }
}
