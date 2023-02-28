package br.com.alura.store.model;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
	
	private String cpf;
	private String nome;
		
	public DadosPessoais(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public DadosPessoais() {
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
}
