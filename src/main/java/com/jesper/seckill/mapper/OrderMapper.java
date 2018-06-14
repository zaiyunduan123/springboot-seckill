package com.jesper.seckill.mapper;

import com.jesper.seckill.bean.OrderInfo;
import com.jesper.seckill.bean.SeckillOrder;
import org.apache.ibatis.annotations.*;

/**
 * Created by jiangyunxiong on 2018/5/23.
 */
@Mapper
public interface OrderMapper {


    @Select("select * from sk_order where user_id = #{userId} and goods_id = #{goodsId}")
    public SeckillOrder getOrderByUserIdGoodsId(@Param("userId") long userId, @Param("goodsId") long goodsId);


    /**
     * 通过@SelectKey使insert成功后返回主键id，也就是订单id
     * @param orderInfo
     * @return
     */
    @Insert("insert into sk_order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date, order_id)values("
            + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate}, #{orderId} )")
    public long insert(OrderInfo orderInfo);


    @Insert("insert into sk_order (user_id, goods_id)values(#{userId}, #{goodsId})")
    //@SelectKey( keyProperty = "id", resultType = long.class, before = false, statement = "select last_insert_id()") // TODO
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")/*增加这个注解插入记录后会返回自增长的id*/
    public void insertSeckillOrder(SeckillOrder order);

    // repair //TODO
    @Select("select user_id, goods_id, delivery_addr_id, goods_name, goods_count, goods_price, order_channel, status, create_date, pay_date from sk_order_info where order_id = #{orderId}")
    public OrderInfo getOrderById(@Param("orderId")long orderId);

}

