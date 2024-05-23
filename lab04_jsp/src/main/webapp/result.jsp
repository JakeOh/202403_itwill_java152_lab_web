<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>JSTL</title>
</head>
<body>
    <%@ include file="header.jspf" %>
    
    <main>
        <h1>RESULT</h1>
        <h2>안녕하세요, 
            <span style="color: ${ param.color }">${ param.username }</span>!
        </h2>
        <%-- EL에서 request.getParameter("username")을 대신하는 방법: ${param.usernam} --%>
        
        <%-- JSTL의 조건문 --%>
        <c:choose>
            <c:when test="${ param.username eq 'admin' }">
                <h3>관리자 페이지</h3>
            </c:when>
            <c:when test="${ param.username eq 'guest' }">
                <h3>손님 페이지</h3>
            </c:when>
            <c:otherwise>
                <h3>일반 사용자 페이지</h3>
            </c:otherwise>
        </c:choose>
        
        <%-- EL 비교 연산자: eq(==), ne(!=) --%>
        <c:if test="${ param.username eq 'admin' }">
            <h3>Adamin Page</h3>
        </c:if>
        <c:if test="${ param.username ne 'admin' }">
            <h3>User Page</h3>
        </c:if>
        
    </main>
</body>
</html>
