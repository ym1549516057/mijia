package com.hxyk.controller;

import com.hxyk.entity.City;
import com.hxyk.entity.Community;
import com.hxyk.entity.Image;
import com.hxyk.entity.User;
import com.hxyk.service.CityService;
import com.hxyk.service.CommunityService;
import com.hxyk.service.ImageService;
import com.hxyk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by YM on 2017/5/26.
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CommunityService communityService;

    @Autowired
    CityService cityService;

    @Autowired
    ImageService imageService;

    @GetMapping
    public String toNew(){
        return "user/toregister";
    }

    //注册
    @PostMapping
    public String addUser(int validate,User user,HttpSession session,ModelMap modelMap){
        String user_tel = (String)session.getAttribute("user_tel");
        int random =(int)session.getAttribute("validate");
        if(user.getUser_tel().equals(user_tel) && random == validate){
            userService.addUser(user);
            //轮播图片
            List<Image> imageList = imageService.getIamgeByIsDisplay();
            modelMap.put("imageList",imageList);
            //用户小区
            Community communityList = communityService.getCommunityByID(user.getCommunity().getCommunity_id());
            modelMap.put("community",communityList);
            session.setAttribute("community",communityList);
            return "front/market/main";
        }else {
            return "user";
        }
    }
    @GetMapping("tologin")
    public String tologin(){
        return "user/login";
    }

    @PostMapping("login")
    public String login(User user, ModelMap modelMap,HttpSession httpSession){
        User u = userService.loginUser(user);
        if (u != null){
            httpSession.setAttribute("user",u);
            int id = userService.selectCommunityID(u);
            Community community = communityService.getCommunityByID(id);
            List<Image> imageList = imageService.getIamgeByIsDisplay();
            modelMap.put("imageList",imageList);
            modelMap.put("community",community);
            return "user/main";
        }else {
            modelMap.put("error","电话号码或密码不正确！");
            return "user/login";
        }
    }

    @GetMapping("toregister")
    public String toregister(ModelMap modelMap){
        List<City> cityList = cityService.getAllCity();
        modelMap.put("cityList",cityList);
        return "user/register";
    }

    //修改密码
    @RequestMapping("/toupdatepassword")
    public String toUpdatePassword(){
        return "user/password";
    }

    @GetMapping("/getRandom")
    @ResponseBody
    public String getRandom(String user_tel, HttpSession session){
        String tel = user_tel;
        int random = (int)((Math.random()*9+1)*10000);
        session.setAttribute("user_tel",user_tel);
        session.setAttribute("validate",random);
        return ""+random;
    }

    //修改密码
    @RequestMapping("/updatepassword")
    public String updatePassword(User user,int validate){
        User u = userService.selectUserByTel(user);
        u.setPassword(user.getPassword());
        userService.updateUser(u);
        return "user/main";
        }
    //获取用户小区
    @GetMapping("/getUserCommunity")
    public String getUserCommunity(HttpSession httpSession,ModelMap modelMap){
        User  user = (User)httpSession.getAttribute("user");
        int id = userService.selectCommunityID(user);
        Community community = communityService.getCommunityByID(id);
        return "Success";
    }
}
