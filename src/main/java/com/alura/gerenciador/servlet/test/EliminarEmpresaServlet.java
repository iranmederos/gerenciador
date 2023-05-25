package com.alura.gerenciador.servlet.test;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.alura.gerenciador.modelo.DB;

public class EliminarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		DB db = new DB();
		db.eliminarEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
	}

}
