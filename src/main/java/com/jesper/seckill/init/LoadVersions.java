package com.jesper.seckill.init;

import com.jesper.seckill.dto.IdVersion;
import com.jesper.seckill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Order(value=1)
public class LoadVersions implements CommandLineRunner {

    public static ConcurrentHashMap<Long, Integer> idVersionMap = new ConcurrentHashMap<Long, Integer>();

    @Autowired
    private GoodsService goodsService;

    @Override
    public void run(String... strings) throws Exception {

        List<IdVersion> idVersions = goodsService.listIdVersion();
        for (IdVersion iv:
             idVersions) {
            idVersionMap.put(iv.getId(), iv.getVersion());
        }


        //System.out.println(this.idVersionMap);
    }
}

