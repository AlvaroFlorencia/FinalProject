

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

import com.amdocs.training.config.DBUtil;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String photo = request.getParameter("photo");
	

	  System.out.println(name);
	  System.out.println(eMail);
	  System.out.println(password);
	  System.out.println(phone);
	  System.out.println(address);
	  System.out.println(photo);
	  
		Connection conn = DBUtil.getConnection();
		
		String sql = "INSERT INTO user1 (name, phone_no , email, address, password, upload_photo) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, eMail);
			ps.setString(4, address);
			
			ps.setString(5, password);
			ps.setString(6, photo);
			
			
			
			ps.executeUpdate(); //insert, update,delete
			response.sendRedirect("http://localhost:8080/FinalProject/index.html");
		} catch (SQLException e) {
			response.sendRedirect("http://localhost:8080/FinalProject/index.html");
			e.printStackTrace();
		}
		
		
	}
}

