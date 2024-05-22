<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%-- JSP 주석 
1. Servlet(Server + Applet): WAS에서 실행되는, 요청을 처리하고 응답을 보내는 작은 자바 프로그램.
  (1) 서블릿 객체의 생성과 관리, 서블릿 메서드 호출은 WAS가 담당.
  (2) 서블릿 동작 방식:
    o. 최초 요청 -> 서블릿 객체 생성(생성자 호출) -> 메서드(doGet, doPost) 호출 -> 응답
    o. 요청 -> 생성된 서블릿 객체의 메서드 호출 -> 응답
2. JSP(Java/Jakarta Server Page)
  (1) 서블릿은 순수 자바 코드이기 때문에 HTML을 작성하기가 힘듦.
  (2) HTML 형식의 파일에서 자바 코드들이 실행될 수 있도록 만든 "server-side" 문법.
  (3) JSP 동작 원리:
    o. 최초 요청 -> jsp 파일을 java 파일로 변환 -> java 코드를 class로 컴파일
       -> 객체 생성 -> 메서드 호출 -> 응답
    o. 요청 -> 생성된 객체에서 메서드 호출 -> 응답
3. JSP의 구성 요소(문법)
  (1) 주석(comment): jsp 파일이 java 코드로 변환될 때 무시되는 코드.
  (2) 지시문(directive): <%@ ... %>
      JSP 페이지 설정, 컨텐트 타입, 인코딩, 옵션들을 설정. Java import 구문.
  (3) 선언문(declaration): <%! ... %>
      jsp 파일이 java 코드로 변환될 때, 클래스의 필드/메서드 선언 부분.
  (4) 스크립트릿(scriptlet): <% ... %>
      jsp 파일이 java 코드로 변환될 때, _jspService(req, resp) 메서드 안에 포함되는 자바 코드.
      지역 변수 선언 & 초기화, 메서드 호출, 조건문, 반복문, ...
  (5) 식, 표현식(expression): <%= ... %>
      jsp 파일이 java 코드로 변환될 때, out.write() 메서드의 아규먼트로 전달되는 값.
      HTML 코드에 문자열을 삽입.
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
</head>
<body>
    <nav>
        <a href="/lab04">인덱스 페이지</a>
    </nav>
    <main>
        <h1>JSP 소개</h1>
    </main>
</body>
</html>
