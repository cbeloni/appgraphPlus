package com.appgraph.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.gson.Gson;

public class UsuarioLogado implements Serializable{
	
	Usuario usuario;
	List<String> nomesGraficos;	
	List<Grafico> todosGraficos;
	List<Grafico> grafico;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<String> getNomesGraficos() {
		return nomesGraficos;
	}

	public void setNomesGraficos(List<String> nomesGraficos) {
		this.nomesGraficos = nomesGraficos;
	}

	public List<Grafico> getTodosGraficos() {
		return todosGraficos;
	}

	public void setTodosGraficos(List<Grafico> todosGraficos) {
		this.todosGraficos = todosGraficos;
	}		
	
	public List<Grafico> getGraficos() {
		return grafico;
	}

	public void setGraficos(List<Grafico> grafico) {
		this.grafico = grafico;
	}

	public String toJSON(){
		return new Gson().toJson(this);
	}
		
}
