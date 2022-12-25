package com.lkcoffee.utils;

import com.alibaba.fastjson2.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther: csp1999
 * @Date: 2020/12/18/12:08
 * @Description: 阿里云SMS短信服务Service
 */
@Service
public class AliyunSendSmsService {

    private static String accessKeyId = "LTAI5tRCobEVuRRtLKp8fAE4";

    private static String accessKeySecret = "sPPMcxwkM6UibbxNubn8zpraPAzSYk";

    /**
     * 发送短信验证码
     *
     * @param phone        接收短信的手机号
     * @param templateCode 短信模板CODE
     * @param codeMap      验证码map 集合
     * @return
     */
    public static Boolean sendMessage(String phone, String templateCode, Map<String, Object> codeMap) {

        /**
         * 连接阿里云：
         *
         * 三个参数：
         * regionId 不要动，默认使用官方的
         * accessKeyId 自己的用户accessKeyId
         * accessSecret 自己的用户accessSecret
         */
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        // 构建请求：
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");

        // 自定义参数：
        request.putQueryParameter("PhoneNumbers", phone);// 手机号
        request.putQueryParameter("SignName", "lk咖啡");// 短信签名
        request.putQueryParameter("TemplateCode", templateCode);// 短信模版CODE

        // 构建短信验证码
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(codeMap));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}