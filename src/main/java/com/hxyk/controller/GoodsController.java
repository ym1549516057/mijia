package com.hxyk.controller;

import com.google.gson.Gson;
import com.hxyk.entity.*;
import com.hxyk.service.ClassifyService;
import com.hxyk.service.CommunityService;
import com.hxyk.service.GoodsService;
import com.hxyk.service.UserService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/9.
 */
@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @Autowired
    ClassifyService classifyService;

    @Autowired
    CommunityService communityService;

    @Autowired
    UserService userService;

    @RequestMapping("getGoodsByOption")
    @ResponseBody
    public Map getGoodsByOption(@RequestParam(value = "classify_id", required = false,defaultValue = "-1")String classify_id, int offset, int limit,HttpSession httpSession){
        Map map = new HashMap<>();
        Managers managers = (Managers) httpSession.getAttribute("managers");
        int id = Integer.parseInt(classify_id);
        int market_id = managers.getMarket_id();
        map = goodsService.getGoodsByOption(market_id,id,offset,limit);
        return map;
    }
    @RequestMapping("toGoodsList")
    public String toGoodsList(){
        return "back/community/goods_list";
    }

    @RequestMapping("toAdd")
    public String toAdd(ModelMap modelMap){
        List<Classify> classifyList = classifyService.getAll();
        modelMap.put("classifyList",classifyList);
        return "back/community/goods_add";
    }

    @RequestMapping("addGoods")
    public String addGoods(int classify_id,Goods goods,@RequestParam MultipartFile myFile,HttpSession httpSession){
        String name = myFile.getOriginalFilename().substring(myFile.getOriginalFilename().lastIndexOf("\\") + 1);
        String src = upDateQiNiu(myFile);//图片路径
        goods.setClassify_id(classify_id);//商品分类
        Managers managers = (Managers) httpSession.getAttribute("managers");
        goods.setMarket_id(managers.getMarket_id());
        goods.setGoods_img(src);
        goodsService.addGoods(goods);
        return "back/community/goods_add";
    }
    @RequestMapping("toUpdate")
    public String toUpdate(int goods_id,ModelMap modelMap){
        Goods goods = goodsService.getGoodsById(goods_id);
        modelMap.put("goods",goods);
        List<Classify> classifyList = classifyService.getAll();
        modelMap.put("classifyList",classifyList);
        return "back/community/goods_update";
    }
    @RequestMapping("updateGoods")
    public String updateGoods(int classify_id,Goods goods,@RequestParam MultipartFile myFile,HttpSession httpSession){
        String name = myFile.getOriginalFilename().substring(myFile.getOriginalFilename().lastIndexOf("\\") + 1);
        String src = upDateQiNiu(myFile);//图片路径
        goods.setClassify_id(classify_id);//商品分类
        Managers managers = (Managers) httpSession.getAttribute("managers");
        goods.setMarket_id(managers.getMarket_id());
        goods.setGoods_img(src);
        goodsService.updateGoods(goods);
        return "back/community/goods_list";
    }
    @RequestMapping("getGoodsByClassifyId")
    @ResponseBody
    public List<Goods> getGoodsByClassifyId(@RequestBody int classify_id,HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");
        int id = userService.selectCommunityID(user);
        Community community = communityService.getCommunityByID(id);
        List<Goods> goodsList = goodsService.getGoodsByClassifyId(classify_id,community.getMarket_id());
        return goodsList;
    }



    //上传到七牛
    public String upDateQiNiu( MultipartFile adverFile) {
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
            href = "http://oqjegd1as.bkt.clouddn.com/" + putRet.key;

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
