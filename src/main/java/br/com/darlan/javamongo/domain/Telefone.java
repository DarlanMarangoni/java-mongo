package br.com.darlan.javamongo.domain;

import java.io.Serializable;

public class Telefone implements Serializable{

	private String numero;

	public Telefone() {

	}

	public Telefone(String numero) {
		super();
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefone [numero=" + numero + "]";
	}

}
