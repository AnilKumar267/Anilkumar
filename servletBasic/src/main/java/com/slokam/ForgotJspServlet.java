package com.slokam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotJspServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
		String k = arg0.getParameter("user");
		
		String strg="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/f11details","root","root");
			PreparedStatement ppq =con.prepareStatement("select userpassword from logindata where name= ? ");
			ppq.setString(1, k);
			ResultSet rs = ppq.executeQuery();
			
			if(rs.next())
			{
				strg = rs.getString("userpassword");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		arg0.setAttribute("pogo", strg);
		arg0.getRequestDispatcher("WEB-INF/Forgot.jsp").forward(arg0, arg1);
	
	}
}
