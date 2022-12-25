package com.lkcoffee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkcoffee.entity.UserOrder;
import com.lkcoffee.pojo.OrderGoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-10
 */
public interface UserOrderMapper extends BaseMapper<UserOrder> {

    List<OrderGoodsVO> getOrderGoodsListByOrderId(@Param("orderId") String orderId);

}
