package com.appgraph.service.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.appgraph.dao.impl.GraficoDaoImpl;
import com.appgraph.model.Grafico;
import com.appgraph.service.GestaoGrafico;
import com.google.gson.Gson;
import com.google.inject.Inject;

@Path("/graficos")
public class GeraGrafico {

	@Inject
	private GestaoGrafico gestaoGrafico;
	
	@Path("/id/{nome}")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaGrafico(@PathParam("nome") String nome){
		List<Grafico> graficos = new GraficoDaoImpl().porNome(nome);
		
		return new Gson().toJson(graficos);
	}
	
	@Path("/id")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaGrafico(){		
		Grafico grafico = new GraficoDaoImpl().porCodigo(1);
		return grafico.toJSON();		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	public Response gerarGrafico(Grafico grafico, @Context HttpServletRequest ctx) {
		gestaoGrafico.porNome(grafico);
		return null;
		
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insereGrafico(String conteudo) {
		Grafico grafico = (Grafico) new Gson().fromJson(conteudo, Grafico.class);
				
		
		String output = grafico.toJSON();
		return Response.status(200).entity(output).build();
		
	}
}
