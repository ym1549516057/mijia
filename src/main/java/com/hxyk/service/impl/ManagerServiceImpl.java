package com.hxyk.service.impl;

import com.hxyk.dao.ManagerDao;
import com.hxyk.entity.Managers;
import com.hxyk.service.ManagerService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YM on 2017/6/12.
 */
@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerDao managerDao;

    @Override
    public void addManager(Managers manager) {
        managerDao.addManager(manager);
    }

    @Override
    public Managers login(String manager_tel, String password) {
        return managerDao.login(manager_tel,password);
    }
}
