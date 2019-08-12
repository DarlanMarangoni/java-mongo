package br.com.darlan.javamongo.testes;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBObject;

import br.com.darlan.javamongo.dao.DAO;
import br.com.darlan.javamongo.domain.Cliente;
import br.com.darlan.javamongo.domain.Endereco;
import br.com.darlan.javamongo.domain.Telefone;

public class TesteAtualizar {

	public static void main(String[] args) {
		
		Endereco endereco = new Endereco("Av. Reneville2", "600", "Mairinque", "SP", "18120-000");
		Telefone telefone1 = new Telefone("11972415666");
		Telefone telefone2 = new Telefone("11972415667");
		List<Telefone> lista = new ArrayList<Telefone>();
		lista.add(telefone1);
		lista.add(telefone2);
		
		Cliente novoCliente = new Cliente("3", "Leonardo", 30, endereco, lista);
		
		DAO.conectar("DBCliente", "clientes01");
		
		DBObject obj = DAO.find("_id", "3");
		
		DAO.atualiza(obj, novoCliente);
		
		DAO.close();
		
	}
}
