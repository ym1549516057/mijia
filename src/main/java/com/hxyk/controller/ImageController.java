package com.hxyk.controller;

import com.google.gson.Gson;
import com.hxyk.entity.Image;
import com.hxyk.service.ImageService;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YM on 2017/6/6.
 */
@Slf4j
@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping("toImage")
    public String toImage(){
        return "back/image";
    }

    @RequestMapping("/toUpdate")
    public String toUpload(int image_id,Map map){
        Image  image = imageService.getByID(image_id);
        map.put("image",image);
        return "back/image_update";
    }
    @PostMapping("/update")
    public String updateIamge(@RequestParam MultipartFile myFile,Image image){
        String name = myFile.getOriginalFilename().substring(myFile.getOriginalFilename().lastIndexOf("\\") + 1);
        String src = upDateQiNiu(myFile);
        image.setImage_name(name);
        image.setImage_src(src);
        imageService.updateImage(image);
        return "redirect:toImage";
    }

    //上传文件
    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile myFile,Image image) {
        //切割字符串获取文件名
        String name = myFile.getOriginalFilename().substring(myFile.getOriginalFilename().lastIndexOf("\\") + 1);
        String src = upDateQiNiu(myFile);
        image.setImage_name(name);
        image.setImage_src(src);
        imageService.uploadImage(image);
        return "redirect:toImage";
    }
    @RequestMapping("/getAllImage")
    @ResponseBody
    public Map toList(@RequestParam(value = "name", required = false, defaultValue = "-1") String isDisplays,int offset, int limit){
        Map map = new HashMap<>();
        int isDisplay = Integer.parseInt(isDisplays);
        map = imageService.getImageByOption(isDisplay,offset,limit);
        return map;
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
