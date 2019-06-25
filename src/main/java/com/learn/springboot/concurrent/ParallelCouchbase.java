package com.learn.springboot.concurrent;

import com.learn.springboot.pojo.Post;
import com.learn.springboot.service.PostRepository;

import java.util.List;

public class ParallelCouchbase implements Runnable {
    PostRepository pr;

    @Override
    public void run() {
        List<Post> list = pr.findTop10ByOrderByTimeDesc();
    }
}
