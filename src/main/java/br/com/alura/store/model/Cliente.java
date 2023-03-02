package br.com.alura.store.model;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ClienteId.class)
@Table(name = "clientes")
public class Cliente {

	@Id
	private String cpf;
	@Id
	private String usuario;

	@Embedded
	private DadosPessoais dadosPessoais;

	public Cliente() {
	}

	public Cliente(String cpf, String usuario, String nome, LocalDate dataNascimento) {
		this.cpf=cpf;
		this.usuario=usuario;
		this.dadosPessoais = new DadosPessoais(nome, dataNascimento);
	}

	public String getNome() {
		return this.dadosPessoais.getNome();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

}
