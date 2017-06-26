package com.hxyk.dao;

import com.hxyk.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by YM on 2017/6/14.
 */
@Mapper
@Repository
public interface OrdersDao {
    void addOrderNoNum(Orders orders);
}
