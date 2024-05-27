package com.itwill.lab05.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet(name = "frontController", urlPatterns = { "" })
// context root(http://localhost:8080/lab05)로 들어오는 요청을 처리하는 서블릿.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(FrontController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("FrontController#doGet");
		log.trace("doGet");
		
		request.getRequestDispatcher("/WEB-INF/views/home.jsp")
		    .forward(request, response);
	}

}
