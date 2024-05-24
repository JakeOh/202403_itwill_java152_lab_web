package com.itwill.lab04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SessionController
 */
@WebServlet(name = "sessionController", urlPatterns = { "/session" })
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("SessionController::doGet() 호출");
		
		// 서버가 저장하는, 클라이언트(브라우저)마다 매핑되어 있는 세션 객체 찾음:
		HttpSession session = request.getSession();
		System.out.println(session);
		// getSession() 메서드를 호출:
		// (1) 클라이언트가 JSESSIONID 쿠키를 보낸 경우, 세션 아이디를 사용해서 세션 객체를 찾음.
		// (2) 클라이언트가 JSESSIONID 쿠키를 보내지 않은 경우, 새로운 세션 객체를 생성.
		// 응답을 보낼 때 JSESSIONID 쿠키가 클라이언트로 전송됨.
		
		session.setAttribute("nickname", "관리자");
//		session.setMaxInactiveInterval(10); // 세션 만료기간 설정. 단위: 초.
		
		// 뷰 이동
		request.getRequestDispatcher("/WEB-INF/views/session.jsp")
		    .forward(request, response);
	}

}
