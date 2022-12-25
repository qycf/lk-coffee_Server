package com.lkcoffee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkcoffee.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-11
 */
public interface AddressMapper extends BaseMapper<Address> {


    Address selectByOrderId(@Param("order_id") String orderId);

    List<Address> getUserAddress(@Param("user_id") Integer userId);

    void updateOldDefaultAddress(@Param("user_id") Integer userId);

    void insertAddress(@Param("areaCode") String areaCode,
                       @Param("city") String city,
                       @Param("county") String county,
                       @Param("isDefault") Integer isDefault,
                       @Param("name") String name,
                       @Param("province") String province,
                       @Param("tel") String tel,
                       @Param("addressDetail") String addressDetail);

}
