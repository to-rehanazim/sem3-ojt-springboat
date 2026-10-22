package com.pwioi.web.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import com.pwioi.web.util.ThymeleafTemplateEngineUtil;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/shop-cart")
public class ShoppingCartServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
	private JakartaServletWebApplication application;
	private TemplateEngine engine;

	private IWebExchange webExchange;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		application = ThymeleafTemplateEngineUtil.buildWebApplication(getServletContext());
		engine = ThymeleafTemplateEngineUtil.createTemplateEngine(application);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IServletWebExchange WebExchange = application.buildExchange(request, response);
		WebContext webContext = new WebContext(webExchange);
		
		List<String> cartItems = Arrays.asList("Mobile", "Laptop", "Ear Phone");
		
		//storing list of cart item into thymeleaf web context
		webContext.setVariable("Item", cartItems);
		
		//process template using thymeleaf engine 
		engine.process("cart", webContext, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}