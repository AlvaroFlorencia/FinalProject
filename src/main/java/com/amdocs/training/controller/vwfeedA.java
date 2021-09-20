

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

@WebServlet("/vwfeedA")

public class vwfeedA extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getPathInfo());
Connection conn = DBUtil.getConnection();
		
		String sql = "SELECT * FROM feedback";
		System.out.println(sql);
	
		response.getWriter().println("<html>");
	     response.getWriter().println("<head>");
	     response.getWriter().println("<title>This is a</title>");
	     response.getWriter().println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">");
	     response.getWriter().println("</head>");
	     response.getWriter().println("<body>");
	     
	     response.getWriter().println("<div class=\"collapse\" id=\"navbarToggleExternalContent\">");
	     response.getWriter().println("<div class=\"bg-dark p-4\">");
	     response.getWriter().println("<h5 class=\"text-white h4\">Actions</h5>");
	     response.getWriter().println("<span class=\"text-muted\"><form action=\"AnadeCursoA.html\" method=\"post\">");
response.getWriter().println("<input type=\"submit\" value=\"Add Course\" style=\"background-color:transparent;border:0;color:white\"/> ");
	     response.getWriter().println("</form>");
	     response.getWriter().println(" <form action=\"vwCoursesA\" method=\"post\">");
response.getWriter().println("<input type=\"submit\" value=\"View Courses\" style=\"background-color:transparent;border:0;color:white\"/> ");
	     response.getWriter().println("</form>");
	     response.getWriter().println("<form action=\"vwfeedA\" method=\"post\">");
response.getWriter().println("<input type=\"submit\" value=\"View Feedbacks\" style=\"background-color:transparent;border:0;color:white\"/> ");
	     response.getWriter().println("</form>");
	     response.getWriter().println("<form action=\"vwcontactA\" method=\"post\" >");
response.getWriter().println("<input type=\"submit\" value=\"View Contacts\" style=\"background-color:transparent;border:0;color:white\"/> ");
	     response.getWriter().println("</form>");
	     response.getWriter().println("<form action=\"vwUserA\" method=\"post\" >");
response.getWriter().println("<input type=\"submit\" value=\"View users\" style=\"background-color:transparent;border:0;color:white\"/> ");
	     response.getWriter().println("</form>");
	     response.getWriter().println("<form action=\"exitServletA\" method=\"post\" >");
response.getWriter().println("<input type=\"submit\" value=\"Exit\" style=\"background-color:transparent;border:0;color:white\"/> ");
	     response.getWriter().println("</form>");
	     response.getWriter().println("</span>");
	     response.getWriter().println("</div>");
	     response.getWriter().println("</div>");
	     response.getWriter().println("<nav class=\"navbar navbar-dark bg-dark\">");
	     response.getWriter().println("<div class=\"container-fluid\">");
response.getWriter().println("<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarToggleExternalContent\" aria-controls=\"navbarToggleExternalContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
	     response.getWriter().println("<span class=\"navbar-toggler-icon\"></span>");
	     response.getWriter().println("</button>");
	     response.getWriter().println("</div>");
	     response.getWriter().println("</nav>");
	     
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
	
	
		
			
			ResultSet rs1;
			rs1 = (ResultSet) ps.executeQuery(); 
		
			response.getWriter().println("<table class=\"table\">");
			response.getWriter().println(" <thead>");
			     response.getWriter().println("<tr>");
			     response.getWriter().println("<th scope=\"col\">Name</th>");
			     response.getWriter().println("<th scope=\"col\">Email</th>");
			     response.getWriter().println("<th scope=\"col\">Feedback</th>");
			     response.getWriter().println("<th scope=\"col\"></th>");
			     
			     response.getWriter().println("</tr>");
			     response.getWriter().println("</thead>");
			     response.getWriter().println("<tbody>");
			 	while(rs1.next()) {
			    	  response.getWriter().println("<tr>");
			    	     response.getWriter().println("<td>"+ rs1.getString(2)+"</td>");
			    	     response.getWriter().println("<td>"+ rs1.getString(3)+"</td>");
			    	     response.getWriter().println("<td>"+ rs1.getString(5)+"</td>");
			    	     response.getWriter().println("<td>");
			    	     response.getWriter().print(" <form action=\"rmfeedA?usrID=");
			    	     response.getWriter().print(rs1.getString(4));
			    	     response.getWriter().print("\" method=\"post\" >");
			    	     
			    	     response.getWriter().println(" <input type=\"submit\" value=\"Remove feedback\" />");
			    	     
			    	     response.getWriter().println(" </form>");
			    	     response.getWriter().println("</td>");
			    	     response.getWriter().println("</tr>");
			     }
			 	response.getWriter().println("</tbody>");
			     response.getWriter().println("</table>");
				
				
			
				
		   
			
			
			
		} catch (SQLException e) {
			response.sendRedirect("http://localhost:8080/FinalProject/login.html");
			e.printStackTrace();
		}
		
		
     
		response.getWriter().println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ\" crossorigin=\"anonymous\"></script>");
	     response.getWriter().println("</body>");
	     response.getWriter().println("</head>");
	     response.getWriter().println("</html>");
     
		
		
	}
}

