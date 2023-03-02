package br.com.alura.store.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
	
	private String nome;
	@Column(name="data_nascimento")
	private LocalDate dataNascimento;
		
	public DadosPessoais(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento=dataNascimento;
	}
	
	public DadosPessoais() {
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
}
