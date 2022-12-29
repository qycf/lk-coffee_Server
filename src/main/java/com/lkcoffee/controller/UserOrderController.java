package com.lkcoffee.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lkcoffee.entity.Address;
import com.lkcoffee.entity.OrderGoods;
import com.lkcoffee.entity.UserOrder;
import com.lkcoffee.mapper.AddressMapper;
import com.lkcoffee.mapper.UserOrderMapper;
import com.lkcoffee.pojo.CartDto;
import com.lkcoffee.pojo.OrderGoodsVO;
import com.lkcoffee.pojo.OrderVo;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.OrderAddressService;
import com.lkcoffee.service.OrderGoodsService;
import com.lkcoffee.service.UserOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户订单相关
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-10
 */
@RestController
@RequestMapping("/user/order")
@SaCheckLogin
public class UserOrderController {

    @Resource
    private UserOrderMapper userOrderMapper;


    @Resource
    private UserOrderService userOrderService;

    @Resource
    private OrderGoodsService orderGoodsService;

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private OrderAddressService orderAddressService;

    /**
     * 获取用户订单列表
     *
     * @return Result
     */
    @GetMapping("/list/{status}")
    public HashMap<String, Object> getUserOrderByStatus(@PathVariable String status) {
        LambdaQueryWrapper<UserOrder> userOrderLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userOrderLambdaQueryWrapper.eq(UserOrder::getUserId, StpUtil.getLoginIdAsInt()).eq(UserOrder::getStatus, status).orderByDesc(UserOrder::getCreateTime);
//        userOrderLambdaQueryWrapper.eq(UserOrder::getUserId, StpUtil.getLoginIdAsInt()).orderByDesc(UserOrder::getCreateTime);
////        用户订单ID列表  用于查询订单商品
        List<UserOrder> list = userOrderService.list(userOrderLambdaQueryWrapper);
        HashMap<String, Object> order_info = new HashMap<>();
        List<OrderVo> orderList = new ArrayList<>();
        System.out.println("list" + list);
        list.forEach(userOrder -> {
            OrderVo orderVo = new OrderVo();
//            订单id
            orderVo.setOrderId(userOrder.getOrderId());
            System.out.println("订单id" + userOrder.getOrderId());
//            订单时间
            orderVo.setCreateTime(userOrder.getCreateTime());
//            订单状态
            orderVo.setStatus(userOrder.getStatus());
////            订单地址
            Address addressInfo = addressMapper.selectByOrderId(userOrder.getOrderId());
//            拼接地址
            String address = addressInfo.getProvince() + addressInfo.getCity() + addressInfo.getCounty() + addressInfo.getAddressDetail();
            orderVo.setAddress(address);
            orderVo.setAddressDetail(addressInfo.getAddressDetail());
//            该订单下的商品
            List<OrderGoodsVO> orderGoodsListByOrderId = userOrderMapper.getOrderGoodsListByOrderId(userOrder.getOrderId());
            orderVo.setGoodsList(orderGoodsListByOrderId);
            orderList.add(orderVo);
        });
        order_info.put("order_count", list.size());
        order_info.put("order_list", orderList);
        return order_info;
    }

    @GetMapping("/list")
    public HashMap<String, Object> getUserOrder() {
        LambdaQueryWrapper<UserOrder> userOrderLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userOrderLambdaQueryWrapper.eq(UserOrder::getUserId, StpUtil.getLoginIdAsInt()).orderByDesc(UserOrder::getCreateTime);
//        userOrderLambdaQueryWrapper.eq(UserOrder::getUserId, StpUtil.getLoginIdAsInt()).orderByDesc(UserOrder::getCreateTime);
////        用户订单ID列表  用于查询订单商品
        List<UserOrder> list = userOrderService.list(userOrderLambdaQueryWrapper);
        HashMap<String, Object> order_info = new HashMap<>();
        List<OrderVo> orderList = new ArrayList<>();
        System.out.println("list" + list);
        list.forEach(userOrder -> {
            OrderVo orderVo = new OrderVo();
//            订单id
            orderVo.setOrderId(userOrder.getOrderId());
            System.out.println("订单id" + userOrder.getOrderId());
//            订单时间
            orderVo.setCreateTime(userOrder.getCreateTime());
//            订单状态
            orderVo.setStatus(userOrder.getStatus());
////            订单地址
            Address addressInfo = addressMapper.selectByOrderId(userOrder.getOrderId());
//            拼接地址
            String address = addressInfo.getProvince() + addressInfo.getCity() + addressInfo.getCounty() + addressInfo.getAddressDetail();
            orderVo.setAddress(address);
            orderVo.setAddressDetail(addressInfo.getAddressDetail());
//            该订单下的商品
            List<OrderGoodsVO> orderGoodsListByOrderId = userOrderMapper.getOrderGoodsListByOrderId(userOrder.getOrderId());
            orderVo.setGoodsList(orderGoodsListByOrderId);
            orderList.add(orderVo);
        });
        order_info.put("order_count", list.size());
        order_info.put("order_list", orderList);
        return order_info;
    }

    /**
     * 修改订单状态
     *
     * @param orderId 订单id
     * @return Result
     */

    @PostMapping("{orderId}")
    @SaCheckLogin
    public Result<Object> updateOrderStatus(@PathVariable String orderId) {
//        修改status为1
        UpdateWrapper<UserOrder> userOrderUpdateWrapper = new UpdateWrapper<>();
        userOrderUpdateWrapper.eq("order_id", orderId).eq("user_id", StpUtil.getLoginIdAsInt()).set("status", 1);
        userOrderService.update(userOrderUpdateWrapper);
        return Result.success("修改成功");
    }

    //    添加订单（下单）
    @PutMapping
    public Result<Object> putUserOrder(@RequestBody CartDto cartDto) {
        List<OrderGoods> goodsIdList = cartDto.getGoodsIdList();
        goodsIdList.forEach(item -> {
            orderGoodsService.save(item);
        });
        orderAddressService.save(cartDto.getOrderAddress());
        userOrderService.save(cartDto.getUserOrder());
        return Result.success("订单创建成功");
    }


}
