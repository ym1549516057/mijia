package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/6/14.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orderiteam {
    private int iteam_id;
    private int goods_id;
    private int order_id;
    private int iteam_total;//商品总数
    private float iprice_total;//商品总价
    private int iteam_state;//详情状态
    private int user_id;
    private Goods goods;

    public Orderiteam(int goods_id, int order_id, int iteam_total, float iprice_total, int iteam_state) {
        this.goods_id = goods_id;
        this.order_id = order_id;
        this.iteam_total = iteam_total;
        this.iprice_total = iprice_total;
        this.iteam_state = iteam_state;
    }

    public Orderiteam(int goods_id, int iteam_total, float iprice_total, int iteam_state, int user_id) {
        this.goods_id = goods_id;
        this.iteam_total = iteam_total;
        this.iprice_total = iprice_total;
        this.iteam_state = iteam_state;
        this.user_id = user_id;
    }
}
