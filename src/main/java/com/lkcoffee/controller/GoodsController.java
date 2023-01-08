package com.lkcoffee.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lkcoffee.entity.Goods;
import com.lkcoffee.entity.MenuGoods;
import com.lkcoffee.entity.UserLike;
import com.lkcoffee.exception.APIException;
import com.lkcoffee.mapper.GoodsMapper;
import com.lkcoffee.pojo.GoodsDto;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.GoodsService;
import com.lkcoffee.service.MenuGoodsService;
import com.lkcoffee.service.UserLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-07
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsService goodsService;

    @Resource
    MenuGoodsService menuGoodsService;

    @Resource
    private UserLikeService userLikeService;

    @GetMapping("/menu")
    public List<Goods> getGoodsList() {
        return goodsMapper.getGoodsList();
    }

    @GetMapping("random")
    public List<Goods> getGoodsListRandom() {
        return goodsMapper.getGoodsListRandom();
    }


    @GetMapping("/menu/{menuId}")
    public List<Goods> getGoodsListByMenuId(@PathVariable(required = false) Integer menuId) {
        if (menuId == null) {
            return goodsMapper.getGoodsList();
        }
        List<Goods> goodsByMenuId = goodsMapper.getGoodsByMenuId(menuId);
        System.out.println(goodsByMenuId);
        if (goodsByMenuId.get(0) == null) {
            throw new APIException("该分类下没有商品");
        }
        return goodsByMenuId;
    }


    /**
     * 商品添加/修改
     * @param goodsDto
     * @return
     */

    @SaCheckRole("admin")
    @PostMapping
    public Result<Object> saveOrUpdateGoods(@RequestBody GoodsDto goodsDto) {
        Goods goods = new Goods();
        goods.setId(goodsDto.getId());
        goods.setDetail(goodsDto.getDetail());
        goods.setOriginPrice(goodsDto.getOriginPrice());
        goods.setPrice(goodsDto.getPrice());
        goods.setTitle(goodsDto.getTitle());
        goods.setThumb(goodsDto.getThumb());
        boolean save = goodsService.saveOrUpdate(goods);
        if (save) {
            MenuGoods menuGoods = new MenuGoods();
            menuGoods.setGoodsId(goods.getId());
            menuGoods.setMenuId(goodsDto.getMenuId());
            UpdateWrapper<MenuGoods> menuGoodsUpdateWrapper = new UpdateWrapper<>();
            menuGoodsUpdateWrapper.eq("goods_id", goods.getId());
            menuGoodsUpdateWrapper.set("menu_id", goodsDto.getMenuId());
            menuGoodsService.saveOrUpdate(menuGoods, menuGoodsUpdateWrapper);
            return Result.success("成功");
        } else {
            throw new APIException("保存失败");
        }
    }

    @GetMapping("/")
    public List<Goods> getGoodsListByKeyword(@RequestParam String keyword) {
        LambdaQueryWrapper<Goods> goodsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        goodsLambdaQueryWrapper.like(Goods::getTitle, keyword);
        return goodsService.list(goodsLambdaQueryWrapper);
    }


    /**
     * 商品删除
     * @param id
     * @return
     */
    @SaCheckRole("admin")
    @DeleteMapping("{id}")
    public boolean deleteGoodsById(@PathVariable String id) {
        boolean remove = goodsService.removeById(id);
        if (!remove) {
            throw new APIException("删除失败");
        }
        return true;
    }

    @GetMapping("{id}")
    public HashMap<String, Object> getGoodsById(@PathVariable Integer id) {
        boolean isLike = false;
        Goods goods = goodsService.getById(id);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        if (StpUtil.isLogin()) {
            Integer userId = StpUtil.getLoginIdAsInt();
            UserLike one = userLikeService.getOne(new LambdaQueryWrapper<UserLike>().eq(UserLike::getUserId, userId).eq(UserLike::getGoodsId, id));
            if (one != null) {
                isLike = true;
            }
        }
        stringObjectHashMap.put("isLike", isLike);
        stringObjectHashMap.put("goods", goods);
        return stringObjectHashMap;
    }

}
