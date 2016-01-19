package com.appgraph.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appgraph.dao.GraficoDao;
import com.appgraph.dao.UsuarioDao;
import com.appgraph.dao.impl.GraficoDaoImpl;
import com.appgraph.dao.impl.UsuarioDaoImpl;
import com.appgraph.service.GestaoGrafico;
import com.appgraph.service.GestaoUsuario;
import com.appgraph.service.impl.GestaoGraficoImpl;
import com.appgraph.service.impl.GestaoUsuarioImpl;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

public class ServletConfig implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new ServletModule() {
													@Override
												     protected void configureServlets() {
														bind(GraficoDao.class).to(GraficoDaoImpl.class); 
										         		bind(UsuarioDao.class).to(UsuarioDaoImpl.class); 
										         		//bind(GestaoUsuario.class).to(GestaoUsuarioImpl.class).in(Singleton.class); 
										         		//bind(GestaoGrafico.class).to(GestaoGraficoImpl.class).in(Singleton.class);
												     }
		                                         });
		ServletContext servletContext = servletContextEvent.getServletContext();
	    servletContext.setAttribute(Injector.class.getName(), injector);
	}	
	
}
