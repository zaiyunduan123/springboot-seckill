package com.jesper.seckill.redis;

/**
 * Created by jiangyunxiong on 2018/5/29.
 */
public class OrderKey extends BasePrefix {

    public OrderKey(String prefix) {
        super(prefix);
    }
    public static OrderKey getSeckillOrderByUidGid = new OrderKey("seckill");
}
