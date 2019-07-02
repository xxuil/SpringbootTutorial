package com.learn.springboot.concurrent;

import com.learn.springboot.pojo.Post;
import com.learn.springboot.utils.Redis.RedisUtil;

import java.util.List;

public class ParallelRedis implements Runnable {
    RedisUtil<Post> util;

    @Override
    public void run() {
        List<Post> list = util.getPageList("newest", 0, 9);
    }
}
