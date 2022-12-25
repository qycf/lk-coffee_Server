package com.lkcoffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkcoffee.entity.UserOrder;
import com.lkcoffee.mapper.UserOrderMapper;
import com.lkcoffee.service.UserOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-10
 */
@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

}
