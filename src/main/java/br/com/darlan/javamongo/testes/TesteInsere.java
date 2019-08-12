package br.com.darlan.javamongo.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.darlan.javamongo.dao.DAO;
import br.com.darlan.javamongo.domain.Cliente;
import br.com.darlan.javamongo.domain.Endereco;
import br.com.darlan.javamongo.domain.Telefone;

public class TesteInsere {

	public static void main(String[] args) {
		
		Endereco endereco = new Endereco("Av. Reneville", "558", "Mairinque", "SP", "18120-000");
		Telefone telefone1 = new Telefone("11972415666");
		Telefone telefone2 = new Telefone("11972415667");
		List<Telefone> lista = new ArrayList<Telefone>();
		lista.add(telefone1);
		lista.add(telefone2);
		
		Cliente cliente = new Cliente("3", "Vanessa", 30, endereco, lista);
		
		DAO.conectar("DBCliente", "clientes01");
		 
		DAO.insere(cliente);
		
		DAO.close();
		
		System.out.println(cliente);
	}
}
