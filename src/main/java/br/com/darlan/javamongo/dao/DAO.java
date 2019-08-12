package br.com.darlan.javamongo.dao;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import br.com.darlan.javamongo.domain.Cliente;
import br.com.darlan.javamongo.util.DBUtil;

public class DAO {

	private static DBCollection colecao;
	private static MongoClient client;
	
	public static void conectar(String dataBase, String collection) {
		try { 
			client = new MongoClient();
			DB dB = client.getDB(dataBase);
			colecao = dB.getCollection(collection);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void insere(Cliente cliente) {
		DBObject obj = DBUtil.toDBObj(cliente);
		colecao.insert(obj);
	}
	
	public static DBObject find(String key, String value) {
		DBObject query = new BasicDBObject(key, value);
		DBCursor cursor = colecao.find(query);			
		return cursor.one();
	}
	
	public static void delete(DBObject obj) {
		colecao.remove(obj);
	}
	
	public static void atualiza(DBObject obj, Cliente novoCliente) {
		DBObject novoObj = DBUtil.toDBObj(novoCliente);
		colecao.update(obj, novoObj);
	}
	
	public static void close() {
		client.close();
	}
}
