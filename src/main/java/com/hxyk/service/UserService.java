package com.hxyk.service;

import com.hxyk.entity.User;

/**
 * Created by YM on 2017/5/26.
 */
public interface UserService {
    void addUser(User user);
    User loginUser(User user);
    User selectUserByTel(User user);
    void updateUser(User user);
    int selectCommunityID(User user);
}
