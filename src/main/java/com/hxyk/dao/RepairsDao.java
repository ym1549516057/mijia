package com.hxyk.dao;

import com.hxyk.entity.Repairs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by YM on 2017/6/21.
 */
@Mapper
@Repository
public interface RepairsDao {
    void addRepairs(Repairs repairs);
}
