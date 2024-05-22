<%@ page import="com.itwill.lab04.model.Contact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>scriptlet</title>
</head>
<body>
    <%@ include file="header.jspf" %>
    
    <main>
        <h1>JSP scriptlet 활용</h1>
        <%-- 
        scriptlet: JSP 안에서 자바 코드들(_jspService 메서드 안에서 실행되는 코드들)을 작성하기 위한 태그.
        지역 변수 선언 & 초기화, 객체 생성, 메서드 호출, 조건문, 반복문, ...
        --%>
        
        <% 
        // HTML 테이블을 작성할 때 필요한 더미 데이터 생성:
        ArrayList<Contact> data = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Contact c = new Contact(i, "이름-" + i, "전화번호-" + i, "이메일-" + i);
            data.add(c);
        }
        %>
        
        <h2>scriptlet을 사용한 테이블 작성</h2>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
            <% 
            for (Contact c : data) {
                out.print("<tr>");
                out.print("<td>" + c.getId() + "</td>");
                out.print("<td>" + c.getName() + "</td>");
                out.print("<td>" + c.getPhone() + "</td>");
                out.print("<td>" + c.getEmail() + "</td>");
                out.print("</tr>");
            }
            %>
            </tbody>
        </table>
        
        <h2>scriptlet &amp; expression 사용한 테이블 작성</h2>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
            <% for (Contact c : data) { %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getName() %></td>
                    <td><%= c.getPhone() %></td>
                    <td><%= c.getEmail() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
        
        <h2>scriptlet &amp; expression을 사용한 unordered list</h2>
        <ul>
        <%-- <li>이름</li>을 반복문으로 만드세요. --%>
        <% for (Contact c : data) { %>
            <li><%= c.getName() %></li>
        <% } %>
        </ul>
        
        <h2>scriptlet &amp; expression을 사용한 description list</h2>
        <dl>
        <%-- <dt>이름</dt><dd>전화번호</dd><dd>이메일</dd> 반복문으로 만드세요. --%>
        <% for (Contact c : data) { %>
            <dt><%= c.getName() %></dt>
            <dd><%= c.getPhone() %></dd>
            <dd><%= c.getEmail() %></dd>
        <% } %>
        </dl>
        
    </main>
</body>
</html>
