package org.seckill.dao.cache;

import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Date: 2017-03-20
 * Time: 10:17
 * Description:Redis 缓存
 */
public class RedisDao {
    private final Logger mLogger = LoggerFactory.getLogger(getClass());
    private final JedisPool mJedisPool;
    private final RuntimeSchema<Seckill> mSchema;

    public RedisDao(String ip, int port) {
        mJedisPool = new JedisPool(ip, port);
        mSchema = RuntimeSchema.createFrom(Seckill.class);
    }

    public Seckill getSeckill(long seckillId) {
        //redis操作逻辑
        Jedis jedis = null;
        try {
            jedis = mJedisPool.getResource();
            // redis没有实现内部序列化操作，所以要考虑反序列化性能问题
            //采用自定义序列化()
            byte[] bytes = jedis.get(("seckill:" + seckillId).getBytes());
            if (bytes != null) {
                Seckill seckill = mSchema.newMessage();
                ProtobufIOUtil.mergeFrom(bytes, seckill, mSchema);
                return seckill;
            }
        } catch (Exception e) {
            mLogger.error(e.getMessage(), e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }

    public boolean putSeckill(Seckill seckill) {
        //redis操作逻辑
        Jedis jedis = null;
        try {
            jedis = mJedisPool.getResource();
            String key = "seckill:" + seckill.getSeckillId();
            byte[] byteArray = ProtobufIOUtil.toByteArray(seckill, mSchema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            int timeout = 60 * 60;//缓存一小时
            String result = jedis.setex(key.getBytes(), timeout, byteArray);
            return "OK".equals(result);//返回结果
        } catch (Exception e) {
            mLogger.error(e.getMessage(), e);
        } finally {
            if (null != jedis)
                jedis.close();
        }
        return false;
    }

}
