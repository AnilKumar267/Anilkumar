package com.slokam;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GetStudentByIdServlet extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String id = arg0.getParameter("id");
		
		int intid = Integer.parseInt(id);
	//	studentDAO d = new studentDAO();
		
		StudentHibDAO d = new StudentHibDAO();
		
		studentpojo sp=d.getstudentbyid(intid);
		
		arg0.setAttribute("object", sp);
		arg0.getRequestDispatcher("WEB-INF/input.jsp").forward(arg0, arg1);
		
	}

}
