package com.lkcoffee.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lkcoffee.entity.User;
import com.lkcoffee.entity.UserRole;
import com.lkcoffee.exception.APIException;
import com.lkcoffee.mapper.UserMapper;
import com.lkcoffee.pojo.*;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.UserRoleService;
import com.lkcoffee.service.UserService;
import com.lkcoffee.utils.RedisUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static com.lkcoffee.utils.UpYunUtils.testSync;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/user")
public class UserController {


    private static final String REGISTER_PATH = "code:register:";
    private static final String LOGIN_PATH = "code:login:";


    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RedisUtil redisUtil;


    @PostMapping("/login/tel")
    public HashMap<String, Object> loginWithTel(@RequestBody TelLoginDto telLoginDto) {
        boolean b = codeIsTrue(LOGIN_PATH, telLoginDto.getTel(), telLoginDto.getVerifyCode());
        if (!b) {
            throw new APIException("验证码错误");
        }
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getTel, telLoginDto.getTel()));
//        判断对象为null
        if (Objects.isNull(user)) {
            throw new APIException("用户不存在");
        }
        StpUtil.login(user.getId());
        UserVo userInfo = userMapper.selectByPhoneNumber(user.getTel());
        String tel = DesensitizedUtil.mobilePhone(userInfo.getTel());
        userInfo.setTel(tel);
        HashMap<String, Object> loginSuccessInfo = new HashMap<>();
        loginSuccessInfo.put("token", StpUtil.getTokenValue());
        loginSuccessInfo.put("user_info", userInfo);
        return loginSuccessInfo;
    }

    @PostMapping("/login/pw")
    public HashMap<String, Object> loginWithPw(@RequestBody PwLoginDto pwLoginDto) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getTel, pwLoginDto.getTel()).eq(User::getPassword, DigestUtil.md5Hex(pwLoginDto.getPassword())));
        if (Objects.isNull(user)) {
            throw new APIException("手机号或密码错误");
        }
        UserVo userInfo = userMapper.selectByPhoneNumber(user.getTel());
        String tel = DesensitizedUtil.mobilePhone(userInfo.getTel());
        userInfo.setTel(tel);
        StpUtil.login(user.getId());
        HashMap<String, Object> loginSuccessInfo = new HashMap<>();
        loginSuccessInfo.put("token", StpUtil.getTokenValue());
        loginSuccessInfo.put("user_info", userInfo);
        return loginSuccessInfo;
    }


    @PutMapping
    public HashMap<String, Object> register(@RequestBody RegisterDto registerDto) {
        boolean b = codeIsTrue(REGISTER_PATH, registerDto.getPhoneNumber(), registerDto.getCode());
        if (!b) {
            throw new APIException("验证码错误");
        }
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getTel, registerDto.getPhoneNumber());
        User one = userService.getOne(lambdaQueryWrapper);
        if (one != null) {
            throw new APIException("该手机号已注册");
        }

        User newUser = new User().setUsername(registerDto.getUsername()).setPassword(DigestUtil.md5Hex(registerDto.getPassword())).setTel(registerDto.getPhoneNumber());
        userService.save(newUser);
//        设置新用户角色
        userRoleService.save(new UserRole(null, newUser.getId(), 2));
        UserVo userInfo = userMapper.selectByPhoneNumber(registerDto.getPhoneNumber());
        String tel = DesensitizedUtil.mobilePhone(userInfo.getTel());
        userInfo.setTel(tel);
        StpUtil.login(newUser.getId());
        HashMap<String, Object> regSuccessInfo = new HashMap<>();
        regSuccessInfo.put("token", StpUtil.getTokenValue());
        regSuccessInfo.put("user_info", userInfo);
        return regSuccessInfo;
    }

    @PostMapping("logout")
    @SaCheckLogin
    public Result<Object> logout() {
        StpUtil.logout();
        return Result.success("退出成功");
    }


    @PostMapping
    public Result<Object> updateUserInfo(@RequestBody @Validated User updateUserInfoDto) {
        User user = new User().setId(updateUserInfoDto.getId()).setUsername(updateUserInfoDto.getUsername()).setTel(updateUserInfoDto.getTel());
        userService.updateById(user);
        return Result.success("修改成功");
    }

    @PostMapping("/avatar")
    @SaCheckLogin
    public Result<Object> updateAvatar(@RequestParam("file") MultipartFile file) throws IOException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        //上传的文件名
        String filename = file.getOriginalFilename();
        System.out.println("要上传服务器的文件名是:" + filename);
        //获取文件的后缀
        assert filename != null;
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //生成一个新的文件名
        filename = UUID.randomUUID() + suffixName;
        System.out.println("要上传服务器的文件名是:" + filename);

        byte[] byteArr = file.getBytes();
        com.upyun.Result upyunData = testSync(byteArr, filename);
        //将json转换为Object对象(这里需要引入fastjson依赖)
        if (upyunData.getCode() == 200) {
            JSONObject photoMsg = JSONObject.parseObject(upyunData.getMsg());
            String picUrl = "https://cdn1.zcsuper.cn" + photoMsg.getString("url");
            System.out.println("文件上传成功，地址为：" + picUrl);
            userMapper.updateAva(StpUtil.getLoginIdAsInt(), picUrl);
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("imgurl", picUrl);
            return Result.success(stringObjectHashMap);
        }
        return Result.fail("上传失败");
    }

    @PostMapping("/avatar/random")
    @SaCheckLogin
    public Result<Object> setRandomAva() {
        String url = "http://api.btstu.cn/sjtx/api.php?lx=c1&format=json";
        String result = HttpUtil.get(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String imgUrl = jsonObject.get("imgurl").toString();
        userMapper.updateAva(StpUtil.getLoginIdAsInt(), imgUrl);
        return Result.success(jsonObject);
    }

    @PostMapping("/update/{type}")
    @SaCheckLogin
    public Result<Object> updatePassword(@RequestParam String value, @PathVariable String type) {
        if (type.equals("password")) {
            value = DigestUtil.md5Hex(value);
        }
        userMapper.updateProfile(StpUtil.getLoginIdAsInt(), type, value);
        return Result.success("修改成功");
    }


    public boolean codeIsTrue(String redisPath, String phoneNumber, String code) {

        if (!redisUtil.hasKey(redisPath + phoneNumber)) {
            return false;
        }
//        校验验证码
        String verify_code = redisUtil.get(redisPath + phoneNumber).toString();
        return verify_code.equals(code);
    }
}
