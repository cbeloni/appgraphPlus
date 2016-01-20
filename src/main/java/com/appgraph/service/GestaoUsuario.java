package com.appgraph.service;

import com.appgraph.model.Usuario;

public interface GestaoUsuario {
	
	public boolean existeUsuario (Usuario usuario);
	public Usuario ObtemUsuario (Usuario usuario);
	
}
