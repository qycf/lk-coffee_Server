package com.lkcoffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkcoffee.entity.Address;
import com.lkcoffee.mapper.AddressMapper;
import com.lkcoffee.service.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
