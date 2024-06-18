<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Spring Legacy 2</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous" />
</head>
<body>
    <div class="container-fluid">
        <c:set var="pageTitle" value="회원가입" />
        <%@ include file="../fragments/header.jspf" %>
        
        <main>
            <div class="my-2 card card-body">
                <c:url var="signUpPage" value="/user/signup" />
                <form action="${signUpPage}" method="post">
                    <div class="my-2">
                        <input type="text" class="form-control" id="userid"
                            name="userid" placeholder="사용자 아이디" required autofocus />
                    </div>
                    
                    <!-- userid 중복 체크 결과 표시할 영역 -->
                    <div id="checkUseridResult"></div>
                    
                    <div class="my-2">
                        <input type="password" class="form-control" id="password"
                            name="password" placeholder="비밀번호" required />
                    </div>
                    
                    <div class="my-2">
                        <input type="email" class="form-control" id="email"
                            name="email" placeholder="이메일" required />
                    </div>
                    
                    <div class="my-2">
                        <button id="btnSignUp"
                            class="form-control btn btn-outline-success disabled">작성 완료</button>
                    </div>
                </form>
            </div>
        </main>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
</body>
</html>
