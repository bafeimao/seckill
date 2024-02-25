package io.binghe.seckill.application.service;

import io.binghe.seckill.domain.dto.SeckillGoodsDTO;
import io.binghe.seckill.domain.model.SeckillGoods;

import java.util.List;

public interface SeckillGoodsService {

    /**
     * 保存商品信息
     */
    int saveSeckillGoods(SeckillGoodsDTO seckillGoodsDTO);

    /**
     * 根据id获取商品详细信息
     */
    SeckillGoods getSeckillGoodsId(Long id);

    /**
     * 根据活动id获取商品列表
     */
    List<SeckillGoods> getSeckillGoodsByActivityId(Long activityId);

    /**
     * 修改商品状态
     */
    int updateStatus(Integer status, Long id);

    /**
     * 扣减库存
     */
    int updateAvailableStock(Integer count, Long id);

    /**
     * 获取当前可用库存
     */
    Integer getAvailableStockById(Long id);
}