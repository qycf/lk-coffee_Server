package com.lkcoffee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkcoffee.entity.User;
import com.lkcoffee.pojo.UserVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-06
 */
public interface UserMapper extends BaseMapper<User> {


    UserVo selectByPhoneNumberAndPwd(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

    UserVo selectByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    UserVo selectById(@Param("id") Integer id);

    void updateAva(@Param("user_id") Integer id, @Param("pic_url") String picUrl);

    void updateProfile(@Param("user_id") Integer id, @Param("type") String type, @Param("value") String value);


}
