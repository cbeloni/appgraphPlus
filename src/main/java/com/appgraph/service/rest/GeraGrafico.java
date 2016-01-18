package com.appgraph.service.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.appgraph.model.Grafico;
import com.appgraph.service.GestaoGrafico;
import com.google.inject.Inject;

@Path("rest/")
public class GeraGrafico {

	@Inject
	private GestaoGrafico gestaoGrafico;
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response gerarGrafico(Grafico grafico, @Context HttpServletRequest ctx) {
		gestaoGrafico.porNome(grafico);
		return null;
		
	}
}
