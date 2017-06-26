package com.hxyk.service.impl;

import com.hxyk.dao.GoodsDao;
import com.hxyk.entity.Goods;
import com.hxyk.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/9.
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    GoodsDao goodsDao;


    @Override
    public Map getGoodsByOption(int market_id, int classify_id, int offset, int pageSize) {
        Map map = new HashMap<>();
        List<Goods> goodsList = goodsDao.getGoodsByOption(market_id,classify_id,offset,pageSize);
        int total = goodsDao.getTotalByOption(market_id,classify_id);
        map.put("total",total);
        map.put("rows",goodsList);
        return map;
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public Goods getGoodsById(int goods_id) {
        return goodsDao.getGoodsById(goods_id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public List<Goods> getGoodsByClassifyId(int classify_id,int market_id) {
        return goodsDao.getGoodsByClassifyId(classify_id,market_id);
    }
}
