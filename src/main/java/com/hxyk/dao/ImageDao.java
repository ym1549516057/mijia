package com.hxyk.dao;

import com.hxyk.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YM on 2017/6/7.
 */
@Mapper
@Repository
public interface ImageDao {
    void uploadImage(Image image);
    List<Image> getImageByOption(@Param("isDisplay") int isDisplay, @Param("offset") int offset, @Param("pageSize") int pageSize);
    int getTotalByOption(@Param("isDisplay") int isDisplay);
    Image getByID(@Param("image_id") int image_id);
    void updateImage(Image image);
    List<Image> getIamgeByIsDisplay();
    int getCountByIsDisplay();
}
