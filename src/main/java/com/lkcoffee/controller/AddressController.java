package com.lkcoffee.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lkcoffee.entity.Address;
import com.lkcoffee.entity.UserAddress;
import com.lkcoffee.exception.APIException;
import com.lkcoffee.mapper.AddressMapper;
import com.lkcoffee.pojo.AddressListAddress;
import com.lkcoffee.result.Result;
import com.lkcoffee.result.ResultCode;
import com.lkcoffee.service.AddressService;
import com.lkcoffee.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-11
 */
@RestController
@RequestMapping("/user/address")
@Slf4j
@SaCheckLogin
public class AddressController {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private AddressService addressService;

    @Resource
    private UserAddressService userAddressService;


    /**
     * 获取用户的收货地址列表
     *
     * @return addressInfo
     */
    @GetMapping
    public List<AddressListAddress> getUserAddress() {
//        用户的收获地址列表
        List<Address> addressList = addressMapper.getUserAddress(StpUtil.getLoginIdAsInt());
        List<AddressListAddress> addressListAddresses = new ArrayList<>();
//        拼接id地址为前端所需格式
        addressList.forEach(address -> {
            AddressListAddress addressListAddress = new AddressListAddress();
            addressListAddress.setId(address.getId());
            addressListAddress.setName(address.getName());
            addressListAddress.setTel(address.getTel());
            addressListAddress.setAddress(address.getProvince() + address.getCity() + address.getCounty() + address.getAddressDetail());
            if (address.getIsDefault() == 1) {
                addressListAddress.setIsDefault(true);
            }
            //           添加到返回的数据中
            addressListAddresses.add(addressListAddress);
        });
        if (addressListAddresses.size() > 0) {
            return addressListAddresses;
        }
        return null;
    }

    /**
     * 添加/修改用户收货地址
     */

    @PostMapping
    @SaCheckLogin
    public void savaOrUpdateAddress(@RequestBody Address address) {
        // id为null则是添加地址操作
        int user_id = StpUtil.getLoginIdAsInt();
        if (address.getIsDefault() == 1) {
            // 如果是默认地址则将原来的默认地址设置为非默认地址
            addressMapper.updateOldDefaultAddress(StpUtil.getLoginIdAsInt());
        }
        if (address.getId() == null) {
            log.info("用户id:{},新增地址", user_id);
            addressService.save(address);
            UserAddress userAddress = new UserAddress();
            userAddress.setUserId(user_id);
            userAddress.setAddressId(address.getId());
            userAddressService.save(userAddress);
        } else {
            // id不为null则是修改地址操作
            log.info("用户id:{},修改地址", StpUtil.getLoginIdAsInt());
            addressService.updateById(address);
        }
    }

    /**
     * 根据收货地址id获取收货信息
     */
    @GetMapping("{id}")
    public Address getAddressById(@PathVariable String id) throws APIException {
        return addressService.getById(id);
    }

    /**
     * 设置用户默认的收货地址
     */
    @PostMapping("/default/{address_id}")
    public Result<Object> updateDefaultAddress(@PathVariable String address_id) {
        UpdateWrapper<Address> addressUpdateWrapper = new UpdateWrapper<>();
        addressUpdateWrapper.set("isDefault", 0)
                .eq("id", address_id);

        return Result.success("修改默认地址成功");
    }

    /**
     * 删除用户收货地址
     */
    @DeleteMapping("{id}")
    public Result<Object> deleteAddress(@PathVariable String id) {
        LambdaQueryWrapper<UserAddress> eq = new LambdaQueryWrapper<UserAddress>().eq(UserAddress::getAddressId, id);
        boolean remove1 = userAddressService.remove(eq);
        boolean remove = addressService.removeById(id);
        if (remove && remove1) {
            return Result.success("删除成功");
        } else {
            throw new APIException("删除失败");
        }
    }
}

