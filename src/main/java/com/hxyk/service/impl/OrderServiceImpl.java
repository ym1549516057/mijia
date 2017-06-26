package com.hxyk.service.impl;

import com.hxyk.dao.OrdersDao;
import com.hxyk.entity.Orders;
import com.hxyk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YM on 2017/6/14.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrdersDao ordersDao;

    @Override
    public void addOrderNoNum(Orders orders) {
        ordersDao.addOrderNoNum(orders);
    }
}
