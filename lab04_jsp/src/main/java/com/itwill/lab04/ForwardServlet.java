package com.itwill.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet(name = "forwardServlet", urlPatterns = { "/ex3" })
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("ForwardServlet::doGet() 호출");
		
		// 요청이 오면 WAS는 web.xml 또는 @WebSevlet 애너테이션에서 설정된 URL mapping에 따라서
		// 요청을 처리할 수 있는 서블릿 클래스 객체의 메서드(doGet, doPost)를 호출.
		// 서블릿에서는 HTML 코드를 작성해서 응답을 보내면 됨.
		// 서블릿에서 HTML을 작성하는 것은 너무 번거로움.
		// 서블릿이 JSP로 요청을 전달하고, JSP가 HTML 코드를 작성하는 것이 더 쉬움.
		
		request.getRequestDispatcher("example.jsp").forward(request, response);
		
		// "forward" 방식의 웹 페이지 이동:
		// - 같은 WAS의 같은 웹 애플리케이션 안에서만 페이지를 이동하는 방식.
		// - 최초 요청 주소가 바뀌지 않음.
		// - request, response 객체가 유지됨.
		// - 다른 WAS 또는 다른 웹 애플리케이션의 페이지로는 포워드(forward)할 수 없음!
	}

}
