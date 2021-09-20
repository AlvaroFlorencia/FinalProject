

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

import com.amdocs.training.classesf.Person;
import com.amdocs.training.config.DBUtil;

@WebServlet("/addContact")
public class addContact extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
	 	String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		
		int idUser = Person.id;
	

	  System.out.println(name);
	  System.out.println(eMail);
	  System.out.println(message);
	  System.out.println(phone);
	
	  
		Connection conn = DBUtil.getConnection();
		
		String sql = "INSERT INTO contact(user_id, name, Email, Phone_no, Messege) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ps.setInt(1, idUser);
			ps.setString(2, name);
			ps.setString(3, eMail);
			ps.setString(4, phone);
			ps.setString(5, message);
			
			
			
			ps.executeUpdate(); //insert, update,delete
			out.println("Data Stored Suvvessfully!jnenjc");
			
			response.sendRedirect("http://localhost:8080/FinalProject/userPanel.html");
		} catch (SQLException e) {
			out.println("Connection Error!");
			response.sendRedirect("http://localhost:8080/FinalProject/userPanel.html");
			e.printStackTrace();
		}
		
		
	}
}

