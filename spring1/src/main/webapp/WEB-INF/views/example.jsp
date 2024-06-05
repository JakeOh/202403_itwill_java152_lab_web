<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Spring 1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous" />
</head>
<body>
    <header>
        <h1>Example 페이지</h1>
    </header>
    
    <nav>
        <ul>
            <li>
                <c:url var="homePage" value="/" />
                <a href="${homePage}">홈 페이지</a>
            </li>
        </ul>
    </nav>
    
    <main>
        <section>
            <h2>GET 방식 요청</h2>
            <c:url var="ex1" value="/ex1" />
            <form method="get" action="${ex1}">
                <input type="text" name="username" placeholder="이름 입력" />
                <input type="number" name="age" placeholder="나이 입력" />
                <input type="submit" value="제출" />
            </form>
        </section>
    </main>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
</body>
</html>
