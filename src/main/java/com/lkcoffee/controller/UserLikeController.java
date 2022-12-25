package com.lkcoffee.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lkcoffee.entity.Goods;
import com.lkcoffee.entity.UserLike;
import com.lkcoffee.mapper.GoodsMapper;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.UserLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户-我的喜欢
 * </p>
 *
 * @author qiuyue
 * @since 2022-12-12
 */
@Slf4j
@RestController
@RequestMapping("/user/like")
@SaCheckLogin
public class UserLikeController {

    @Resource
    private UserLikeService userLikeService;

    @Resource
    private GoodsMapper goodsMapper;

    @PostMapping
    public Result<Object> addLike(@RequestBody UserLike userLike) {
        LambdaQueryWrapper<UserLike> userLikeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLikeLambdaQueryWrapper.eq(UserLike::getUserId, userLike.getUserId())
                .eq(UserLike::getGoodsId, userLike.getGoodsId());
        if (userLikeService.getOne(userLikeLambdaQueryWrapper) == null) {
            log.info("用户ID{},新增收藏商品ID{}", userLike.getUserId(), userLike.getGoodsId());
            userLikeService.save(userLike);
        } else {
            log.info("用户ID{},取消收藏商品ID{}", userLike.getUserId(), userLike.getGoodsId());
            userLikeService.remove(userLikeLambdaQueryWrapper);
        }
        return Result.success("ok");
    }

    @GetMapping("/id")
    public List<UserLike> getLike() {
        LambdaQueryWrapper<UserLike> userLikeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLikeLambdaQueryWrapper.eq(UserLike::getUserId, StpUtil.getLoginIdAsInt());
        return userLikeService.list(userLikeLambdaQueryWrapper);
    }

    @GetMapping()
    public List<Goods> getGoodsListByUserId() {
        return goodsMapper.getUserLike(StpUtil.getLoginIdAsInt());
    }
}