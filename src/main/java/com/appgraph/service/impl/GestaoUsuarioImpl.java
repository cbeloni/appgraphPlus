package com.appgraph.service.impl;

import com.appgraph.dao.UsuarioDao;
import com.appgraph.dao.impl.UsuarioDaoImpl;
import com.appgraph.model.Usuario;
import com.appgraph.service.GestaoUsuario;
import com.google.inject.Inject;

public class GestaoUsuarioImpl implements GestaoUsuario {
	
	//@Inject
	UsuarioDao usuarioDao = new UsuarioDaoImpl();	
	
	public boolean existeUsuario(Usuario usuario) {
		boolean existeUsuario = usuarioDao.existeUsuario(usuario);
		return 	existeUsuario;
	}

	public Usuario ObtemUsuario(Usuario usuario) {
		Usuario obtemUsuario = usuarioDao.ObtemUsuario(usuario);
		return obtemUsuario;
	}
	
}
