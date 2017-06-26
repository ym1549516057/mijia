package com.hxyk.service.impl;

import com.hxyk.dao.UserDao;
import com.hxyk.entity.User;
import com.hxyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YM on 2017/5/26.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User loginUser(User user) {
        return userDao.loginUser(user);
    }

    @Override
    public User selectUserByTel(User user) {
        return userDao.selectUserByTel(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public int selectCommunityID(User user) {
        return userDao.selectCommunityID(user);
    }
}
