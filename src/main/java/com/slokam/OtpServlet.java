package com.slokam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
		String o = arg0.getParameter("otpuser");
		int otpin = Integer.parseInt(o);
		
		/*String op = arg0.getParameter("otpuser");
		  Integer otpvalue = (Integer) arg0.getSession().getAttribute("chinna");
		  String nextage = "login.jsp";
		if((otpvalue+"").equals(op))
		{
			nextpage="WEB-INF/input.jsp";
		}*/
		
		Integer otpvalue = (Integer) arg0.getSession().getAttribute("chinna");
		System.out.println(otpvalue);
		
		if(otpin==otpvalue){
			System.out.println("otp is true");
			arg0.getRequestDispatcher("WEB-INF/input.jsp").forward(arg0, arg1);
		}
		else
		{
			
			String use = (String) arg0.getSession().getAttribute("key");
			LoginServlet.activeUserList.remove(use);
			
			arg0.getSession().invalidate();
			arg0.getRequestDispatcher("Login.jsp").forward(arg0, arg1);
			
		/*	arg0.setAttribute("key", "u r otp is wrong");
			arg0.getRequestDispatcher("WEB-INF/Otp.jsp").forward(arg0, arg1);*/
		}
		
	}
}
