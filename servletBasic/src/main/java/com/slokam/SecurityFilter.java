package com.slokam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter{

	private static List<String> preLoginpages = new ArrayList<String>();
	static
	{
		preLoginpages.add("/servletBasic/login.ser");
		preLoginpages.add("/servletBasic/signup.ser");
		preLoginpages.add("/servletBasic/signpage.ser");
		preLoginpages.add("/servletBasic/forgot.ser");
		preLoginpages.add("/servletBasic/forgotjsp.ser");
		preLoginpages.add("/servletBasic/changepwd.ser");
		preLoginpages.add("/servletBasic/changepwdjsp.ser");
	}
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest)arg0;
		//System.out.println(req.getRequestURI());
	
		String user =  (String) req.getSession().getAttribute("key");
		
		String currentReq = req.getRequestURI();
		
		if(preLoginpages.contains(currentReq)){
			System.out.println("prelog");
			arg2.doFilter(arg0, arg1);
			return;
		}
		
	//	arg2.doFilter(arg0, arg1);
		System.out.println(user);
		if(user!=null){
			System.out.println("user true");	
		arg2.doFilter(arg0, arg1);
		
		}
		else{
			System.out.println("user null");
			arg0.getRequestDispatcher("Login.jsp").forward(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
