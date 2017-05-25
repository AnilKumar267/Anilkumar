package com.slokam;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SignPageServlet extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		//arg0.setAttribute("enter", "u r register data success");
		arg0.getRequestDispatcher("WEB-INF/SignUp.jsp").forward(arg0, arg1);
	}
}
