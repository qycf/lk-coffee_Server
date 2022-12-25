package com.lkcoffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lkcoffee.entity.Menu;
import com.lkcoffee.mapper.MenuMapper;
import com.lkcoffee.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
