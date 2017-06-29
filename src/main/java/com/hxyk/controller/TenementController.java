package com.hxyk.controller;

import com.google.gson.Gson;
import com.hxyk.entity.*;
import com.hxyk.service.RepairsService;
import com.hxyk.service.TenementService;
import com.hxyk.service.VoteService;
import com.hxyk.service.VoteiteamService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/19.
 */
@Controller
@RequestMapping("tenement")
@Slf4j
public class TenementController {
    @Autowired
    RepairsService repairsService;

    @Autowired
    VoteService voteService;

    @Autowired
    TenementService tenementService;

    @Autowired
    VoteiteamService voteiteamService;

    @RequestMapping("tologin")
    public String tologin(){
        return "back/tenement/login";
    }

    @RequestMapping("login")
    public String login(String tenement_name, String tenement_psw, ModelMap modelMap,HttpSession httpSession){
        Tenement tenement= tenementService.loginTenement(tenement_name,tenement_psw);
        if(tenement != null){
            httpSession.setAttribute("tenement",tenement);
            return "back/tenement/vote_list";
        }else{
            modelMap.put("error","用户名或密码错误！");
            return "back/tenement/login";
        }
    }

    @RequestMapping("tomain")
    public String tomain(){
        return "front/tenement/main";
    }

    @RequestMapping("torepairs")
    public String torepairs(){
        return "front/tenement/repairs";
    }


    //投票
    @RequestMapping("toAdd")
    public String toAdd(){
        return "back/tenement/vote_add_1";
    }

    @RequestMapping("tovote")
    public String tovote(Model model,HttpSession httpSession){
        User user =(User) httpSession.getAttribute("user");
        List<Vote> voteList = voteService.getAll(user.getCommunity_id());
        model.addAttribute("voteList",voteList);
        return "front/tenement/vote_list";
    }
    @RequestMapping("tobackVote")
    @ResponseBody
    public Map tobackVote(int offset, int limit,HttpSession httpSession){
        Map map = new HashMap<>();
        Tenement tenement = (Tenement)httpSession.getAttribute("tenement");
        map  = voteService.getVoteByOption(tenement.getCommunity_id(),offset,limit);
        return map;
    }

    //发起新的投票
    @RequestMapping("addVote")
    public String addVote(Vote vote,String viteam_name,MultipartFile[] myFile,HttpSession httpSession){
        vote.setVote_state(0);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        vote.setVote_creat_time(timestamp);//创建时间
        Tenement tenement = (Tenement)httpSession.getAttribute("tenement");
        vote.setCommunity_id(tenement.getCommunity_id());//小区ID
        vote.setVote_count(0);//总票数
        voteService.addVote(vote);
        Voteiteam voteiteam = new Voteiteam();
        for(int i=0;i<viteam_name.split(",").length;i++){
            voteiteam.setViteam_name(viteam_name.split(",")[i]);
            voteiteam.setViteam_count(0);
            voteiteam.setViteam_pic(upDateQiNiu(myFile[i]));
            voteiteam.setVote_id(vote.getVote_id());
            voteiteamService.addVoteiteam(voteiteam);
        }
        return "back/tenement/vote_list";
    }


    //维修
    @RequestMapping("uploadRepairsPic")
    @ResponseBody
    public String uploadRepairsPic(MultipartFile f,Repairs repairs, HttpSession httpSession){
            String repairs_img = upDateQiNiu(f);
            Timestamp timestamp = new Timestamp(new Date().getTime());
            User user =(User)httpSession.getAttribute("user");
            repairs.setUser_id(user.getUser_id());
            repairs.setRepairs_img(repairs_img);
            repairs.setRepairs_commit_time(timestamp);
            repairs.setRepairs_state(0);
            repairsService.addRepairs(repairs);
            return "success";
    }


    //上传到七牛
    public String upDateQiNiu( MultipartFile adverFile){
        String href = "";
        //构造一个带指定Zone对象的配置类--指定服务器位置(华东？华南？)
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        String accessKey = "Z5MPmcOVyT77w-7hhA0n-wwgwizR3pBgvRS6U8yh";
        String secretKey = "WwraxbBLLe9HeQnAXfRpm0Ij_B6H9wxXxvzSGARW";
        String bucket = "images";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        byte[] uploadBytes = new byte[0];
        try {
            uploadBytes = adverFile.getBytes();

        //获取上传凭证
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            Response response = uploadManager.put(uploadBytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
/*            //打印返回的文件名
            System.out.println(putRet.key);
            //打印返回的hash
            System.out.println(putRet.hash);*/
            //
            href = "http://orgtcikfc.bkt.clouddn.com/"+putRet.key;

        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "文件上传失败";
        }
        return href;
    }
}
