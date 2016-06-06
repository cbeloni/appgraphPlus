package com.appgraph.model;

import java.util.List;

import com.google.gson.Gson;

public class Graficos {
	
	List<Grafico> graficos;
	
	public Graficos(List<Grafico> grafico) {
		this.graficos = grafico;
	}	

	public List<Grafico> getGraficos() {
		return graficos;
	}
	
	public Grafico getPrimeiroGrafico() {
		return this.graficos.get(0);
	}

	public void setGrafico(List<Grafico> grafico) {
		this.graficos = grafico;
	}

	public String toJson(){
		return new Gson().toJson(this);
	}
}
