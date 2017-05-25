package com.slokam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void nameupdate(studentpojo sp) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfrds","root","user123");
			ps = con.prepareStatement("UPDATE frds set name=?,age=?,qulification=?,cell=? where id=?");
			ps.setString(1, sp.getName());
			ps.setInt(2, sp.getAge());
			ps.setString(3, sp.getQuel());
			ps.setString(4, sp.getCell());
			ps.setInt(5, sp.getId());
			ps.executeUpdate();
			
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public studentpojo getstudentbyid(int id){
	
		studentpojo std=new studentpojo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfrds","root","user123");
			ps = con.prepareStatement("SELECT * FROM frds where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int sid = rs.getInt("id");
				String sname = rs.getString("name");
				int age = rs.getInt("age");
				String qulification = rs.getString("qulification");
				String cell = rs.getString("cell");
				
				std.setId(sid);
				std.setName(sname);
				std.setAge(age);
				std.setQuel(qulification);
				std.setCell(cell);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std;
	 }
	public void delete(int id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfrds","root","user123");
			ps =con.prepareStatement("DELETE FROM frds where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public ArrayList<studentpojo> studentgetall(){
		ArrayList<studentpojo> std1 =new ArrayList<studentpojo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfrds","root","user123");
			ps = con.prepareStatement("SELECT * FROM frds");
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age = rs.getInt("age");
				String qual=rs.getString("qulification");
				String cell=rs.getString("cell");
				
				studentpojo poj=new studentpojo();
				
				poj.setId(id);
				poj.setName(name);
				poj.setAge(age);
				poj.setQuel(qual);
				poj.setCell(cell);
				
				std1.add(poj);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std1;
	}
	public studentpojo studentgetdetailes(String name){
		
		studentpojo std = new studentpojo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfrds","root","user123");
			ps = con.prepareStatement("SELECT * FROM frds where name=?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				int age = rs.getInt("age");
				String qulification = rs.getString("qulification");
				String cell = rs.getString("cell");
				
				std.setId(id);
				std.setName(sname);
				std.setAge(age);
				std.setQuel(qulification);
				std.setCell(cell);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std;
	}
	
	public void studentsave(studentpojo student){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myfrds","root","user123");
			ps = con.prepareStatement("insert into frds (name,age,qulification,cell) values(?,?,?,?)");
			ps.setString(1,student.getName());
			ps.setInt(2,student.getAge());
			ps.setString(3,student.getQuel());
			ps.setString(4,student.getCell());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
