package com.jesper.seckill.mapper;

import com.jesper.seckill.bean.SeckillGoods;
import com.jesper.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/5/22.
 */
@Mapper
public interface GoodsMapper {

    @Select("select g.*, sg.stock_count, sg.start_date, sg.end_date, sg.seckill_price  from sk_goods_seckill sg left join sk_goods g on sg.goods_id = g.id")
    public List<GoodsVo> listGoodsVo();

    @Select("select g.*, sg.stock_count, sg.start_date, sg.end_date, sg.seckill_price  from sk_goods_seckill sg left join sk_goods g  on sg.goods_id = g.id where g.id = #{goodsId}")
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    //goods_stock > 0 防止超卖
    @Update("update sk_goods_seckill set stock_count = stock_count - 1 where goods_id = #{goodsId} and goods_stock > 0")
    public int reduceStock(SeckillGoods seckillGoods);

}
