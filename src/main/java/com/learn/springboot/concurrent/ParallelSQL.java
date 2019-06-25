package com.learn.springboot.concurrent;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.pojo.Post;

import java.util.List;

public class ParallelSQL implements Runnable {
    PostMapper pm;

    @Override
    public void run() {
        List<Post> list = pm.findFirst();
    }
}
