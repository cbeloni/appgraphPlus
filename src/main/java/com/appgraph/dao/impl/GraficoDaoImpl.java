package com.appgraph.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.appgraph.dao.GraficoDao;
import com.appgraph.model.Grafico;
import com.appgraph.model.Usuario;
import com.appgraph.util.FacesUtil;
import com.appgraph.util.HibernateUtil;
import com.appgraph.view.ConsultaGraficoBean;
import com.appgraph.view.UsuarioAutenticacaoBean;

public class GraficoDaoImpl implements GraficoDao {

	public List<Grafico> porNome(Grafico grafico) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		UsuarioAutenticacaoBean usuarioAutenticacaoBean = (UsuarioAutenticacaoBean) FacesUtil
				.getSessionAttribute("usuarioAutenticacaoBean");
		ConsultaGraficoBean consultaGraficoBean = (ConsultaGraficoBean) FacesUtil
				.getSessionAttribute("consultaGraficoBean");
		Usuario usuario = usuarioAutenticacaoBean.getUsuario();
		@SuppressWarnings("unchecked")
		List<Grafico> graficos = (List<Grafico>) session.createCriteria(Grafico.class)
				.add(Restrictions.eq("nome_grafico", consultaGraficoBean.getNomeGraficoSelecionado()))
				.add(Restrictions.eq("uid_usuario", usuario.getUid())).addOrder(Order.asc("id")).list();

		tx.commit();
		session.close();

		return graficos;
	}

	public List<String> obtemNomeGraficos() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		UsuarioAutenticacaoBean usuarioAutenticacaoBean = (UsuarioAutenticacaoBean) FacesUtil
				.getSessionAttribute("usuarioAutenticacaoBean");
		Usuario usuario = usuarioAutenticacaoBean.getUsuario();

		@SuppressWarnings("unchecked")
		List<String> nomeGraficos = (List<String>) session.createCriteria(Grafico.class)
				.add(Restrictions.eq("uid_usuario", usuario.getUid()))
				.setProjection(Projections.projectionList().add(Projections.groupProperty("nome_grafico"))).list();
		tx.commit();
		session.close();

		return nomeGraficos;
	}

	public Grafico porCodigo(Integer codigo) {
		Session session = HibernateUtil.getSession();

		Grafico g = (Grafico) session.get(Grafico.class, codigo);

		session.close();

		return g;
	}
}
