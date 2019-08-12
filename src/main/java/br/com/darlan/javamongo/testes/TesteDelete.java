package br.com.darlan.javamongo.testes;

import com.mongodb.DBObject;

import br.com.darlan.javamongo.dao.DAO;

public class TesteDelete {
	
	public static void main(String[] args) {
		
		DAO.conectar("DBCliente", "clientes01");
		
		DBObject obj = DAO.find("_id", "3");
		
		DAO.delete(obj);
		
		DAO.close();
	}

}
