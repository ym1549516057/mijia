package com.hxyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YM on 2017/6/2.
 */
@RequestMapping("back")
@Controller
public class BackController {
    @RequestMapping("tologin")
    public String tologin(){
        return "back/login";
    }
    @RequestMapping("login")
    public String login(String user_name, String password, Model model){
        if(user_name.equals("admin") && password.equals("123456")){
            return "back/welcome";
        }else{
            model.addAttribute("error","用户名或密码错误");
            return "back/login";
        }
    }
}
