package com.hxyk.controller;

import com.hxyk.entity.City;
import com.hxyk.entity.Community;
import com.hxyk.service.CityService;
import com.hxyk.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/2.
 */
@RequestMapping("city")
@Controller
@Slf4j
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    CommunityService communityService;

    @RequestMapping("toAdd")
    public String toAdd(){
        return "back/add_city";
    }

    @RequestMapping("toList")
    public  String toList(){
        return "back/city_list";
    }


    @ResponseBody
    @RequestMapping("/list")
    public Map list(@RequestParam(value = "name", required = false, defaultValue = "") String name,int offset, int limit) {
        Map data = cityService.getCitysByOption(name,offset, limit);
        return data;
    }
    @RequestMapping("/add_city")
    @ResponseBody
    public String addCity(@RequestBody City city){
        City c = cityService.selectByCityName(city.getCity_name());
        if(c == null){
            cityService.addCity(city);
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("delcity")
    @ResponseBody
    public Map delCity(String ids){
        Map map = new HashMap<>();
        for(String id: ids.split(",")){
            int city_id = Integer.parseInt(id);
            List<Community> communityList = communityService.getCommunityByCityId(city_id);
            if(communityList.size() > 0){
                map.put("success",false);
            }else{
                cityService.delCity(city_id);
                map.put("success",true);
            }
        }
        return map;
    }

}
