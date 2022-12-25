package com.lkcoffee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-10
 */
@TableName("order_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("goods_id")
    private Integer goodsId;
    private Integer count;
    private String cup;
    private String sugar;
    private String temperature;

}
