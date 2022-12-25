package com.lkcoffee.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
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
    public HashMap<String, Object> getUserAddress() {
        List<Address> addressList = addressMapper.getDefaultAddress(StpUtil.getLoginIdAsInt());
        HashMap<String, Object> addressInfo = new HashMap<>();
        List<AddressListAddress> addressListAddresses = new ArrayList<>();
        System.out.println(addressList);
        addressList.forEach(address -> {
            AddressListAddress addressListAddress = new AddressListAddress();
            addressListAddress.setId(address.getId());
            addressListAddress.setName(address.getName());
            addressListAddress.setTel(address.getTel());
            addressListAddress.setAddress(address.getProvince() + address.getCity() + address.getCounty() + address.getAddressDetail());
            if (address.getIsDefault() == 1) {
                addressListAddress.setIsDefault(true);
                addressInfo.put("default_address", addressListAddress);
            } else {
                addressListAddresses.add(addressListAddress);
            }
        });
        if (addressListAddresses.size() > 0) {
            addressInfo.put("address_list", addressListAddresses);
        }
        return addressInfo;
    }

    /**
     * 添加/修改用户收货地址
     */

    @PostMapping
    @SaCheckLogin
    public Result<Object> savaOrUpdateAddress(@RequestBody Address address) {
        if (address.getId() == null) {
            int loginIdAsInt = StpUtil.getLoginIdAsInt();
            log.info("用户id:{},新增地址", loginIdAsInt);
            boolean save1 = addressService.save(address);
            UserAddress userAddress = new UserAddress();
            userAddress.setAddressId(address.getId());
            userAddress.setUserId(loginIdAsInt);
            boolean save = userAddressService.save(userAddress);
            if (save && save1) {
                AddressListAddress addressListAddress = new AddressListAddress();
                addressListAddress.setId(address.getId());
                addressListAddress.setName(address.getName());
                addressListAddress.setTel(address.getTel());
                addressListAddress.setAddress(address.getProvince() + address.getCity() + address.getCounty() + address.getAddressDetail());
                if (address.getIsDefault() == 1) {
                    addressListAddress.setIsDefault(true);
                }
                return Result.success(addressListAddress);
            } else
                throw new APIException(ResultCode.FAILED);
        } else {
            log.info("用户id:{},修改地址", StpUtil.getLoginIdAsInt());
            if (!addressService.updateById(address))
                throw new APIException(ResultCode.FAILED);
            return Result.success("修改成功");
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

