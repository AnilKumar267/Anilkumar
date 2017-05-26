package com.slokam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResendOtp extends HttpServlet{
//firstcomment
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
		Integer otp1 =  (Integer) arg0.getSession().getAttribute("chinna");
		System.out.println(otp1);
		arg0.getRequestDispatcher("WEB-INF/Otp.jsp").forward(arg0, arg1);
	}
}
	