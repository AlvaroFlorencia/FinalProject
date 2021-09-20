

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

@WebServlet("/feedback")
public class feedback extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		  
		
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
		String feedback = request.getParameter("feedback");
		int idUser = Person.id;
	
	

	  System.out.println(name);
	  System.out.println(eMail);
	  System.out.println(feedback);
	  System.out.println(idUser);
	 
	  
		Connection conn = DBUtil.getConnection();
		
		String sql = "INSERT INTO feedback (user_id, name, email, feedback) values (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ps.setInt(1, idUser);
			ps.setString(2, name);
			;
			ps.setString(3, eMail);
			ps.setString(4, feedback);
		
			
			
			ps.executeUpdate(); //insert, update,delete
			response.sendRedirect("http://localhost:8080/FinalProject/userPanel.html");
		} catch (SQLException e) {
			response.sendRedirect("http://localhost:8080/FinalProject/feedback.html");
			e.printStackTrace();
		}
		
		
	}
}

