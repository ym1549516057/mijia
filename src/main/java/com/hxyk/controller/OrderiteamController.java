package com.hxyk.controller;

import com.hxyk.entity.Orderiteam;
import com.hxyk.entity.User;
import com.hxyk.service.OrderService;
import com.hxyk.service.OrderiteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/14.
 */
@Controller
@RequestMapping("orderiteam")
public class OrderiteamController {
    @Autowired
    OrderiteamService orderiteamService;

    @Autowired
    OrderService orderService;

    @RequestMapping("addOrderiteam")
    @ResponseBody
    public String addOrderiteam(@RequestBody Orderiteam orderiteam, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");
        orderiteam.setIteam_state(0);
        orderiteam.setUser_id(user.getUser_id());
        Orderiteam o = orderiteamService.getByGoodsId(orderiteam.getGoods_id(),user.getUser_id());
        if(o == null){
            orderiteamService.addOrderiteam(orderiteam);
        }else{
            orderiteam.setIteam_id(o.getIteam_id());
            if(orderiteam.getIteam_total() > 0){
                orderiteamService.updateOrderiteam(orderiteam);
            }else{
                orderiteamService.delOrderiteamById(orderiteam.getIteam_id());
            }
        }
        return "success";
    }
    @RequestMapping("toIteam")
    public String toIteam(){
        return "front/market/iteam";
    }

    @RequestMapping("getUserIteam")
    @ResponseBody
    public List<Orderiteam> getUserIteam(HttpSession httpSession){
        User user =(User) httpSession.getAttribute("user");
        List<Orderiteam> orderiteamList = orderiteamService.getUserIteam(user.getUser_id(),0);
        return orderiteamList;
    }
}
