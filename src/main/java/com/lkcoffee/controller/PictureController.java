package com.lkcoffee.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qu2u.jx3m.entity.Picture;
import com.qu2u.jx3m.pojo.PictureDto;
import com.qu2u.jx3m.result.Response;
import com.qu2u.jx3m.service.PictureService;
import com.qu2u.jx3m.utils.PageDtoUtil;
import com.qu2u.jx3m.utils.UpYunUtils;
import com.qu2u.jx3m.utils.mapstruct.PictureMS;
import com.upyun.Result;
import com.upyun.UpException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

import static com.qu2u.jx3m.utils.UpYunUtils.testSync;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qiuyue
 * @since 2022-11-21
 */
@RestController
@RequestMapping("/jx3m/picture")
public class PictureController {

    @Resource
    private PictureService pictureService;

    @PostMapping
    public Result addPicture(@RequestPart("file") MultipartFile file, @RequestPart("picture") PictureDto picture) throws Exception{
        //上传的文件名
        String filename = file.getOriginalFilename();

        //获取文件的后缀
//        String suffixName = filename.substring(filename.lastIndexOf("."));
        //生成一个新的文件名
//        filename= UUID.randomUUID()+suffixName;
        System.out.println("要上传服务器的文件名是:"+filename);
        //上传又拍云

        byte [] byteArr=file.getBytes();
        Result upyunData = testSync(byteArr,filename);
        //将json转换为Object对象(这里需要引入fastjson依赖)
        if (upyunData.getCode()==200){
            System.out.println(picture);
            JSONObject photoMsg = JSONObject.parseObject(upyunData.getMsg());
            String picUrl = "https://cdn1.zcsuper.cn" + photoMsg.getString("url");
            System.out.println("文件上传成功，地址为："+picUrl);
            Picture convert = PictureMS.INSTANCE.convert(picture);
            convert.setPicUrl(picUrl);
            System.out.println(convert);
            pictureService.save(convert);
        }

        return upyunData;
    }
    @DeleteMapping
    public okhttp3.Response deletePicture(@RequestParam("id") Integer id, @RequestParam("picUrl") String picUrl) throws UpException, IOException {
        pictureService.removeById(id);
        String[] split = picUrl.split("/");
        picUrl = split[split.length-1];
        return UpYunUtils.deletePic(picUrl);
    }


    @GetMapping
    public Response<Object> getPicture(@RequestParam(value = "page_num",required = false,defaultValue = "1") Integer pageNum){
        return  Response.success(PageDtoUtil.getPageDto(pictureService.list(),pageNum,10));
    }

    @GetMapping("/map")
    public Response<Object> getPictureByMap(@RequestParam("page_num") Integer pageNum,@RequestParam("map") Integer map){
        LambdaQueryWrapper<Picture> pictureLambdaQueryWrapper = new LambdaQueryWrapper<>();
        pictureLambdaQueryWrapper.eq(Picture::getMap,map);
        return  Response.success(PageDtoUtil.getPageDto(pictureService.list(pictureLambdaQueryWrapper),pageNum,16));
    }
}
