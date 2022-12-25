package com.lkcoffee.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderGoodsVO {

    private Integer id;
    private String title;
    private String detail;
    private Double price;
    private String originPrice;
    private String thumb;
    private String cup;
    private String temperature;
    private String sugar;
    private Integer count;
}
