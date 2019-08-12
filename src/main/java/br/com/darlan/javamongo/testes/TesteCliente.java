package br.com.darlan.javamongo.testes;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import br.com.darlan.javamongo.domain.Cliente;
import br.com.darlan.javamongo.domain.Endereco;
import br.com.darlan.javamongo.domain.Telefone;
import br.com.darlan.javamongo.util.DBUtil;

public class TesteCliente {

	public static void main(String[] args) {
		
		Endereco endereco = new Endereco("Av. Reneville", "558", "Mairinque", "SP", "18120-000");
		Telefone telefone1 = new Telefone("11972415666");
		Telefone telefone2 = new Telefone("11972415667");
		List<Telefone> lista = new ArrayList<Telefone>();
		lista.add(telefone1);
		lista.add(telefone2);
		
		Cliente cliente = new Cliente("5", "Vanessa", 30, endereco, lista);
		
		DBObject data = DBUtil.toDBObj(cliente);
		
		try {
			MongoClient client = new MongoClient();
			DB dataBase = client.getDB("DBCliente");
			DBCollection colecao = dataBase.getCollection("clientes01");
			
			colecao.insert(data);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println(cliente);
	}
}
