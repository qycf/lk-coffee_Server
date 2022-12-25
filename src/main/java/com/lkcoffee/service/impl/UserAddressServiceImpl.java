package com.lkcoffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkcoffee.entity.UserAddress;
import com.lkcoffee.mapper.UserAddressMapper;
import com.lkcoffee.service.UserAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-11
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

}
