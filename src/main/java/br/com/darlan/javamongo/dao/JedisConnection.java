package br.com.darlan.javamongo.dao;

import redis.clients.jedis.Jedis;

public class JedisConnection {
	
	public static Jedis conectar() {
		return new Jedis();
	}
}
