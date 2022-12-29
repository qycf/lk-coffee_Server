package com.lkcoffee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lkcoffee.entity.Menu;
import com.lkcoffee.pojo.MenuVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-07
 */
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("SELECT \n" +
            "  @row_number:=@row_number+1 as mid, \n" +
            "  id, \n" +
            "  title, \n" +
            "  path\n" +
            "FROM menu, (SELECT @row_number:=-1) as t\n")
    List<MenuVo> getMenuList();
}
