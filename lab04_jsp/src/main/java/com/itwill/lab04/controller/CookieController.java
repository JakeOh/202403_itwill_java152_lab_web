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
		
		int count = 1; // 클라이언트가 서버를 방문한 횟수.
		
		// 클라이언트에서 보낸 쿠키를 WAS에서 확인하는 방법:
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
		    // 쿠키 이름과 쿠키에 저장된 값 출력
		    System.out.println(c.getName() + " = " + c.getValue());
		    if (c.getName().equals("cnt")) {
		        // "cnt" 이름의 쿠키가 있으면, 쿠키에 저장된 값으로 count 변수를 변경.
		        count = Integer.parseInt(c.getValue());
		    }
		}
		
		// count 변수의 값을 request 객체의 속성(attribute)으로 추가 --> JSP(뷰)로 전달할 수 있음.
		request.setAttribute("visitCount", count);
		
		count++; // 방문 횟수를 증가
		// 방문 횟수를 저장한 쿠키를 response 객체에 포함.
		Cookie visitCookie = new Cookie("cnt", String.valueOf(count));
		visitCookie.setMaxAge(24 * 60 * 60); // 쿠키 만료 기간 설정. 단위: 초(second).
		// 쿠키의 만료기간(maxAge)를 설정하지 않으면, 브라우저가 닫힐 때 쿠키는 만료됨. 
		response.addCookie(visitCookie);
		
		// 뷰로 요청을 전달.
		request.getRequestDispatcher("/WEB-INF/views/cookie.jsp")
		    .forward(request, response);
	}

}
