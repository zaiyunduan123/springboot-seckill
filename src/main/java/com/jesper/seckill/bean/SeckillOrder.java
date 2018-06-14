package com.jesper.seckill.bean;

/**
 * Created by jiangyunxiong on 2018/5/22.
 */
public class SeckillOrder {
    private Long  id;
    private Long userId;
    private Long goodsId;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getOrderId() {
        return id;
    }
    public void setOrderId(Long id) {
        this.id = id;
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
