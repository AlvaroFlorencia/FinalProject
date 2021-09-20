

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
import com.mysql.jdbc.ResultSet;

@WebServlet("/Feedbackview")
public class Feedbackview extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getPathInfo());
Connection conn = DBUtil.getConnection();
		
		String sql = "Select * FROM feedback";
		System.out.println(sql);
		String usrID = request.getParameter("usrID").toString();
		System.out.println(usrID);
		response.getWriter().println("<html>");
	     response.getWriter().println("<head>");
	     response.getWriter().println("<title>This is a</title>");
	     response.getWriter().println("</head>");
	     response.getWriter().println("<body>");
	     
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
	
		
			
			ResultSet rs1;
			rs1 = (ResultSet) ps.executeQuery(); 
		
				response.getWriter().println("<table>");
			     response.getWriter().println("<tr>");
			     response.getWriter().println("<th>Name</th>");
			     response.getWriter().println("<th>Email</th>");
			     response.getWriter().println("<th>Feedback</th>");
			     response.getWriter().println("</tr>");
			 	while(rs1.next()) {
			    	  response.getWriter().println("<tr>");
			    	     response.getWriter().println("<td>"+ rs1.getString(2)+"</td>");
			    	     response.getWriter().println("<td>"+ rs1.getString(3)+"</td>");
			    	     response.getWriter().println("<td>"+ rs1.getString(5)+"</td>");
			    	     response.getWriter().println("<a href=\"otro.php?state=verde\">Home</a> ");
			    	     response.getWriter().println("</tr>");
			     }
			     response.getWriter().println("</table>");
				
				
			
				
		   
			
			
			
		} catch (SQLException e) {
			response.sendRedirect("http://localhost:8080/FinalProject/login.html");
			e.printStackTrace();
		}
		
		
     
     response.getWriter().println("</body>");
     response.getWriter().println("</head>");
     response.getWriter().println("</html>");
     
		
		
	}
}

