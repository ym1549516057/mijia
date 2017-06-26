package com.hxyk.dao;

import com.hxyk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * Created by YM on 2017/5/26.
 */
@Repository
@Mapper
public interface UserDao {
    void addUser(User user);
    User loginUser(User user);
    User selectUserByTel(User user);
    void updateUser(User user);
    int selectCommunityID(User user);
}
