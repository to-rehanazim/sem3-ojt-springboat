package com.pwioi.web.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.pwioi.web.models.LoginModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
// Controller - focused on request processing logic
//Controller acts as intermediary btw view and model
// Roles of controller : As a part of request btw view and model
// 1. It Accept Client's data in the form of request 
// 2  it calls model meaning instantiats model model and set properties of model using requst data
// 3. It calls Business logic method on model object 
// 4. Based on result returned by business logic method of model, it(controller) send response in the form of another View
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JakartaServeletWebApplication application;
	private TemplateEngine engine;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//getting client request parameter values
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//validating login data (user credentials)
		
		  // Institiang model or creting object of model 
		
		LoginModel loginBean = new LoginModel();
		//setting the properties of model (java bean)
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		
		//if(username!=null && password!=null&&username.equals("rahul")&&password.equals("mysweethome")) {
		
		//Invoke business logic method of model 
		if(loginBean.validate()) {
		
			//forwarding request from current servlet to next servlet
			//Servlet collaboration using RequestDispatcher
			RequestDispatcher rd= request.getRequestDispatcher("/login-success");
			rd.forward(request, response);
		
		}else {
			PrintWriter out = response.getWriter();
			out.println("<p style='color:red'>Invalid username or password.Please try again...</p>");
			
			//including login form in the response of current servlet
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			
			out.close();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}