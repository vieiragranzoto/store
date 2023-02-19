package br.com.alura.store.controller.action;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.com.alura.store.dao.ProdutoDAO;
import br.com.alura.store.model.Produto;
import br.com.alura.store.util.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostrarProduto implements Action {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Long id = Long.valueOf(paramId);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);
		
		Produto produto = pdao.buscarPorId(id);
		request.setAttribute("produto", produto);
		return "forward:WEB-INF/view/jsp/editar-produto.jsp";

	}

}
