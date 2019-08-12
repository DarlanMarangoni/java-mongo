package br.com.darlan.javamongo.testes;

import java.util.Arrays;

import redis.clients.jedis.Jedis;

public class TesteJedis {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis();
		jedis.flushAll();
		
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		
		for (int i = 1; i <= 10; i++) {
			jedis.rpush("intList", String.valueOf(i));
		}

			System.out.println("Lista de Inteiros: " + Arrays.toString(jedis.lrange("intList", 0, -1).toArray()));
		
		jedis.close();
		
		System.out.println("valor de foo: " + value);
	}

}
