package com.appgraph.service;

import java.util.List;

import com.appgraph.model.Grafico;

public interface GestaoGrafico {
	
	public List<Grafico> porNome(Grafico grafico);
	public List<String> obtemNomeGraficos();
	public Grafico porCodigo(Integer codigo);
	
}
