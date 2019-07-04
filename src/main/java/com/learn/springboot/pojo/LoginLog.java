package com.learn.springboot.pojo;

public class LoginLog {
    private int id;
    private int userId;
    private String loginTime;
    private String ip;
    private String device;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public String getIp() {
        return ip;
    }

    public String getDevice() {
        return device;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
