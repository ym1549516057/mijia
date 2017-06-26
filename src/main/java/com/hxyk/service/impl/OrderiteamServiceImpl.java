package com.hxyk.service.impl;

import com.hxyk.dao.OrderiteamDao;
import com.hxyk.entity.Goods;
import com.hxyk.entity.Orderiteam;
import com.hxyk.service.OrderiteamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/14.
 */
@Service
@Slf4j
public class OrderiteamServiceImpl implements OrderiteamService{
    @Autowired
    OrderiteamDao orderiteamDao;

    @Override
    public void addOrderiteam(Orderiteam orderiteam) {
        orderiteamDao.addOrderiteam(orderiteam);
    }

    @Override
    public void updateOrderiteam(Orderiteam orderiteam) {
        orderiteamDao.updateOrderiteam(orderiteam);
    }

    @Override
    public Orderiteam getByGoodsId(int goods_id, int user_id) {
        return orderiteamDao.getByGoodsId(goods_id,user_id);
    }

    @Override
    public List<Orderiteam> getAllGoodsByUser(int user_id, int iteam_state) {
        return orderiteamDao.getAllGoodsByUser(user_id,iteam_state);
    }

    @Override
    public void delOrderiteamById(int iteam_id) {
        orderiteamDao.delOrderiteamById(iteam_id);
    }

    @Override
    public Map getOrderiteamMap(int user_id, int iteam_state,int offset,int pageSize) {
        Map map = new HashMap<>();
        List<Orderiteam>  orderiteamList= orderiteamDao.getOrderiteamMap(user_id,iteam_state,offset,pageSize);
        int total = orderiteamDao.getOrderiteamMapTotal(user_id,iteam_state);
        map.put("total",total);
        map.put("rows",orderiteamList);
        return map;
    }

    @Override
    public int getOrderiteamMapTotal(int user_id, int iteam_state) {
        return 0;
    }

    @Override
    public List<Orderiteam> getUserIteam(int user_id, int iteam_state) {
        return orderiteamDao.getUserIteam(user_id,iteam_state);
    }
}
