package com.appgraph.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.appgraph.service.GestaoGrafico;
import com.appgraph.service.impl.GestaoGraficoImpl;
import com.appgraph.view.NavigationBean;
import com.google.inject.Inject;

@ManagedBean
@SessionScoped
public class ConsultaGraficoBean implements Serializable {

	//@Inject
	GestaoGrafico gg = new GestaoGraficoImpl();
	
	private static final long serialVersionUID = 1L;
	
	private List<String> nomesGraficos = new ArrayList<String>();
	
	private String nomeGraficoSelecionado;
	
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	public String abrirGrafico (){
		System.out.println(nomeGraficoSelecionado);
		return navigationBean.IrParaGrafico();
	}
	public String getNomeGraficoSelecionado() {
		return nomeGraficoSelecionado;
	}

	public void setNomeGraficoSelecionado(String nomeGraficoSelecionado) {
		this.nomeGraficoSelecionado = nomeGraficoSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		this.setNomesGraficos(gg.obtemNomeGraficos());
	}

	public List<String> getNomesGraficos() {
		/*for (String g : nomesGraficos) {
			System.out.println(g);
		}*/
		return nomesGraficos;
	}

	public void setNomesGraficos(List<String> nomesGraficos) {
		this.nomesGraficos = nomesGraficos;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}  
    

}
