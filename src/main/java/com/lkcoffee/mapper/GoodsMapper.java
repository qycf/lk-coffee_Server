package com.lkcoffee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkcoffee.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-07
 */
public interface GoodsMapper extends BaseMapper<Goods> {


    List<Goods> getGoodsByMenuId(@Param("id") Integer menuId);

    List<Goods> getGoodsList();

    List<Goods> getUserLike(@Param("user_id") Integer userId);

    List<Goods> getGoodsListRandom();


}
