package com.hxyk.service;


import com.hxyk.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/9.
 */
public interface GoodsService {
    Map getGoodsByOption(int market_id, int classify_id, int offset, int pageSize);
    void addGoods(Goods goods);
    Goods getGoodsById(int goods_id);
    void updateGoods(Goods goods);
    List<Goods> getGoodsByClassifyId(int classify_id,int market_id);
}
