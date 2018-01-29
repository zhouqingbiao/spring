package com.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Redis {

	public static JedisPool Pool = null;

	static {
		JedisPoolConfig poolConfig = new JedisPoolConfig();

		poolConfig.setMaxTotal(1024);

		String host = "localhost";

		int port = 6379;

		int timeout = 100000;

		Pool = new JedisPool(poolConfig, host, port, timeout);
	}
}
