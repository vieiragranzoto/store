package br.com.alura.store.controller.action;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.com.alura.store.dao.UsuarioDAO;
import br.com.alura.store.model.Usuario;
import br.com.alura.store.util.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EfetuarLoginUsuario implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO udao = new UsuarioDAO(em);

		Usuario usuario = udao.buscarUsuario(request.getParameter("nome"), request.getParameter("senha"));

		if (usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", usuario);
			return "redirect:entrada?acao=ListarProduto";
		}

		request.setAttribute("incorreto", true);
		return "forward:WEB-INF/view/jsp/efetuar-login.jsp";
	}

}