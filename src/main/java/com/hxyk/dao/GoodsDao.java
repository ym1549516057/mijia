package com.hxyk.dao;

import com.hxyk.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YM on 2017/6/9.
 */
@Mapper
@Repository
public interface GoodsDao {
    List<Goods> getGoodsByOption(@Param("market_id") int market_id,@Param("classify_id") int classify_id,@Param("offset") int offset,@Param("pageSize")int pageSize);
    int getTotalByOption(@Param("market_id") int market_id,@Param("classify_id") int classify_id);
    void addGoods(Goods goods);
    Goods getGoodsById(@Param("goods_id") int goods_id);
    void updateGoods(Goods goods);
    List<Goods> getGoodsByClassifyId(@Param("classify_id") int classify_id,@Param("market_id") int market_id);
}
