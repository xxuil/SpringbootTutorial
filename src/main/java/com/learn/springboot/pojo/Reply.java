package com.learn.springboot.pojo;

import java.io.Serializable;

public class Reply implements Serializable {
    private int rid;
    private String content;
    private int postId;
    private int uid;

    public int getRid() {
        return rid;
    }

    public String getContent() {
        return content;
    }

    public int getPostId() {
        return postId;
    }

    public int getUid() {
        return uid;
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

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Reply: " + rid;
    }
}
