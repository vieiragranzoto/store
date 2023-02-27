package br.com.alura.store.controller.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.alura.store.dao.ItemPedidoDAO;
import br.com.alura.store.dao.ProdutoDAO;
import br.com.alura.store.model.ItemPedido;
import br.com.alura.store.model.Produto;
import br.com.alura.store.util.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoverProduto implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Long id = Long.valueOf(paramId);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);
		ItemPedidoDAO ipdao = new ItemPedidoDAO(em);

		Produto p = pdao.buscarPorId(id);
		
		ItemPedido ip = ipdao.buscarProdutoEmItemPedido(id);

		em.getTransaction().begin();

		if(ip!=null)
			ipdao.remover(ip);
			
		pdao.remover(p);

		em.getTransaction().commit();
		em.close();

		return "redirect:entrada?acao=ListarProduto";

	}

}
