package com.appgraph.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	public String IrParaGrafico() {
		return "/secured/Grafico.xhtml?faces-redirect=true";
	}
	public String IrParaConsultaGrafico() {
		return "/secured/ConsultaGrafico.xhtml?faces-redirect=true";
	}
	
	public String IrParaIndex() {
		return "/index.xhtml?faces-redirect=true";
	}
	
}