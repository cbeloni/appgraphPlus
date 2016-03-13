package com.appgraph.dao;

import java.util.List;

import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;

public interface GraficoDao {
	
	public List<Grafico> porNome(Grafico grafico);
	public List<Grafico> porNome(Usuario usuario, String nomeGrafico);
	public List<String> obtemNomeGraficos();
	public List<String> obtemNomeGraficos(Usuario usuario);
	public Grafico porCodigo(Integer codigo);
}
