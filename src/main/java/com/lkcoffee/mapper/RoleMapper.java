package com.lkcoffee.mapper;

import com.lkcoffee.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkcoffee.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qiuyue
 * @since 2023-01-06
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectByUserId(@Param("user_id") Integer userId);
}
