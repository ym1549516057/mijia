package com.hxyk.dao;

import com.hxyk.entity.Market;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by YM on 2017/6/15.
 */
@Mapper
@Repository
public interface MarketDao {
    Market getMarketByCommunityId(@Param("community_id") int community_id);//根据小区ID 查找小区超市
}
