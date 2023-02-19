package br.com.alura.store.dao;

import javax.persistence.EntityManager;

import br.com.alura.store.model.Usuario;

public class UsuarioDAO {

	private EntityManager em;

	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}

	public Usuario buscarUsuario(String login, String senha) {
		String jpql = "Select u From Usuario u WHERE ?1 = u.login AND ?2 = u.senha";
		return this.em.createQuery(jpql, Usuario.class).setParameter(1, login).setParameter(2, senha).getSingleResult();
	}

}
