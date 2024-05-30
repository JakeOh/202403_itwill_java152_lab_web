<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Lab 5</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous" />
</head>
<body>
    <div class="container-fluid">
        <!-- 회원 가입 양식(form) -->
        <main>
            <div class="mt-2 card">
                <div class="card-header">
                    <h2>회원가입</h2>
                </div>
                <div class="card-body">
                    <c:url var="signUpPage" value="/user/signup" />
                    <form method="post" action="${signUpPage}">
                        <div class="mt-2">
                            <label for="userid" class="form-label">아이디</label>
                            <input type="text" id="userid" class="form-control" 
                                name="userid" required autofocus />
                        </div>
                        <div class="mt-2">
                            <label for="password" class="form-label">비밀번호</label>
                            <input type="password" id="password" class="form-control" 
                                name="password" required />
                        </div>
                        <div class="mt-2">
                            <label for="email" class="form-label">이메일</label>
                            <input type="email" id="email" class="form-control" 
                                name="email" required />
                        </div>
                        <div class="mt-2">
                            <input type="submit" class="form-control btn btn-outline-success" 
                                value="작성완료" />
                        </div>
                    </form>
                </div>
            </div>
        </main>
    </div>    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
</body>
</html>
