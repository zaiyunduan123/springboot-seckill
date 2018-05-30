package com.jesper.seckill.service;

import com.jesper.seckill.bean.Goods;
import com.jesper.seckill.bean.SeckillGoods;
import com.jesper.seckill.mapper.GoodsMapper;
import com.jesper.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiangyunxiong on 2018/5/22.
 */
@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 查询商品列表
     * @return
     */
    public List<GoodsVo> listGoodsVo(){
        return goodsMapper.listGoodsVo();
    }

    /**
     * 根据id查询指定商品
     * @return
     */
    public GoodsVo getGoodsVoByGoodsId(long goodsId){
        return goodsMapper.getGoodsVoByGoodsId(goodsId);
    }

    /**
     * 减少库存，每次减一
     * @return
     */
    public boolean reduceStock(GoodsVo goods){
        SeckillGoods sg = new SeckillGoods();
        sg.setGoodsId(goods.getId());
        int ret = goodsMapper.reduceStockByVersion(sg);
        return ret > 0;
    }

}
