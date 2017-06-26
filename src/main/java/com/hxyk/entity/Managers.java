package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/6/12.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Managers {
    private int manager_id;
    private String manager_name;
    private String manager_tel;
    private String password;
    private int manager_state;
    private int market_id;

    public Managers(String manager_name, String manager_tel, String password, int manager_state) {
        this.manager_name = manager_name;
        this.manager_tel = manager_tel;
        this.password = password;
        this.manager_state = manager_state;
    }

    public Managers(String manager_name, String manager_tel, String password, int manager_state, int market_id) {
        this.manager_name = manager_name;
        this.manager_tel = manager_tel;
        this.password = password;
        this.manager_state = manager_state;
        this.market_id = market_id;
    }
}
