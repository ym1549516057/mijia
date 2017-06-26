package com.hxyk.service.impl;

import com.hxyk.dao.TenementDao;
import com.hxyk.entity.Tenement;
import com.hxyk.service.TenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YM on 2017/6/23.
 */
@Service
public class TenementServiceImpl implements TenementService{
    @Autowired
    TenementDao tenementDao;

    @Override
    public Tenement loginTenement(String tenement_name, String tenement_psw) {
        return tenementDao.loginTenement(tenement_name,tenement_psw);
    }
}
