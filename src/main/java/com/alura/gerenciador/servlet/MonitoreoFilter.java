package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MonitoreoFilter extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) 
			throws IOException, ServletException {
		
		System.out.println("AutorizacionFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paramAccion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		
		Boolean esUnUsuarioNoLogado = (sesion.getAttribute("loginUsuario")==null);
		Boolean esUnaAccionProtegida = !(paramAccion.equals("Login") || paramAccion.equals("LoginForm"));
		
		if(esUnUsuarioNoLogado && esUnaAccionProtegida) {
			response.sendRedirect("entrada?accion=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
