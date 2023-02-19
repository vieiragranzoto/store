package br.com.alura.store.controller.action;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.store.dao.ProdutoDAO;
import br.com.alura.store.model.Produto;
import br.com.alura.store.util.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditarProduto implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);

		Produto produtoEditado = pdao.buscarPorId(Long.valueOf(request.getParameter("id")));
		
		BigDecimal preco = new BigDecimal(request.getParameter("preco"));

		produtoEditado.setNome(request.getParameter("nome"));
		produtoEditado.setDescricao(request.getParameter("descricao"));
		produtoEditado.setPreco(preco);

		em.getTransaction().begin();
		
		pdao.atualizar(produtoEditado);
	
		em.getTransaction().commit();
		em.close();

		return "redirect:entrada?acao=ListarProduto";
	}
}