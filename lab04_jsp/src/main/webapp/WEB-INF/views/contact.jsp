<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>MVC</title>
</head>
<body>
    <%@ include file="../../header.jspf" %>
    
    <main>
        <h1>MVC(Model-View-Controller)</h1>
        <h2>연락처 입력 페이지</h2>
        <form action="mvc" method="post">
            <div>
                <input type="number" name="id" placeholder="번호" required autofocus />
            </div>
            <div>
                <input type="text" name="name" placeholder="이름" required />
            </div>
            <div>
                <input type="text" name="phone" placeholder="전화번호" required />
            </div>
            <div>
                <input type="email" name="email" placeholder="이메일" />
            </div>
            <div>
                <input type="submit" value="저장" />
                <input type="reset" value="취소" />
            </div>
        </form>
    </main>
</body>
</html>
