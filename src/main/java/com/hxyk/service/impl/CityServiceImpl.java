package com.hxyk.service.impl;

import com.hxyk.dao.CityDao;
import com.hxyk.entity.City;
import com.hxyk.service.CityService;
import com.hxyk.utils.Constant;
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
public class CityServiceImpl implements CityService{
    @Autowired
    CityDao cityDao;

    @Override
    public List<City> getAllCity() {
        return cityDao.getAllCity();
    }

    @Override
    public Map getCityByPageNo(int pageNO) {
        int offset = (pageNO -1) * Constant.PAGE_SIZE;  //从第几条数据开始查
        List<City> cityList = cityDao.getCitys(offset,Constant.PAGE_SIZE);//当前页面上的记录集合

        int total = cityDao.total();//总记录数
        int totalPage = (total+Constant.PAGE_SIZE-1)/Constant.PAGE_SIZE; //总页数
        Map map = new HashMap<>();
        map.put("cityList",cityList);
        map.put("totalPage",totalPage);
        return map;
    }

    @Override
    public Map getCitysByOption(String name, int offset, int limit) {
        List<City> cityList = cityDao.getCitysByOption(name, offset, limit);
        int total = cityDao.getTotalByOption(name);

        Map map= new HashMap<>();
        map.put("total",total);
        map.put("rows",cityList);
        return map;
    }

    @Override
    public void addCity(City city) {
        cityDao.addCity(city);
    }

    @Override
    public City selectByCityName(@Param("city_name") String city_name) {
        return cityDao.selectByCityName(city_name);
    }

    @Override
    public void delCity(int city_id) {
        cityDao.delCity(city_id);
    }
}
