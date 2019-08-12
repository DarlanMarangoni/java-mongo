package br.com.darlan.javamongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cliente implements Serializable{

	private String id;
	private String nome;
	private Integer idade;
	
	private Endereco endereco;

	private List<Telefone> telefones = new ArrayList();

	public Cliente() {

	}

	public Cliente(String id, String nome, Integer idade, Endereco endereco, List<Telefone> lista) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		for (Telefone telefone : lista) {
			telefones.add(telefone);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", idade=" + idade + ", endereco=" + endereco + ", telefones="
				+ telefones + "]";
	}

}
