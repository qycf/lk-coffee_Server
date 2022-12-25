package com.lkcoffee.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lkcoffee.entity.User;
import com.lkcoffee.entity.UserRole;
import com.lkcoffee.exception.APIException;
import com.lkcoffee.mapper.UserMapper;
import com.lkcoffee.pojo.PwLoginDto;
import com.lkcoffee.pojo.RegisterDto;
import com.lkcoffee.pojo.TelLoginDto;
import com.lkcoffee.pojo.UserVo;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.UserRoleService;
import com.lkcoffee.service.UserService;
import com.lkcoffee.utils.RedisUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

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


    public boolean codeIsTrue(String redisPath, String phoneNumber, String code) {

        if (!redisUtil.hasKey(redisPath + phoneNumber)) {
            return false;
        }
//        校验验证码
        String verify_code = redisUtil.get(redisPath + phoneNumber).toString();
        return verify_code.equals(code);
    }
}
