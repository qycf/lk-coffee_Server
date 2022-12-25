package com.lkcoffee.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.lkcoffee.mapper.UserMapper;
import com.lkcoffee.pojo.UserVo;
import com.lkcoffee.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private UserMapper userMapper;

    @GetMapping
    @SaCheckLogin
    public Result<Object> getRoleByToken() {
        int loginIdAsInt = StpUtil.getLoginIdAsInt();
        UserVo userVo = userMapper.selectById(loginIdAsInt);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("role_code", userVo.getRoleCode());
        return Result.success(stringObjectHashMap);
    }

    @GetMapping("test")
    public void test() {
        StpUtil.login(2);
    }

}

