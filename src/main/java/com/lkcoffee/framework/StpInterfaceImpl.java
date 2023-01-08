package com.lkcoffee.framework;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.lkcoffee.mapper.RoleMapper;
import com.lkcoffee.mapper.UserRoleMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StpInterfaceImpl implements StpInterface {


    @Resource
    private RoleMapper roleMapper;


    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        return null;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> roleList = new ArrayList<>();
        roleMapper.selectByUserId(Integer.parseInt(loginId.toString())).forEach(role -> {
            roleList.add(role.getCode());
        });
        System.out.println(roleList);
        return roleList;
    }
}
