package com.hxyk.service.impl;

import com.hxyk.dao.ClassifyDao;
import com.hxyk.entity.Classify;
import com.hxyk.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YM on 2017/6/9.
 */
@Service
public class ClassifyServiceImpl implements ClassifyService{
    @Autowired
    ClassifyDao classifyDao;

    @Override
    public List<Classify> getAll() {
        return classifyDao.getAll();
    }
}
