package com.lkcoffee.utils;

import com.upyun.*;
import okhttp3.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

public class UpYunUtils {

    public static Result testSync(byte[] datas, String filename) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        //初始化uploader
        FormUploader uploader = new FormUploader("image-qu2u", "gkqycf", "Ne2vJVBNwHAze6Y8zMna2d6BgyoDObFB");

        //初始化参数组 Map
        final Map<String, Object> paramsMap = new HashMap<String, Object>();

        //添加 SAVE_KEY 参数
        //filename为文件名(例如：12345.jpg)
        paramsMap.put(Params.SAVE_KEY, "/lk/" + filename);

        //添加同步上传作图参数 X_GMKERL_THUMB
        //限定图片宽度为 300px、锐化、压缩质量 80、存储为 png 格式（参数不区分先后顺序）
//        paramsMap.put(Params.X_GMKERL_THUMB, "/fw/300/unsharp/true/quality/80/format/png");
        //打印结果
        Result result = null;
        result = uploader.upload(paramsMap, datas);
//        System.out.println(result);
        return result;
    }

    public static Response deletePic(String fileName) throws IOException, UpException {
        RestManager restManager = new RestManager("image-qu2u", "gkqycf", "Ne2vJVBNwHAze6Y8zMna2d6BgyoDObFB");
        return restManager.deleteFile("/jx3m/"+fileName, null);
    }
}

