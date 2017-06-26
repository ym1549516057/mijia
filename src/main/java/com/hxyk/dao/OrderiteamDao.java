package com.hxyk.dao;

import com.hxyk.entity.Orderiteam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/14.
 */
@Mapper
@Repository
public interface OrderiteamDao {
    void addOrderiteam(Orderiteam orderiteam);
    void updateOrderiteam(Orderiteam orderiteam);
    Orderiteam getByGoodsId(@Param("goods_id") int goods_id,@Param("user_id") int user_id);//查询单个未生成订单的商品
    List<Orderiteam> getAllGoodsByUser(@Param("user_id") int user_id,@Param("iteam_state") int iteam_state);
    void delOrderiteamById(@Param("iteam_id") int iteam_id);
    List<Orderiteam> getOrderiteamMap(@Param("user_id") int user_id,@Param("iteam_state") int iteam_state,@Param("offset") int offset,@Param("pageSize") int pageSize);
    int getOrderiteamMapTotal(@Param("user_id") int user_id,@Param("iteam_state") int iteam_state);
    List<Orderiteam> getUserIteam(@Param("user_id") int user_id,@Param("iteam_state") int iteam_state);
}
