package br.com.alura.store.controller.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EfetuarLogoutUsuario implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		
		return "redirect:entrada?acao=EfetuarLoginUsuarioForm";
	}

}