package br.com.darlan.javamongo.testes;

import br.com.darlan.javamongo.util.DBUtil;

public class TesteDelete {
	
	public static void main(String[] args) {
		
		DBUtil.conectar("DBCliente", "clientes01");
		
		DBUtil.delete("_id", "3");
	}

}
