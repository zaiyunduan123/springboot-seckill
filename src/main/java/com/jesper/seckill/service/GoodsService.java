package com.jesper.seckill.service;

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

    public List<GoodsVo> listGoodsVo(){
        return goodsMapper.listGoodsVo();
    }

    public GoodsVo getGoodsVoByGoodsId(long goodsId){
        return goodsMapper.getGoodsVoByGoodsId(goodsId);
    }
}
