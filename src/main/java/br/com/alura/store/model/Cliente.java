package br.com.alura.store.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Embedded
	private DadosPessoais dadosPessoais;
	
	public Cliente() {}
	
	public Cliente(String nome, String cpf) {
		this.dadosPessoais= new DadosPessoais(cpf, nome);
	}
	
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
	
	public String getCpf() {
		return this.dadosPessoais.getCpf();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
}
