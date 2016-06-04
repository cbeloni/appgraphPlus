package com.appgraph.service.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import sun.misc.BASE64Decoder;

import com.appgraph.dao.impl.GraficoDaoImpl;
import com.appgraph.model.Grafico;

@Path("/hello")
public class Hellorest {

	@Context
	private HttpServletRequest request;

	@GET	
	@Path("/")
	public Response helloWorldService() {
		Autenticar auth = new Autenticar();
		String output;

		if (auth.Autenticar(request)) {
			output = "Usuario existe";
		} else {
			output = "Usuario não existe";
			return Response.status(401).entity(output).build();
		}
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/graph")
	public Response graficoTeste() {

		Grafico grafico = new GraficoDaoImpl().porCodigo(3);
		String output = grafico.toJSON();

		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

}
