package com.hxyk.service.impl;

import com.hxyk.dao.RepairsDao;
import com.hxyk.entity.Repairs;
import com.hxyk.service.RepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YM on 2017/6/21.
 */
@Service
public class RepairsServiceImpl implements RepairsService{
    @Autowired
    RepairsDao repairsDao;

    @Override
    public void addRepairs(Repairs repairs) {
        repairsDao.addRepairs(repairs);
    }
}
