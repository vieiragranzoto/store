package br.com.alura.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.store.model.Categoria;
import br.com.alura.store.model.Produto;

public class CategoriaDAO {
	
	private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		this.em=em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria = this.em.merge(categoria);
		this.em.remove(categoria);
	}
	
	public Categoria buscarPorNome(String nome) {
		String jpql = "SELECT c FROM Categoria c WHERE c.nome = :nome";
		return this.em.createQuery(jpql, Categoria.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}
}
