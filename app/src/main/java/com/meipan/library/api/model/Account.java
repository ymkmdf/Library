package com.meipan.library.api.model;

/**
 * Created by vaio on 2015/12/6.
 */
public class Account {//账户
    public String platform="mobile";// "qq", ['weibo', 'qq', 'mobile', 'local','weixin']
    public String password;
    public String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
