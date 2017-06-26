package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/6/9.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private int goods_id;
    private String goods_name;
    private String goods_img;
    private float goods_price;
    private int goods_state; //商品状态  上架  下架  删除
    private int goods_ivn;//商品库存
    private String goods_dis;
    private int market_id;//所属超市
    private int classify_id;//分类

    public Goods(String goods_name, String goods_img, float goods_price, int goods_state, int goods_ivn, String goods_dis, int market_id, int classify_id) {
        this.goods_name = goods_name;
        this.goods_img = goods_img;
        this.goods_price = goods_price;
        this.goods_state = goods_state;
        this.goods_ivn = goods_ivn;
        this.goods_dis = goods_dis;
        this.market_id = market_id;
        this.classify_id = classify_id;
    }
}
