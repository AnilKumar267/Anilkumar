package com.slokam;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateServlet extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
		String id = arg0.getParameter("id");
		String name = arg0.getParameter("name");
		String age = arg0.getParameter("age");
		String quel = arg0.getParameter("quel");
		String cell = arg0.getParameter("cell");
		
	//	studentDAO ao = new studentDAO();
		
		StudentHibDAO ao = new StudentHibDAO();
		
		studentpojo sp= new studentpojo();
		
		sp.setId(Integer.parseInt(id));
		sp.setName(name);
		sp.setAge(Integer.parseInt(age));
		sp.setQuel(quel);
		sp.setCell(cell);
		
		ao.nameupdate(sp);
		
		arg0.setAttribute("message", "update successfully");
		arg0.getRequestDispatcher("WEB-INF/input.jsp").forward(arg0, arg1);
		
		
		
	}

}
