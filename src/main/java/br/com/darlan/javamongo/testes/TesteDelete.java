package br.com.darlan.javamongo.testes;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import br.com.darlan.javamongo.util.DBUtil;

public class TesteDelete {
	
	public static void main(String[] args) {
		
		DBCollection colecao = DBUtil.conectar("DBCliente", "clientes01");
		
		DBObject query = new BasicDBObject("_id", "4");
		DBCursor cursor = colecao.find(query);			
		DBObject obj = cursor.one();
		
		colecao.remove(obj);
	}

}
