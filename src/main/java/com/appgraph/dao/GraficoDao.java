package com.appgraph.dao;

import java.util.List;

import com.appgraph.model.Grafico;

public interface GraficoDao {
	
	public List<Grafico> porNome(Grafico grafico);
	public List<String> obtemNomeGraficos();
	public Grafico porCodigo(Integer codigo);
}
