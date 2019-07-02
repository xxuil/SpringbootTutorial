package com.learn.springboot.mapper;

import com.learn.springboot.pojo.Reply;

import java.util.List;

public interface ReplyMapper {
    void add(Reply reply);

    void get(int rid);

    void delete(int rid);

    List<Reply> findReplies(int postId);

    int getRepliesCount(int postId);
}
