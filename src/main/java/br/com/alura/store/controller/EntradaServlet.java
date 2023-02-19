package br.com.alura.store.controller;

import java.io.IOException;

import br.com.alura.store.controller.action.Action;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao, redireciona, nomeDaClasse;
		try {
			paramAcao = request.getParameter("acao");

			nomeDaClasse = "br.com.alura.store.controller.action." + paramAcao;
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			Action act = (Action) classe.newInstance();
			redireciona = act.executa(request, response);

			String[] tipo = redireciona.split(":");

			if (tipo[0].equals("forward"))
				request.getRequestDispatcher(tipo[1]).forward(request, response);
			else
				response.sendRedirect(tipo[1]);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NullPointerException e) {
			throw new ServletException(e);
		}

	}
}
