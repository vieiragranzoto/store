package br.com.alura.store.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.alura.store.model.ItemPedido;

public class ItemPedidoDAO {
	private EntityManager em;

	public ItemPedidoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(ItemPedido item) {
		this.em.persist(item);
	}

	public void atualizar(ItemPedido item) {
		this.em.merge(item);
	}

	public void remover(ItemPedido item) {
		item = this.em.merge(item);
		this.em.remove(item);
	}

	public ItemPedido buscarProdutoEmItemPedido(Long idProduto) {
		String jpql = "SELECT i FROM ItemPedido i WHERE i.produto.id = :idProduto";
		ItemPedido item = null;
		try {
			item = this.em.createQuery(jpql, ItemPedido.class)
			.setParameter("idProduto", idProduto)
			.getSingleResult();
		}catch(NoResultException ex) {
		}
		return item;
	}
}
