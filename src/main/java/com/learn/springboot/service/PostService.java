package com.learn.springboot.service;

import com.learn.springboot.pojo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> getAll();

    List<Post> getRecent();

    Post get(int pid);

    void add(Post p);

    void update(Post p);

    void view(int pid);

    int getCount();
}
