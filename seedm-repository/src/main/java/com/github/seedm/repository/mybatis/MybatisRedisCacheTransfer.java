package com.github.seedm.repository.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Mybatis静态注入Redis缓存
 */
public class MybatisRedisCacheTransfer {

    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
