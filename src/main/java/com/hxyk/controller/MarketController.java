package com.hxyk.controller;

import com.hxyk.entity.Classify;
import com.hxyk.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by YM on 2017/6/9.
 */
@Controller
@RequestMapping("market")

public class MarketController {
    @Autowired
    ClassifyService classifyService;

    @RequestMapping("tomain")
    public String toMarket(ModelMap modelMap){
        List<Classify> classifyList = classifyService.getAll();
        modelMap.put("classifyList",classifyList);
        return "front/market/main";
    }
}
