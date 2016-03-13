package com.appgraph.service;

import java.util.List;

import com.appgraph.model.Usuario;

public interface GestaoUsuario {
	
	public boolean existeUsuario (Usuario usuario);
	public Usuario obtemUsuario (Usuario usuario);
	
}
