package com.appgraph.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appgraph.model.Usuario;
import com.appgraph.service.impl.GestaoUsuarioImpl;


@ManagedBean
@SessionScoped
public class UsuarioAutenticacaoBean extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2531917142962194727L;

	private boolean logado;
	
	//@Inject
	//GestaoUsuario gestaoUsuario;
	
//	@Inject
//	public void setGestaoUsuario(GestaoUsuario gestaoUsuario) {
//		this.gestaoUsuario = gestaoUsuario;
//	}
	
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
	
	@SuppressWarnings("unchecked")
	public String autenticar(){	
		GestaoUsuarioImpl gestaoUsuario = new GestaoUsuarioImpl(this.usuario);
		
		if (gestaoUsuario.existeUsuario(usuario) && !isLogado()) {
			setLogado(true);
			this.usuario = gestaoUsuario.ObtemUsuario();
			
			System.out.println("Logado");	
			return navigationBean.IrParaConsultaGrafico();
		} else if (isLogado()) {
			System.out.println("Já estava logado");
			return navigationBean.IrParaConsultaGrafico();
		}		
		else {
			System.out.println("Nao Logado");
			return navigationBean.IrParaIndex();
		}							
		
	}
	
	public void sair(){
		if (isLogado())  {
			setLogado(false);
			System.out.println("Logout com sucesso!");
		}
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