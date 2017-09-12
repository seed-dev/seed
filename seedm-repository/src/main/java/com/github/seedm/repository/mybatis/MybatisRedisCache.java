package com.github.seedm.repository.mybatis;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Redis实现Mybatis缓存
 *
 * @author Eugene
 */
public class MybatisRedisCache implements Cache {

    private final static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);

    private final String ID;

    private static JedisConnectionFactory jedisConnectionFactory;

    /**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("缓存实例化必须指定ID值......");
        }
        this.ID = id;
    }


    @Override
    public String getId() {
        return this.ID;
    }

    @Override
    public void putObject(Object key, Object value) {
        JedisConnection connection = null;
        try {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>PutObject: " + key + " = " + value);
            connection = (JedisConnection) this.jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer(); //借用SpringDataRedis的JdkSerializationRedisSerializer
            connection.set(serializer.serialize(key), serializer.serialize(value)); //利用其序列化方法将数据写入Redis服务的缓存中
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Object getObject(Object key) {
        Object result = null;
        JedisConnection connection = null;
        try {
            connection = (JedisConnection) this.jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer(); //借用SpringDataRedis的JdkSerializationRedisSerializer
            result = serializer.deserialize(connection.get(serializer.serialize(key))); //利用其反序列化方法获取值
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public Object removeObject(Object key) {
        JedisConnection connection = null;
        Object result = null;
        try {
            connection = (JedisConnection) this.jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = connection.expire(serializer.serialize(key), 0);
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public void clear() {
        JedisConnection connection = null;
        try {
            connection = (JedisConnection) this.jedisConnectionFactory.getConnection(); //连接清除数据
            connection.flushDb();
            connection.flushAll();
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public int getSize() {
        int result = 0;
        JedisConnection connection = null;
        try {
            connection = (JedisConnection) this.jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        } catch (JedisConnectionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
}
