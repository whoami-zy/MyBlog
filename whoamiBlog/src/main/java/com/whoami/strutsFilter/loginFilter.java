package com.whoami.strutsFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		HttpSession session=request.getSession();
		String SessionName=(String)session.getAttribute("SessionName");
		if(SessionName == null){
			response.sendRedirect(request.getContextPath()+"/loginFilter.jsp");
		}else{
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
		
	}


	
	
}
