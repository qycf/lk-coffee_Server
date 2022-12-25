package com.lkcoffee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-12-11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("areaCode")
    private String areaCode;

    private String city;

    private String county;
    @TableField("isDefault")
    private Integer isDefault;

    private String name;

    private String province;

    private String tel;
    @TableField("addressDetail")
    private String addressDetail;

}
