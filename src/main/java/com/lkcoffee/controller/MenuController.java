package com.lkcoffee.controller;

import com.lkcoffee.entity.Menu;
import com.lkcoffee.exception.APIException;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单相关
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-07
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 获取菜单列表
     *
     * @return Result
     */
    @GetMapping
    public Result<Object> getMenuList() {
        List<Menu> list = menuService.list();
        return Result.success(list);
    }

    /**
     * 添加/修改菜单
     *
     * @param menu 菜单
     * @return Result
     */
    @PostMapping
    public boolean saveOrUpdateMenu(@RequestBody Menu menu) {
        boolean save = menuService.saveOrUpdate(menu);
        if (!save) {
            throw new APIException("保存失败");
        }
        return true;
    }

    /**
     * 删除菜单
     *
     * @param id 菜单id
     * @return Result
     */
    @DeleteMapping("{id}")
    public boolean deleteMenuById(@PathVariable String id) {
        boolean remove = menuService.removeById(id);
        if (!remove) {
            throw new APIException("删除失败");
        }
        return true;
    }
}
