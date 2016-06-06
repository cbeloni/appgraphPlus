package com.appgraph.service.rest;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

import org.apache.jasper.tagplugins.jstl.core.Remove;

import com.appgraph.dao.impl.GraficoDaoImpl;
import com.appgraph.model.Grafico;
import com.appgraph.model.Graficos;
import com.appgraph.service.GestaoGrafico;
import com.appgraph.service.impl.GestaoGraficoImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;

@Path("/graficos")
public class GeraGrafico {

	@Inject
	private GestaoGrafico gestaoGrafico;
	
	@Path("/{nome}")
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response gerarGrafico(String conteudo, @Context HttpServletRequest ctx) throws IOException {
		if (!new Autenticar().Autenticar(ctx)) {	
			conteudo = "Usuario não existe";
			return Response.status(401).entity(conteudo).build();
		}
		System.out.println("Entrar no Try");
		try {
			Type listType = new TypeToken<ArrayList<Grafico>>(){}.getType();
			List<Grafico> graficos = new Gson().fromJson(conteudo, listType);
			GestaoGraficoImpl gg = new GestaoGraficoImpl();
			gg.removeGraficos(graficos);
			gg.insertGraficos(graficos);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		System.out.println("JSON:" + conteudo);		
		return Response.status(200).entity(conteudo).build();		
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insereGrafico(String conteudo) {
		Grafico grafico = (Grafico) new Gson().fromJson(conteudo, Grafico.class);
				
		
		String output = grafico.toJSON();
		return Response.status(200).build();
		
	}
}
