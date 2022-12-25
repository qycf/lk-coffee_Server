package com.lkcoffee.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lkcoffee.entity.User;
import com.lkcoffee.exception.APIException;
import com.lkcoffee.result.Result;
import com.lkcoffee.result.ResultCode;
import com.lkcoffee.service.UserService;
import com.lkcoffee.utils.AliyunSendSmsService;
import com.lkcoffee.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.lkcoffee.result.ResultCode.TEL_IS_REGISTER;

@RestController
@RequestMapping("/sms")
@Slf4j
public class SendSmsController {

    private static final String REGISTER_PATH = "code:register:";
    private static final String LOGIN_PATH = "code:login:";

    private static final String LOGIN_TEMPLATE_CODE = "SMS_262575662";
    private static final String REGISTER_TEMPLATE_CODE = "SMS_262475457";


    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;


    @PostMapping("/register/{tel}")
    public Result<Object> sendRegisterCode(@PathVariable("tel") String tel) {

        if (isRegister(tel)) {
            throw new APIException(TEL_IS_REGISTER);
        }
        sendCodeAndSetRedis(tel, REGISTER_TEMPLATE_CODE, REGISTER_PATH);
        return Result.success("验证码已发送至" + tel);
    }

    @PostMapping("/login/{tel}")
    public Result<Object> sendLoginCode(@PathVariable("tel") String tel) {

        if (!isRegister(tel)) {
            throw new APIException(ResultCode.TEL_IS_NOT_REGISTER);
        }
        sendCodeAndSetRedis(tel, LOGIN_TEMPLATE_CODE, LOGIN_PATH);
        return Result.success("验证码已发送至" + tel);
    }


    public boolean isRegister(String phoneNumber) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getTel, phoneNumber);
        User user = userService.getOne(userLambdaQueryWrapper);
        return user != null;
    }

    public void sendCodeAndSetRedis(String tel, String templateCode, String redisPath) {
//        4位整数验证码
        String code = String.valueOf((int) (Math.random() * 9000 + 1000));
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", code);
//        发送验证码
        AliyunSendSmsService.sendMessage(tel, templateCode, codeMap);
//        验证码存入redis
        redisUtil.set(redisPath + tel, code, 300);
    }
}
