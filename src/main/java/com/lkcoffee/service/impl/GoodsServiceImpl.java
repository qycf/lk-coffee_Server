package com.lkcoffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkcoffee.entity.Goods;
import com.lkcoffee.mapper.GoodsMapper;
import com.lkcoffee.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-07
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}
