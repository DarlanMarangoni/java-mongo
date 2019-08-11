package br.com.darlan.javamongo.testes;

import java.util.List;
import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Teste01 {
	
	public static void main(String[] args) {
		
		try {
			MongoClient client = new MongoClient();
			DB dataBase = client.getDB("DBCliente");
			DBCollection colecao = dataBase.getCollection("clientes");
			
			List <Integer> livros = Arrays.asList(123,1234);		
			DBObject cliente = new BasicDBObject("_id","1")
								.append("name", "darlan")
								.append("endereco", new BasicDBObject("Logradouro", "Av. Reneville")
															.append("numero", "558")
															.append("cidade", "mairinque"))
								.append("livros", livros);
			colecao.insert(cliente);
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
