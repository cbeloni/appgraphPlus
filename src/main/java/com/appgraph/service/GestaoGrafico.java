package com.appgraph.service;

import java.util.List;

import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;

public interface GestaoGrafico {
	
	public List<Grafico> porNome(Grafico grafico);
	public List<String> obtemNomeGraficos();
	public List<String> obtemNomeGraficos(Usuario usuario);
	public Grafico porCodigo(Integer codigo);
	public List<Grafico> porNome(Usuario usuario, String string);
	
}
