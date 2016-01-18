package com.appgraph.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.google.inject.Injector;

public abstract class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 980772897661385934L;
	private Injector injector;
	public BaseBean() {
	}

	public Injector getInjector() {
		if (injector == null) {
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			injector = (Injector) servletContext.getAttribute(Injector.class.getName());
		}
		return injector;
	}

	public void setInjector(Injector injector) {
		this.injector = injector;
	}

	@PostConstruct
	public void init() {
		getInjector().injectMembers(this);
	}
}
