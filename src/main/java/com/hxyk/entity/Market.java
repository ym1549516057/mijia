package com.hxyk.entity;

/**
 * Created by YM on 2017/6/9.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Market {
    private int market_id;
    private String market_name;
    private String market_dis;
    private String market_creat;//超市创建时间
    private String market_des;//超市倒闭时间
    private int market_state;//超市状态
    private int manager_id;

    public Market(String market_name, String market_dis, String market_creat, String market_des, int market_state) {
        this.market_name = market_name;
        this.market_dis = market_dis;
        this.market_creat = market_creat;
        this.market_des = market_des;
        this.market_state = market_state;
    }

    public Market(int manager_id, int market_state, String market_des, String market_creat, String market_dis, String market_name) {
        this.manager_id = manager_id;
        this.market_state = market_state;
        this.market_des = market_des;
        this.market_creat = market_creat;
        this.market_dis = market_dis;
        this.market_name = market_name;
    }
}
