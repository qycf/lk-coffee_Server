package com.lkcoffee.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.lkcoffee.entity.OrderAddress;
import com.lkcoffee.entity.OrderGoods;
import com.lkcoffee.entity.UserOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class CartDto {
    @JsonProperty("user_order")
    private UserOrder userOrder;

    @JsonProperty("order_address")
    private OrderAddress orderAddress;

    @JsonProperty("goods_list")
    private List<OrderGoods> goodsIdList;
}
