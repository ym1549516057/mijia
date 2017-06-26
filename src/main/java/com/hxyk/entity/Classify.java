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
public class Classify {
    private int  classify_id;
    private String classify_name;

    public Classify(String classify_name) {
        this.classify_name = classify_name;
    }
}
