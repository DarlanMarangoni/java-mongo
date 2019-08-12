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
		
		DBUtil.conectar("DBCliente", "clientes01");
		
		DBUtil.delete("_id", "3");
	}

}
