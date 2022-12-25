package com.lkcoffee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressListAddress {


    //    键名	说明	类型
//    id	每条地址的唯一标识	number | string
//    name	姓名	string
//    tel	手机号	number | string
//    address	详细地址	string
//            isDefault
    private Integer id;
    private String name;
    private String tel;
    private String address;
    private Boolean isDefault;

}
