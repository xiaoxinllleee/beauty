package com.venus.beauty.entity;

import lombok.Data;

/**
 * @author lx
 * @time 2018/10/17
 */
@Data
public class UserInfo {
    private String userid;
    private String username;
    private String password;
    private String salt;
    private AccessToken accessToken;

    public UserInfo(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
}
