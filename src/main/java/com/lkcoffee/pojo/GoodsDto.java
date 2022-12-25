package com.lkcoffee.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-07
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {
    private Integer id;

    private String title;

    private String detail;

    private Double price;

    private String originPrice;

    private String thumb;

    @JsonProperty("menu_id")
    private Integer menuId;

}

