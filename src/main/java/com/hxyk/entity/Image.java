package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by YM on 2017/6/7.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private int image_id;
    private String image_name;
    private String image_src;
    private String image_url;
    private int isDisplay;//是否显示 1 ：显示，0 ：不显示 默认为不显示

    public Image(String image_name, String image_src, String image_url, int isDisplay) {
        this.image_name = image_name;
        this.image_src = image_src;
        this.image_url = image_url;
        this.isDisplay = isDisplay;
    }
}
