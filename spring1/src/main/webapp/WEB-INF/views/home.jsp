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
        <h1>Home</h1>
        <h2>${now}</h2>
        <!-- img alt="뉴욕" src="/spring1/images/newyork.jpg" -->
        <!-- img alt="뉴욕" src="./images/newyork.jpg"  -->
        <c:url var="newyork" value="/images/newyork.jpg" />
        <img alt="뉴욕" src="${newyork}" />
        <!-- img src="http://localhost:8080/spring1/images/newyork.jpg" -->
    </header>
    
    <main>
        <h1>Contents</h1>
        <nav>
            <ul>
                <li>
                    <c:url var="exPage" value="/example" />
                    <a href="${exPage}">컨트롤러 예제</a>
                </li>
                <li>
                    <c:url var="testPage" value="/test" />
                    <a href="${testPage}">테스트 페이지</a>
                </li>
                <li>
                    <c:url var="forwardPage" value="/test2" />
                    <a href="${forwardPage}">포워드</a>
                </li>
                <li>
                    <c:url var="redirectPage" value="/test3" />
                    <a href="${redirectPage}">리다이렉트</a>
                </li>
            </ul>
        </nav>
    </main>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
</body>
</html>
