package com.learn.springboot.pojo;

import java.io.Serializable;

public class Reply implements Serializable {
    private int rid;
    private String content;
    private int postId;
    private int userId;
    private String time;

    public int getRid() {
        return rid;
    }

    public String getContent() {
        return content;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTime() {
        return time;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reply: " + rid;
    }
}
