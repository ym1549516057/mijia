package com.hxyk.service;

import com.hxyk.entity.Managers;
import org.apache.catalina.Manager;

/**
 * Created by YM on 2017/6/12.
 */
public interface ManagerService {
    void addManager(Managers manager);
    Managers login(String manager_tel,String password);
}
