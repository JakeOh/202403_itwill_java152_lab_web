<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>form</title>
</head>
<body>
    <%@ include file="header.jspf" %>
    
    <main>
        <h1>Form</h1>
        
        <form method="get" action="form_result.jsp">
            <div>
                <input type="text" name="username" placeholder="사용자 이름" 
                    required autofocus />
            </div>
            <div>
                <select name="color">
                    <option value="r">빨강</option>
                    <option value="b">파랑</option>
                    <option value="g">초록</option>
                </select>
            </div>
            <div>
                <input type="submit" value="제출" />
            </div>
        </form>
    </main>
</body>
</html>
