package com.hxyk.dao;

import com.hxyk.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/5/27.
 */
@Repository
@Mapper
public interface CityDao {
    //总记录条数
    int total();
    //查询所有城市
    List<City> getAllCity();
    /***
     * 分页查询城市
     * offset 从第几条开始查询
     * pageSize 查询多少条
     */
    List<City> getCitys(@Param("offset") int offset, @Param("pageSize") int pageSize);

    List<City> getCitysByOption(@Param("name") String name, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     *根据条件获取记录条数
     * @param name
     * @return
     */
    int getTotalByOption(@Param("name") String name);

    void addCity(City city);

    City selectByCityName(@Param("city_name") String city_name);

    void delCity(int city_id);
}
