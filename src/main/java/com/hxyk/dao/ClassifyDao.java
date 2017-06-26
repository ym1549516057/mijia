package com.hxyk.dao;

import com.hxyk.entity.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YM on 2017/6/9.
 */
@Mapper
@Repository
public interface ClassifyDao {
    List<Classify> getAll();
}
