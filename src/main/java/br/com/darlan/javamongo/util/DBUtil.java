package br.com.darlan.javamongo.util;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import br.com.darlan.javamongo.domain.Cliente;
import br.com.darlan.javamongo.domain.Telefone;

public class DBUtil {
	
	public static final DBCollection conectar(String dataBase, String collection) {
		MongoClient client;
		try { 
			client = new MongoClient();
			DB dB = client.getDB(dataBase);
			DBCollection colecao = dB.getCollection(collection);
			
			return colecao;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final DBObject toDBObj(Cliente cliente) {
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
