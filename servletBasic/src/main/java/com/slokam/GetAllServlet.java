package com.slokam;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GetAllServlet extends GenericServlet{
//comment for getallservlet
	//comment
	//commit for the das
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
	
		studentDAO da=new studentDAO();
		
		ArrayList<studentpojo> lis=da.studentgetall();
		
		arg0.setAttribute("book", lis);
		arg0.getRequestDispatcher("WEB-INF/Getall.jsp").forward(arg0, arg1);
	}
}
