package com.appgraph.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appgraph.model.Usuario;
import com.appgraph.service.impl.GestaoUsuarioImpl;
import com.appgraph.util.FacesUtil;


@ManagedBean
@SessionScoped
public class UsuarioAutenticacaoBean extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2531917142962194727L;

	private boolean logado;
	
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	private Usuario usuario = new Usuario();
	//private List<Usuario> usuarios = new ArrayList<Usuario>();		

	public UsuarioAutenticacaoBean() {
		this.usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@SuppressWarnings("unchecked")
	public String autenticar(){	
		GestaoUsuarioImpl gestaoUsuario = new GestaoUsuarioImpl();
		
		if (gestaoUsuario.existeUsuario(this.usuario) && !isLogado()) {
			setLogado(true);
			this.usuario = gestaoUsuario.ObtemUsuario(this.usuario);				
			return navigationBean.IrParaConsultaGrafico();
		} else if (isLogado()) {
			return navigationBean.IrParaConsultaGrafico();
		}		
		else {
			return navigationBean.IrParaIndex();
		}							
		
	}
	
	public String sair(){
		if (isLogado())  {
			setLogado(false);
			FacesUtil.InvalidateSession();			
		}
		return navigationBean.IrParaIndex();
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	}