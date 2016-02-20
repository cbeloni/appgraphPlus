package com.appgraph.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.appgraph.dao.UsuarioDao;
import com.appgraph.model.Usuario;
import com.appgraph.util.HibernateUtil;

public class UsuarioDaoImpl implements UsuarioDao{

	public boolean existeUsuario (Usuario usuario) {
		
		Session session = HibernateUtil.getSession();	
		Long count = (Long) session.createCriteria(Usuario.class)
						  .add(Restrictions.eq("usuario", usuario.getUsuario()))
						  .add(Restrictions.eq("senha", usuario.getSenha()))
						  .setProjection(Projections.rowCount())
						  .uniqueResult();
		session.close();
		return count > 0;
	}
	
	public Usuario ObtemUsuario (Usuario usuario) {
		Session session = HibernateUtil.getSession();	
		Usuario usuarioRequisitado = (Usuario) session.createCriteria(Usuario.class)
						  .add(Restrictions.eq("usuario", usuario.getUsuario()))
						  .add(Restrictions.eq("senha", usuario.getSenha()))
						  .uniqueResult();	
		
		session.close();
		return usuarioRequisitado;
	}
}
