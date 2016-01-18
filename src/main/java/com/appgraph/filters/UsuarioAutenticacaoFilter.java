package com.appgraph.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appgraph.view.UsuarioAutenticacaoBean;

public class UsuarioAutenticacaoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		UsuarioAutenticacaoBean usuarioAutenticacaoBean = (UsuarioAutenticacaoBean)((HttpServletRequest)request).getSession().getAttribute("usuarioAutenticacaoBean");
		
		if (usuarioAutenticacaoBean == null || !usuarioAutenticacaoBean.isLogado()) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).sendRedirect(contextPath + "/index.xhtml");
		}
		
		chain.doFilter(request, response);
			
	}

	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

	public void destroy() {
		// Nothing to do here!
	}	
	
}
