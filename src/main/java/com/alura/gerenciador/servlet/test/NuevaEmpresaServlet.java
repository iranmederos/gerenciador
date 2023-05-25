package com.alura.gerenciador.servlet.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nueva empresa registrada");
		String nuevaEmpresa= request.getParameter("nombre");
		String paramFechaEmpresa = request.getParameter("fecha");

        Date fechaAbertura = null;
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaAbertura = sdf.parse(paramFechaEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
        
		Empresa empresa= new Empresa();
		DB db= new DB();
		empresa.setNombre(nuevaEmpresa);
		empresa.setFechaAbertura(fechaAbertura);
		db.agregarEmpresa(empresa);
		
		response.sendRedirect("listaEmpresas");
        /*RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
        request.setAttribute("empresa", empresa.getNombre());
        rd.forward(request, response);*/
		
	}

}
