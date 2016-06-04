package com.appgraph.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.appgraph.dao.impl.GraficoDaoImpl;
import com.appgraph.dao.impl.UsuarioDaoImpl;
import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;
import com.appgraph.model.UsuarioLogado;
import com.appgraph.service.GestaoGrafico;
import com.appgraph.service.impl.GestaoGraficoImpl;
import com.google.gson.Gson;
 
@Path("/auth")
public class Auth {
	
	@GET
	@Path("/")
	public Response GraficoTeste() {
 
		Grafico grafico = new GraficoDaoImpl().porCodigo(3);
		String output =  grafico.toJSON();	
 
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response autenticar(String conteudo) {
		Usuario usuario = (Usuario) new Gson().fromJson(conteudo, Usuario.class);
		usuario = new UsuarioDaoImpl().ObtemUsuario(usuario);
		GestaoGrafico gestaoGrafico = new GestaoGraficoImpl();
		UsuarioLogado usuarioLogado = new UsuarioLogado();
		
		usuarioLogado.setUsuario(usuario);
		usuarioLogado.setNomesGraficos(gestaoGrafico.obtemNomeGraficos(usuario));
		for (String nomeGrafico : usuarioLogado.getNomesGraficos()) {
			usuarioLogado.setTodosGraficos(gestaoGrafico.porNome(usuario, nomeGrafico));
		}
		
		String output = usuarioLogado.toJSON();
		return Response.status(200).entity(output).build();
		
	}
	
	@POST
	@Path("/usuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtem_usuario(String conteudo) {
		Usuario usuario = (Usuario) new Gson().fromJson(conteudo, Usuario.class);
		usuario = new UsuarioDaoImpl().ObtemUsuario(usuario);		
		
		String output = usuario.toJSON();
		return Response.status(200).entity(output).build();
		
	}
}
