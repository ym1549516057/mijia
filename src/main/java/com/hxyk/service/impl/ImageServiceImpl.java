package com.hxyk.service.impl;

import com.hxyk.dao.ImageDao;
import com.hxyk.entity.Image;
import com.hxyk.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/7.
 */
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ImageDao imageDao;

    @Override
    public void uploadImage(Image image) {
        imageDao.uploadImage(image);
    }

    @Override
    public Map getImageByOption(int isDisplay, int offset, int pageSize) {
        List<Image> imageList = imageDao.getImageByOption(isDisplay, offset, pageSize);
        int total = imageDao.getTotalByOption(isDisplay);
        Map map = new HashMap<>();
        map.put("total",total);
        map.put("rows",imageList);
        return map;
    }

    @Override
    public int getTotalByOption(int isDisplay) {
        return 0;
    }

    @Override
    public Image getByID(int image_id) {
        return imageDao.getByID(image_id);
    }

    @Override
    public void updateImage(Image image) {
        imageDao.updateImage(image);

    }

    @Override
    public List<Image> getIamgeByIsDisplay() {
        return imageDao.getIamgeByIsDisplay();
    }

    @Override
    public int getCountByIsDisplay(){
        return imageDao.getCountByIsDisplay();
    }


}
