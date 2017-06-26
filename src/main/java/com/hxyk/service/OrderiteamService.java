package com.hxyk.service;

import com.hxyk.entity.Orderiteam;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/14.
 */
public interface OrderiteamService {
    void addOrderiteam(Orderiteam orderiteam);
    void updateOrderiteam(Orderiteam orderiteam);
    Orderiteam getByGoodsId(int goods_id,int user_id);//查询单个未生成订单的商品
    List<Orderiteam> getAllGoodsByUser(int user_id,int iteam_state);
    void delOrderiteamById(int iteam_id);
    Map getOrderiteamMap(int user_id,int iteam_state,int offset,int pageSize);
    int getOrderiteamMapTotal(int user_id,int iteam_state);
    List<Orderiteam> getUserIteam(int user_id,int iteam_state);
}
