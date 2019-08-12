package br.com.darlan.javamongo.util;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import br.com.darlan.javamongo.domain.Cliente;
import br.com.darlan.javamongo.domain.Telefone;

public class DBUtil {
	private static DBCollection colecao;
	
	public static final void conectar(String dataBase, String collection) {
		try { 
			MongoClient client = new MongoClient();
			DB dB = client.getDB(dataBase);
			colecao = dB.getCollection(collection);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(String key, String value) {
		DBObject query = new BasicDBObject(key, value);
		DBCursor cursor = colecao.find(query);			
		DBObject obj = cursor.one();
		colecao.remove(obj);
	}
	
	public static void insere(Cliente cliente) {
		DBObject obj = toDBObj(cliente);
		colecao.insert(obj);
	}
	
	public static DBObject toDBObj(Cliente cliente) {
		List<String> telefones = new ArrayList<String>();
		for (Telefone telefone : cliente.getTelefones()) {
			telefones.add(telefone.getNumero());
		}
		return new BasicDBObject("_id", cliente.getId())
				.append("name", cliente.getNome())
				.append("idade", cliente.getIdade())
				.append("endereco", new BasicDBObject("Logradouro", cliente.getEndereco().getLogradouro())
											.append("numero", cliente.getEndereco().getNumero())
											.append("cidade", cliente.getEndereco().getCidade())
											.append("cep", cliente.getEndereco().getCep()))
				.append("telefone", telefones);
	}

}
