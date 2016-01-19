package com.appgraph.service.impl;


import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.appgraph.model.Usuario;
import com.appgraph.service.GestaoUsuario;
import com.appgraph.util.HibernateUtil;

public class GestaoUsuarioImpl implements GestaoUsuario {
	
	private Usuario usuario;
	
	public GestaoUsuarioImpl(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	
	public boolean existeUsuario(Usuario usuario) {
		Session session = HibernateUtil.getSession();	
		Long count = (Long) session.createCriteria(Usuario.class)
						  .add(Restrictions.eq("usuario", this.usuario.getUsuario()))
						  .add(Restrictions.eq("senha", this.usuario.getSenha()))
						  .setProjection(Projections.rowCount())
						  .uniqueResult();
		session.close();
		return count > 0;		
	}

	public Usuario ObtemUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
