package com.hxyk.controller;

import com.hxyk.entity.Orderiteam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by YM on 2017/6/16.
 */
@RequestMapping("/orders")
@Controller
@Slf4j
public class OrderController {


    @RequestMapping("/tomain")
    @ResponseBody
    public String toMain(@RequestBody ArrayList<Orderiteam> totalIteam){
        log.info("totalIteam={}",totalIteam);
        return "success";
    }
}
