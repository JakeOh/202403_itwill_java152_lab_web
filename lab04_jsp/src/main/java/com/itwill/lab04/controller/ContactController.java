package com.itwill.lab04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.itwill.lab04.model.Contact;

/**
 * Servlet implementation class ContactController
 */
@WebServlet(name = "contactController", urlPatterns = { "/mvc" })
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("ContactController::doGet() 호출");
		
		// 컨트롤러에 뷰(view, JSP)로 이동(forward):
		request.getRequestDispatcher("/WEB-INF/views/contact.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("ContactController::doPost() 호출");
		
		// 클라이언트가 POST 방식으로 보낸 요청 파라미터 값을 읽음.
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.printf("id=%d, name=%s, phone=%s, email=%s\n", 
		        id, name, phone, email);
		
		// 요청 파라미터 값들을 이용해서 서비스에 필요한 작업.
		Contact c = new Contact(id, name, phone, email);
		System.out.println(c);
		
		// 인덱스 페이지로 리다이렉트(redirect)
		response.sendRedirect("/lab04");
		
		// PRG(Post 요청 - Redirect - Get 요청) 패턴.
	}

}
