

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
import com.mysql.jdbc.ResultSet;

@WebServlet("/rmCourseA")
public class rmCourseA extends HttpServlet{
	public boolean flag=false;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String usrID = request.getParameter("usrID").toString();
		System.out.println(usrID);
		
		
Connection conn = DBUtil.getConnection();
		
		String sql = "DELETE FROM course WHERE course_id='"+usrID+"'";
		System.out.println(sql);
	     
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
	
		
			
			 ps.execute(sql);
	        
			 
			 response.sendRedirect("http://localhost:8080/FinalProject/userPanelA.html");
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("http://localhost:8080/FinalProject/userPanelA.html");
		}
		
		
	}
}

