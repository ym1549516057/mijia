package com.hxyk.controller;

import com.hxyk.entity.City;
import com.hxyk.entity.Community;
import com.hxyk.service.CityService;
import com.hxyk.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/5/27.
 */
@Controller
@RequestMapping("/community")
@Slf4j
public class CommunityController {
    @Autowired
    CommunityService communityService;

    @Autowired
    CityService cityService;

    @PostMapping("/getByCityId")
    @ResponseBody
    public List<Community> getByCityId(int city_id){
        List<Community> communityList = communityService.getCommunityByCityId(city_id);
        return communityList;
    }

    @RequestMapping("toList")
    public String getAllCity(ModelMap modelMap){
        List<City> cityList = cityService.getAllCity();
        modelMap.put("cityList",cityList);
        return "back/community_list";
    }

    @ResponseBody
    @RequestMapping("communitylist")
    public Map getCommunity(@RequestParam(value = "city_id", required = false,defaultValue = "-1")String city_id, int offset, int limit){
        int id = Integer.parseInt(city_id);
        Map data = communityService.getCommunityByCityIdByOption(id, offset, limit);
        return data;
    }

    @RequestMapping("add_community")
    @ResponseBody
    public String addCommunity(@RequestBody Community community){
        List<Community> communityList =  communityService.getCommunityByCityId(community.getCity_id());
        for(Community c: communityList){
            if (c.getCommunity_name().equals(community.getCommunity_name())){
                return "error";
            }
        }
        communityService.addCommunity(community);
        return "success";
    }
    @RequestMapping("delCommunity")
    @ResponseBody
    public Map delCommunity(String ids){
        Map map = new HashMap<>();
        communityService.delCommunityByID(ids);
        map.put("success",true);
        return map;
    }

}
