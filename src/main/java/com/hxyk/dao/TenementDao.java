package com.hxyk.dao;

import com.hxyk.entity.Tenement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by YM on 2017/6/23.
 */
@Mapper
@Repository
public interface TenementDao {
    Tenement loginTenement(@Param("tenement_name") String tenement_name,@Param("tenement_psw") String tenement_psw);
}
