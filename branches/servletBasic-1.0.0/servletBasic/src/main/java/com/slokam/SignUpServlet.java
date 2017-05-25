package com.slokam;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		String z =  arg0.getParameter("usrname");
		String z1 =  arg0.getParameter("pwd");
		String z2 =  arg0.getParameter("age");
		String z3 =  arg0.getParameter("phone");
		String z4 =  arg0.getParameter("location");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/f11details","root","root");
			PreparedStatement ps= con.prepareStatement("insert into logindata(name,userpassword,age,phone,location) values(?,?,?,?,?)");
			ps.setString(1, z);
			ps.setString(2, z1);
			ps.setInt(3, Integer.parseInt(z2));
			ps.setString(4, z3);
			ps.setString(5, z4);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		arg0.setAttribute("msg", "u r registration successfull");
		arg0.getRequestDispatcher("WEB-INF/SignUp.jsp").forward(arg0, arg1);
		
	}
}
