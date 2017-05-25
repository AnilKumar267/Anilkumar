package com.slokam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoBackServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
		arg0.getRequestDispatcher("WEB-INF/input.jsp").forward(arg0, arg1);
	}
}
