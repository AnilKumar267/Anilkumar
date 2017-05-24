package com.slokam;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		String id=arg0.getParameter("id");
		int i= Integer.parseInt(id);
		
	//	studentDAO ao= new studentDAO();
		
		StudentHibDAO ao =new StudentHibDAO();
		
		ao.delete(i);
		
		arg0.setAttribute("message", "delete success");
		arg0.getRequestDispatcher("WEB-INF/input.jsp").forward(arg0, arg1);
		
	}

}
