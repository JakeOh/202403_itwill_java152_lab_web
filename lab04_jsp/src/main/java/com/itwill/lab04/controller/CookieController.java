package com.itwill.lab04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CookieController
 */
@WebServlet(name = "cookieController", urlPatterns = { "/cookie" })
public class CookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("CookieController::doGet() 호출");
		
		// 쿠키 객체 생성
		Cookie cookie = new Cookie("hello", "안녕하세요");
		
		// 생성된 쿠키 객체를 응답(response) 객체에 포함
		response.addCookie(cookie);
		
		// 뷰로 요청을 전달.
		request.getRequestDispatcher("/WEB-INF/views/cookie.jsp")
		    .forward(request, response);
	}

}
