package com.hxyk.controller;

import com.hxyk.entity.Classify;
import com.hxyk.entity.Managers;
import com.hxyk.service.ClassifyService;
import com.hxyk.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by YM on 2017/6/12.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @Autowired
    ClassifyService classifyService;

    @RequestMapping("/toCommunityLogin")
    public String toCommunityLogin(){
        return "back/community/login";
    }

    @RequestMapping("/toregister")
    public String toregister(){return "back/community/register";}

    @RequestMapping("/register")
    public String register(Managers manager){
        managerService.addManager(manager);
        return "redirect:toregister";
    }

    @RequestMapping("/login")
    public String login(String manager_tel, String password, ModelMap modelMap, HttpSession httpSession){
        Managers managers = managerService.login(manager_tel,password);
        if(managers != null){
            if(managers.getManager_state() == 1){
                List<Classify> classifyList =  classifyService.getAll();
                modelMap.put("classifyList",classifyList);
                httpSession.setAttribute("managers",managers);
                return "back/community/goods_list";
            }else{
                modelMap.put("error","正在审核！");
                return "back/community/login";
            }
        }else{
            modelMap.put("error","用户不存在！");
            return "back/community/login";
        }
    }

}
