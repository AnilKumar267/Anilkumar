package com.slokam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		String use = (String) arg0.getSession().getAttribute("key");
		LoginServlet.activeUserList.remove(use);
		
		arg0.getSession().invalidate();
		arg0.getRequestDispatcher("Login.jsp").forward(arg0, arg1);
	}
}
