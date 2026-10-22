package com.pwioi.web.util;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import jakarta.servlet.ServletContext;


public class ThymeleafTemplateEngineUtil {

	
	public static JakartaServletWebApplication BuildwebApplication(ServletContext context) {
		return JakartaServletWebApplication.buildApplication(context);
	}
	public static TemplateEngine createTemplateEngine(JakartaServletWebApplication application) {
		WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/");
		templateResolver.setSuffix(".html");
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
		
	}
}
