package br.com.alura.store.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//@WebFilter("/*")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession sessao = request.getSession();

		String acao = "vazio";
		if (request.getParameter("acao") != null)
			acao = request.getParameter("acao");

		if (sessao.getAttribute("usuario") != null && acao.equals("vazio")) {
			response.sendRedirect("entrada?acao=ListaEmpresas");
			return;
		}

		if (sessao.getAttribute("usuario") == null
				&& !(acao.equals("EfetuarLoginUsuario") || acao.equals("EfetuarLoginUsuarioForm"))) {
			response.sendRedirect("entrada?acao=EfetuarLoginUsuarioForm");
			return;
		}

		chain.doFilter(request, response);

	}

}
