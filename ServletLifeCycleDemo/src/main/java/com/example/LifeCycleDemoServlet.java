package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * url mapping /LifeCycleDemoServlet
 * Servlet implementation class LifeCycleDemoServlet
 */
@WebServlet("/LifeCycleDemoServlet")
public class LifeCycleDemoServlet extends HttpServlet {
	
	public int counter;
	
	@Override
	public void init() throws ServletException
	{
		counter=0;
		System.out.println("init() method called :servelet intialiased.counter is set to zero");
		
	}
	
	public void service (HttpServletRequest req,HttpServletResponse response) throws ServletException, IOException
	{
		counter++;
		response.setContentType("text/html");
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Servlet lifesycle demo<h1>");
		out.println("<p>Request count :"+counter+"<p>");
		out.println("</body></html>");
	}
	
	public void destroy()
	{
		System.out.println("destroy method invoked bye bye...");
	}

}
