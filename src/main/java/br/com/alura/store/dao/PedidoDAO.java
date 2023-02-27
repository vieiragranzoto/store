package br.com.alura.store.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.store.model.Pedido;
import br.com.alura.store.vo.RelatorioDeVendasVo;

public class PedidoDAO {
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public void atualizar(Pedido pedido) {
		this.em.merge(pedido);
	}

	public void remover(Pedido pedido) {
		pedido = this.em.merge(pedido);
		this.em.remove(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p ";
		return this.em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVendasVo>  relatorioDeVendas() {
		String jpql = "SELECT new br.com.alura.store.vo.RelatorioDeVendasVo("
				+ "produto.nome,"
				+ "SUM(item.quantidade) as quantidade,"
				+ "MAX(pedido.data)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY quantidade DESC";
		return this.em.createQuery(jpql, RelatorioDeVendasVo.class)
				.getResultList();
	}

	public Pedido buscarPedidoComCliente(Long id){
		String jpql = "SELECT * FROM Pedido p JOIN FETCH p.cliente WHERE p.id=:id";
		return this.em.createQuery(jpql, Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
