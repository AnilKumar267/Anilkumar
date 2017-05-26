package com.slokam;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class getstddetails extends GenericServlet {
//hiii this is my first comment
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
		String getname = arg0.getParameter("getname");
		
		studentDAO po  = new studentDAO();
		studentpojo std =  po.studentgetdetailes(getname);
		
		arg0.setAttribute("details", std);
		arg0.getRequestDispatcher("WEB-INF/input.jsp").forward(arg0, arg1);
		
	}

}
