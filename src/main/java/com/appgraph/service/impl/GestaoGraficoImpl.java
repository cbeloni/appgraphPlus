package com.appgraph.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.appgraph.dao.GraficoDao;
import com.appgraph.dao.impl.GraficoDaoImpl;
import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;
import com.appgraph.service.GestaoGrafico;
import com.appgraph.util.FacesUtil;
import com.appgraph.util.HibernateUtil;
import com.appgraph.view.ConsultaGraficoBean;
import com.appgraph.view.UsuarioAutenticacaoBean;
import com.google.inject.Inject;

public class GestaoGraficoImpl implements GestaoGrafico {

	//@Inject
	GraficoDao graficoDao = new GraficoDaoImpl();
	
	public List<String> obtemNomeGraficos() {
		List<String> listaGraficos = graficoDao.obtemNomeGraficos();
		return listaGraficos;
	}

	public Grafico porCodigo(Integer codigo) {
		Grafico grafico = graficoDao.porCodigo(codigo);
		return grafico;
	}

	public List<Grafico> porNome(Grafico grafico) {
		List<Grafico> listaGrafico = graficoDao.porNome(grafico);
		return listaGrafico;
	}

}
