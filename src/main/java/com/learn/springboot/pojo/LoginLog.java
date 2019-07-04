package com.learn.springboot.pojo;

public class LoginLog {
    private int lid;
    private int userId;
    private String loginTime;
    private String ip;
    private String device;

    public int getLid() {
        return lid;
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

    public void setLid(int lid) {
        this.lid = lid;
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
