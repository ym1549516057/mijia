package com.hxyk.service.impl;

import com.hxyk.dao.CommunityDao;
import com.hxyk.entity.Community;
import com.hxyk.service.CommunityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/5/27.
 */
@Service
public class CommunityServiceImpl implements CommunityService{
    @Autowired
    CommunityDao communityDao;
    @Override
    public List<Community> getAllCommunity() {
        return communityDao.getAllCommunity();
    }

    @Override
    public List<Community> getCommunityByCityId(int city_id) {
        return communityDao.getCommunityByCityId(city_id);
    }

    @Override
    public Community getCommunityByID(int id) {
        return communityDao.getCommunityByID(id);
    }

    @Override
    public Map getCommunityByCityIdByOption(int city_id, int offset, int pageSize) {
        List<Community> communityList = communityDao.getCommunityByCityIdByOption(city_id, offset, pageSize);//获取小区
        int total =communityDao.getTotalByOption(city_id);

        Map map = new HashMap<>();
        map.put("total",total);
        map.put("rows",communityList);
        return map;
    }

    @Override
    public int getTotalByOption(@Param("city_id") int city_id) {
        return 0;
    }

    @Override
    public void addCommunity(Community community) {
        communityDao.addCommunity(community);
    }

    @Override
    public void delCommunityByID(String ids) {
        for(String id :ids.split(",")){
            int community = Integer.parseInt(id);
            communityDao.delCommunityByID(community);
        }
    }
}
