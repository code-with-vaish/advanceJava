package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInputServlet
 * 
 * /UserInputServlet
 */
@WebServlet("/UserInputServlet")
public class UserInputServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>User input received</h1>");
		out.println("<p>"+name+"</p>");
		out.println("<p>"+age+"</p>");
		out.println("</body></html>");
	}

}
