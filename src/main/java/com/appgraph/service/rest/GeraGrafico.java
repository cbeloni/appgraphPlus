package com.appgraph.service.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.appgraph.dao.impl.GraficoDaoImpl;
import com.appgraph.model.Grafico;
import com.appgraph.service.GestaoGrafico;
import com.google.inject.Inject;

@Path("graficos/")
public class GeraGrafico {

	@Inject
	private GestaoGrafico gestaoGrafico;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaGrafico(){		
		Grafico grafico = new GraficoDaoImpl().porCodigo(3);
		return grafico.toJSON();		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	public Response gerarGrafico(Grafico grafico, @Context HttpServletRequest ctx) {
		gestaoGrafico.porNome(grafico);
		return null;
		
	}
}
