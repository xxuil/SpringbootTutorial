package com.learn.springboot.service;

import com.learn.springboot.pojo.Post;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    List<Post> getRecent();

    Post get(int pid);

    boolean add(Post p);

    boolean view(int pid);

    int getCount();
}
