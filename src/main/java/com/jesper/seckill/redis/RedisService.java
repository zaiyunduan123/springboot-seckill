package com.jesper.seckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis服务
 */
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 从redis连接池获取redis实例
     */
    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            T t = stringToBean(str, clazz);
        }

    }
    /**
     * 将json字符串转对象
     */
//    public


}
