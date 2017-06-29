package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/6/27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voteiteam {
    private int viteam_id;
    private String viteam_name;
    private int viteam_count;
    private String viteam_pic;
    private int vote_id;

    public Voteiteam(String viteam_name, String viteam_pic, int viteam_count,int vote_id) {
        this.viteam_name = viteam_name;
        this.viteam_pic = viteam_pic;
        this.viteam_count = viteam_count;
        this.vote_id=vote_id;
    }
}
