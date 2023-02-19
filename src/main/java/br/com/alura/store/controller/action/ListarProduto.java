package br.com.alura.store.controller.action;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.store.dao.ProdutoDAO;
import br.com.alura.store.model.Produto;
import br.com.alura.store.util.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarProduto implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);
		List<Produto> lista = pdao.buscarPorTodos();
		
		if (request.getAttribute("lista") == null) {
			request.setAttribute("lista", lista);
		}
		lista.sort((e1,e2)-> e1.getNome().compareTo(e2.getNome()));
		
		return "forward:WEB-INF/view/jsp/lista-produto.jsp";
	}

}
