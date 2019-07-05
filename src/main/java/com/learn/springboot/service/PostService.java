package com.learn.springboot.service;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.pojo.Post;
import com.learn.springboot.utils.Redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    @Autowired
    RedisUtil<Post> redisUtil;


    public void add(Post p) {
        postMapper.add(p);
        updateRedis();
    }

//    @Override
//    public void view(int pid) {
//        postMapper.view(pid);
//        updateRedis();
//    }


    public void update(Post p) {
        postMapper.update(p);
        updateRedis();
    }


    public Post get(int pid) {
        postMapper.incrementView(pid);
        return postMapper.get(pid);
    }


    public int getCount() {
        return postMapper.getPostCount();
    }


    public List<Post> getAll() {
        String key = "newest";
        long end = redisUtil.size(key);
        return redisUtil.getPageList(key, 0, end);
    }


    public List<Post> getRecent() {
        return postMapper.findRecent();
    }


    private void updateRedis() {
        String key = "newest";
        redisUtil.getCatcheList(key);
        List<Post> list = postMapper.findAll();
        redisUtil.setCatcheList(key, list);
    }
}
