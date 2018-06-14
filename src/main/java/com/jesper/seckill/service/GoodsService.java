package com.jesper.seckill.service;

import com.jesper.seckill.bean.Goods;
import com.jesper.seckill.bean.SeckillGoods;
import com.jesper.seckill.dto.IdVersion;
import com.jesper.seckill.init.LoadVersions;
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

    //乐观锁冲突最大重试次数
    private static final int DEFAULT_MAX_RETRIES = 5;

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 查询商品列表
     *
     * @return
     */
    public List<GoodsVo> listGoodsVo() {
        return goodsMapper.listGoodsVo();
    }

    /**
     * 查询秒杀商品id和version
     *
     * @return
     */
    public List<IdVersion> listIdVersion() {
        return goodsMapper.listIdVersion();
    }




    /**
     * 根据id查询指定商品
     *
     * @return
     */
    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsMapper.getGoodsVoByGoodsId(goodsId);
    }

    /**
     * 减少库存，每次减一
     *
     * @return
     */
    public boolean reduceStock(GoodsVo goods) { //TODO
        int numAttempts = 0;
        // 这里 创建的SeckillGoods 的默认 version = 0,  每次秒杀 乐观锁的版本都是0, 也就是说，不管该商品的存货有多少，都只能被秒杀一次
        // 这里可以加一个全局的ConcurrentHash 里面存所有的 商品的被

        // 先从全局的  idversion 关联数组中 获取version字段

        Integer version = LoadVersions.idVersionMap.get(goods.getId());
//        System.out.println("version: " + version);
  //      System.out.println(LoadVersions.idVersionMap.get(goods.getId()));


        SeckillGoods sg = new SeckillGoods();
        int ret = 0;
        sg.setGoodsId(goods.getId());
        sg.setVersion(version);
        do {
            numAttempts++;
            try {
                ret = goodsMapper.reduceStockByVersion(sg);
                //System.out.println("ret:" + ret);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ret != 0)
                break;
        } while (numAttempts < DEFAULT_MAX_RETRIES);

        if (ret > 0) {
            LoadVersions.idVersionMap.put(goods.getId(), version + 1);
            //System.out.println(LoadVersions.idVersionMap.get(goods.getId()));
        }

        return ret > 0;
    }

}

