package com.slokam;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class studentsave extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		String name = arg0.getParameter("name");
		String age = arg0.getParameter("age");
		String quel = arg0.getParameter("quel");
		String cell = arg0.getParameter("cell");
		
		
		String message = "";
		
	//	studentDAO sdao = new studentDAO();
		
		StudentHibDAO sdao =new StudentHibDAO();
		
		int intage = Integer.parseInt(age);
			
		studentpojo pojo = new studentpojo();
		pojo.setName(name);
		pojo.setAge(intage);
		pojo.setQuel(quel);
		pojo.setCell(cell);
		
		sdao.studentsave(pojo);
		message = "your Entered data sucessfully.";
	
		
		arg0.setAttribute("message",message);
		arg0.getRequestDispatcher("WEB-INF/input.jsp").forward(arg0, arg1);
		
	}

}
