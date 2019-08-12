package br.com.darlan.javamongo.testes;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class TesteDelete {
	
	public static void main(String[] args) {
		
		try {
			MongoClient client = new MongoClient();
			DB database = client.getDB("DBCliente");
			DBCollection colecao = database.getCollection("clientes01");
			
			DBObject query = new BasicDBObject("_id", "5");
			DBCursor cursor = colecao.find(query);			
			DBObject obj = cursor.one();
			
			colecao.remove(obj);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
