package br.com.alura.store.dao;

import javax.persistence.EntityManager;

import br.com.alura.store.model.Cliente;

public class ClienteDAO {
	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}

	public void remover(Cliente cliente) {
		cliente = this.em.merge(cliente);
		this.em.remove(cliente);
	}
}
