package com.alura.cliente;

import org.apache.hc.client5.http.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws Exception {
		
		String contenido = Request
			.post("http://localhost:8080/gerenciador/empresas")
			.addHeader("Accept", "Application/json")
			.execute()
		    .returnContent()
		    .toString();
		
		System.out.println(contenido);
		
	}

}
