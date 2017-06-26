package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**NO
 * Created by YM on 2017/5/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private int city_id;
    private String city_name;

    public City(String city_name) {
        this.city_name = city_name;
    }
}
