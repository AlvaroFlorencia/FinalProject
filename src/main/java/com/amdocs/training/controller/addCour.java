

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

@WebServlet("/addCour")
public class addCour extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String descrip = request.getParameter("descrip");
		String reso = request.getParameter("reso");
		String fee = request.getParameter("fee");
	

	  System.out.println(name);
	  System.out.println(descrip);
	  System.out.println(reso);
	  System.out.println(fee);
	
	  
		Connection conn = DBUtil.getConnection();
		
		String sql = "INSERT INTO course( c_name, c_desp, c_fees, c_resource) values (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ps.setString(1, name);
			ps.setString(2, descrip);
			ps.setString(3, fee);
			ps.setString(4, reso);

			
			
			
			ps.executeUpdate(); //insert, update,delete
			response.sendRedirect("http://localhost:8080/FinalProject/userPanelA.html");
		} catch (SQLException e) {
			response.sendRedirect("http://localhost:8080/FinalProject/userPanelA.html");
			e.printStackTrace();
		}
		
		
	}
}

