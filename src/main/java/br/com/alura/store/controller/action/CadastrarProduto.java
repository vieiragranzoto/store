package br.com.alura.store.controller.action;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.store.dao.CategoriaDAO;
import br.com.alura.store.dao.ProdutoDAO;
import br.com.alura.store.model.Categoria;
import br.com.alura.store.model.Produto;
import br.com.alura.store.util.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastrarProduto implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Categoria categoria = new Categoria(request.getParameter("categoria"));

		BigDecimal preco = new BigDecimal(request.getParameter("preco"));

		Produto produto = new Produto(request.getParameter("nome"), request.getParameter("descricao"), preco,
				categoria);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(categoria);
		produtoDao.cadastrar(produto);
		
		em.getTransaction().commit();
		em.close();

		return "redirect:entrada?acao=ListarProduto";
	}

}
