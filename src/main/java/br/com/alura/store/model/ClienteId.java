package br.com.alura.store.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ClienteId implements Serializable{
	
	private String cpf;
	private String usuario;
		
	public ClienteId(String cpf, String usuario) {
		this.cpf = cpf;
		this.usuario = usuario;
	}
	
	public ClienteId() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteId other = (ClienteId) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(usuario, other.usuario);
	}
}
