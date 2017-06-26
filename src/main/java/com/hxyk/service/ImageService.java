package com.hxyk.service;

import com.hxyk.entity.Image;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/7.
 */

public interface ImageService {
    void uploadImage(Image image);
    Map getImageByOption(int isDisplay, int offset, int pageSize);
    int getTotalByOption(int isDisplay);
    Image getByID(int image_id);
    void updateImage(Image image);
    List<Image> getIamgeByIsDisplay();
    int getCountByIsDisplay();
}
