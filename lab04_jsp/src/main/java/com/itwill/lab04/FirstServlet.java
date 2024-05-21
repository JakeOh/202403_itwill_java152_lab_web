package com.itwill.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        System.out.println("FirstServlet 생성...");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // WAS(Web Application Server): 웹 요청(request)/응답(response)을 처리하는 프로그램. Tomcat.
    // doGet(): get 방식의 요청이 왔을 때 WAS가 호출하는 메서드.
    // doPost(): post 방식의 요청이 왔을 때 WAS가 호출하는 메서드.
    // 파라미터 request: 클라이언트가 서버로 보낸 요청의 정보, 기능들을 갖는 객체.
    // 파라미터 response: 서버가 클라이언트로 보낼 응답의 정보, 기능들을 갖는 객체.
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
        System.out.println("FirstServlet::doGet() 호출");
		
        // WAS가 클라이언트로 보내는 응답(response)의 컨텐트 타입(파일 형식/인코딩)을 설정:
        // 브라우저에서 한글이 깨지지 않도록 하기 위해서.
        response.setContentType("text/html; charset=UTF-8");
        
        response.getWriter()
		    .append("<!doctype html>")
		    .append("<html>")
		    .append("<head>")
		    .append("<meta charset='UTF-8' />")
		    .append("<title>Servlet</title>")
		    .append("</head>")
		    .append("<body>")
		    .append("<h1>첫번째 Servlet</h1>")
		    .append("<a href='/lab04'>인덱스 페이지</a>")
		    .append("</body>")
		    .append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("FirstServlet::doPost() 호출");
        doGet(request, response);
	}

}
