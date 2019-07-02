package com.learn.springboot.pojo;

import java.io.Serializable;
import java.util.List;


public class Post implements Serializable {
    // Version 1
    private int pid;
    private String title;
    private String content;
    private String time;

    // Version 2
    private User user;
    private int uid;
    private int viewCount;
    private int replyCount;

    // Version 1
    public String getTime(){
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Version 2
    public User getUser() {
        return user;
    }

    public int getUid() {
        return uid;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    @Override
    public String toString() {
        return "Post: " + pid;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Post){
            if(((Post) obj).pid == this.pid){
                if(((Post) obj).title.equals(this.title)){
                    if(((Post) obj).content.equals(this.content))
                        return true;
                }
            }
        }

        return false;
    }
}
