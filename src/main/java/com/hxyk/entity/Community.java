package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/5/27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    private int community_id;
    private String community_name;
    private int city_id;
    private int market_id;

    public Community(String community_name) {
        this.community_name = community_name;
    }

    public Community(int city_id, String community_name) {
        this.city_id = city_id;
        this.community_name = community_name;
    }

    public Community(String community_name, int city_id, int market_id) {
        this.community_name = community_name;
        this.city_id = city_id;
        this.market_id = market_id;
    }
}
