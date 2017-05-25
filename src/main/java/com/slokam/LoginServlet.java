
package com.slokam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	public static List<String> activeUserList = new ArrayList<String>(); 
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
		String q = arg0.getParameter("username");
		String q1 = arg0.getParameter("password");
		
		boolean result = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/f11details","root","user123");
			PreparedStatement pps=con.prepareStatement("select * from logindata where name=? and userpassword=?");
			pps.setString(1, q);
			pps.setString(2, q1);
			
			ResultSet re = pps.executeQuery();
			
			if(re.next()){
				result=true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result){
			if(activeUserList.contains(q)){
				arg0.setAttribute("ff", "user already exists");
				arg0.getRequestDispatcher("Login.jsp").forward(arg0, arg1);
				return;
			}
			else
			{
				activeUserList.add(q);
			}
			Random r =new Random();
			int otp= r.nextInt(500);
			
			System.out.println(otp);
			
			arg0.getSession().setAttribute("chinna", otp);
			arg0.getSession().setAttribute("key", q);
			arg0.getRequestDispatcher("WEB-INF/Otp.jsp").forward(arg0, arg1);
			
		}else{
			arg0.setAttribute("ff", "user r pwds check it plss");
			arg0.getRequestDispatcher("Login.jsp").forward(arg0, arg1);
		}
	}
}
