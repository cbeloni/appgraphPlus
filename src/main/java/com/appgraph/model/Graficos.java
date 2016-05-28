package com.appgraph.model;

import java.util.List;

import com.google.gson.Gson;

public class Graficos {
	
	List<Grafico> graficos;
	
	public Graficos(List<Grafico> grafico) {
		this.graficos = grafico;
	}	

	public List<Grafico> getGrafico() {
		return graficos;
	}

	public void setGrafico(List<Grafico> grafico) {
		this.graficos = grafico;
	}

	public String toJson(){
		return new Gson().toJson(this);
	}
}
