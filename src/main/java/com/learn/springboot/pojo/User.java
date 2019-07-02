package com.learn.springboot.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int uid;
    private String username;
    private String password;

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User: " + uid;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof User){
            if(((User) obj).uid == this.uid)
                return true;
        }
        return false;
    }
}
