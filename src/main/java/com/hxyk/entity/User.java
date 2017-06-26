package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/5/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    private String user_tel;
    private String password;
    private Community community;
    private int community_id;

    public User(String password, String user_tel, String user_name) {
        this.password = password;
        this.user_tel = user_tel;
        this.user_name = user_name;
    }

    public User(String user_tel, String password) {
        this.user_tel = user_tel;
        this.password = password;
    }

}
