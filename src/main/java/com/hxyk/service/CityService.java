package com.hxyk.service;

import com.hxyk.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/5/27.
 */
public interface CityService {
    List<City> getAllCity();
    Map getCityByPageNo(int pageNO);
    Map getCitysByOption(String name, int offset, int limit);

    void addCity(City city);

    City selectByCityName(String city_name);

    void delCity(int city_id);
}
