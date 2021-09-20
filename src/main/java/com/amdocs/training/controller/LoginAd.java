

package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.classesf.Admin;
import com.amdocs.training.classesf.Person;
import com.amdocs.training.config.DBUtil;
import com.mysql.jdbc.ResultSet;

@WebServlet("/LoginAd")
public class LoginAd extends HttpServlet{
	public Admin admin = new Admin();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		
	
		String eMail = request.getParameter("eMail");
		String password = request.getParameter("password");
	

	
	  System.out.println(eMail);
	  System.out.println(password);
	
		Connection conn = DBUtil.getConnection();
		
		String sql = "Select * FROM admin WHERE email = '"+eMail+"' AND password = '"+password+"'";
		System.out.println(sql);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
	
		
			
			ResultSet rs1;
			rs1 = (ResultSet) ps.executeQuery(); //insert, update,delete
			rs1.next();
				System.out.println(password);
				System.out.println("entre");
		   
			System.out.println(rs1.getString(1));
			admin.setEmail(eMail);
			admin.setId(rs1.getInt(1));
			
			response.sendRedirect("http://localhost:8080/FinalProject/userPanelA.html");
			
		} catch (SQLException e) {
			response.sendRedirect("http://localhost:8080/FinalProject/loginA2.html");
			e.printStackTrace();
		}
		
		
	}
}

