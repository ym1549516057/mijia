package com.hxyk.service;

import com.hxyk.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/5/27.
 */
public interface CommunityService {
    List<Community> getAllCommunity();
    List<Community> getCommunityByCityId(int city_id);
    Community getCommunityByID(int id);
    //根据城市ID查询小区
    Map getCommunityByCityIdByOption(int city_id, int offset, int pageSize);

    int getTotalByOption(@Param("city_id") int city_id);

    void addCommunity(Community community);

    void delCommunityByID(String ids);
}
