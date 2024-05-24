<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Session</title>
</head>
<body>
    <%@ include file="../../header.jspf" %>
    
    <main>
        <h1>Session</h1>
        <h2>안녕, ${ nickname }!</h2>
        <%-- EL 상태 정보 찾기: pageScope => requestScope => sessionScope => applicationScope --%>
    </main>
</body>
</html>
