package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/6/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenement {
    private int tenement_id;
    private String tenement_name;
    private String tenement_psw;
    private String tenement_dis;
    private int community_id;

    public Tenement(String tenement_name, String tenement_psw, String tenement_dis, int community_id) {
        this.tenement_name = tenement_name;
        this.tenement_psw = tenement_psw;
        this.tenement_dis = tenement_dis;
        this.community_id = community_id;
    }
}
