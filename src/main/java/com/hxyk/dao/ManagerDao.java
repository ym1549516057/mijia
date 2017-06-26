package com.hxyk.dao;

import com.hxyk.entity.Managers;
import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by YM on 2017/6/12.
 */
@Mapper
@Repository
public interface ManagerDao {
    void addManager(Managers manager);
    Managers login(@Param("manager_tel") String manager_tel,@Param("password") String password);
}
