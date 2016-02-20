package com.appgraph.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.appgraph.model.Usuario;
import com.appgraph.service.impl.GestaoUsuarioImpl;

public class TesteNavegacaoUsuario {
		
	@Test
	public void autenticarUsuario(){
		Usuario usuario = new Usuario();
		usuario.setUsuario("isis");
		usuario.setSenha("123");
		GestaoUsuarioImpl gestaoUsuario = new GestaoUsuarioImpl();
		
		assertEquals(gestaoUsuario.existeUsuario(usuario),true);
	}
	
	@Test
	public void listarGraficos(){
		Usuario usuario = new Usuario();
		usuario.setUsuario("isis");
		usuario.setSenha("123");
		GestaoUsuarioImpl gestaoUsuario = new GestaoUsuarioImpl();
		
		assertEquals(gestaoUsuario.existeUsuario(usuario),true);
	}
	
}
