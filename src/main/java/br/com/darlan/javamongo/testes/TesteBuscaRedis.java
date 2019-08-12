package br.com.darlan.javamongo.testes;

import br.com.darlan.javamongo.dao.JedisConnection;
import redis.clients.jedis.Jedis;

public class TesteBuscaRedis {

	public static void main(String[] args) {
		
		Jedis jedis = JedisConnection.conectar();
		
		String cliente = jedis.get("cli02");
		
		System.out.println(cliente);
	}
}
