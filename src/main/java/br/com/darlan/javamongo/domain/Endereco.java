package br.com.darlan.javamongo.domain;

import java.io.Serializable;

public class Endereco implements Serializable{

	private String logradouro;
	private String numero;
	private String cidade;
	private String uf;
	private String cep;

	public Endereco() {

	}

	public Endereco(String logradouro, String numero, String cidade, String uf, String cep) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", cidade=" + cidade + ", uf=" + uf
				+ ", cep=" + cep + "]";
	}
	
}
