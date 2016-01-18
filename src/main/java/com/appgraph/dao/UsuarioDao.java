package com.appgraph.dao;

import com.appgraph.model.Usuario;

public interface UsuarioDao {

	public boolean existeUsuario (Usuario usuario);
	public Usuario ObtemUsuario (Usuario usuario);
}
