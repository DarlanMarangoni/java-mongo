package br.com.darlan.javamongo.testes;

import com.mongodb.DBObject;

import br.com.darlan.javamongo.dao.DAO;
import br.com.darlan.javamongo.dao.JedisConnection;
import redis.clients.jedis.Jedis;

public class TesteSalvarRedis {

	public static void main(String[] args) {
		
		DAO.conectar("DBCliente", "clientes01");
		DBObject obj = DAO.find("_id", "3");
		DAO.close();
		
		Jedis jedis = JedisConnection.conectar();
		
		jedis.set("cli02", obj.toString());

	}
}
