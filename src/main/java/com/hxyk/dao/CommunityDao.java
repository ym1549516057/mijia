package com.hxyk.dao;

import com.hxyk.entity.Community;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YM on 2017/5/27.
 */
@Repository
@Mapper
public interface CommunityDao {
    List<Community> getAllCommunity();
    List<Community> getCommunityByCityId(int city_id);
    Community getCommunityByID(int community_id);
    //根据城市ID查询小区
    List<Community> getCommunityByCityIdByOption(@Param("city_id") int city_id, @Param("offset") int offset, @Param("pageSize") int pageSize);

    int getTotalByOption(@Param("city_id") int city_id);
    //添加小区
    void addCommunity(Community community);
    //删除小区
    void delCommunityByID(int community_id);
}
