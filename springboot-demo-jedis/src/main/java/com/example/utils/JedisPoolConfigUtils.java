package com.example.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

/**
 * @Author LiuYunLong
 * @CREATE_DATE 2023-08-25
 * @DOC 25
 */

public class JedisPoolConfigUtils {

	 private static JedisPool jedisPool;

	 static {
		  // 配置连接池
		  JedisPoolConfig config = new JedisPoolConfig();
		  config.setMaxTotal(5);
		  config.setMaxIdle(3);
		  config.setMinIdle(2);
		  jedisPool = new JedisPool(config, "localhost", 6379);
	 }
	 /**
	  * 获取redis连接
	  */
	 public static Jedis getJedis() {
		  return jedisPool.getResource();
	 }
}
