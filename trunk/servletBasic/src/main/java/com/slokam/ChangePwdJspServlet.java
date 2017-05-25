package com.slokam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePwdJspServlet extends HttpServlet{
	//THis is new function
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
		String m = arg0.getParameter("old");
		String m1 = arg0.getParameter("new");
		
		//this for checkking out check
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/f11details","root","root");
			PreparedStatement p= con.prepareStatement("update logindata set userpassword = ? where userpassword= ? ");
			p.setString(1, m1);
			p.setString(2, m);
			
			p.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		arg0.setAttribute("message", "u r pwd changing success");
		arg0.getRequestDispatcher("Login.jsp").forward(arg0, arg1);
	
		
	}
}
