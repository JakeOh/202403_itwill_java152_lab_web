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
        <c:set var="pageTitle" value="Post Details" /> <%-- scope의 기본값은 page --%>
        <%@ include file="../fragments/header.jspf" %>
    
        <main>
            <div class="mt-2 card">
                <div class="card-header">
                    <h2>포스트 상세보기</h2>
                </div>
                <div class="card-body">
                    <form>
                        <div class="mt-2">
                            <label for="id" class="form-label">번호</label>
                            <input id="id" class="form-control" type="text"
                                value="${post.id}" readonly />
                        </div>
                        <div class="mt-2">
                            <label for="title" class="form-label">제목</label>
                            <input id="title" class="form-control" type="text"
                                value="${post.title}" readonly />
                        </div>
                        <div class="mt-2">
                            <label for="content" class="form-label">내용</label>
                            <textarea id="content" class="form-control" 
                                rows="5" readonly>${post.content}</textarea>
                        </div>
                        <div class="mt-2">
                            <label for="author" class="form-label">작성자</label>
                            <input id="author" class="form-control" type="text"
                                value="${post.author}" readonly />
                        </div>
                        <div class="mt-2">
                            <label for="createdTime" class="form-label">작성 시간</label>
                            <input id="createdTime" class="form-control" type="text"
                                value="${post.createdTime}" readonly />
                        </div>
                        <div class="mt-2">
                            <label for="modifiedTime" class="form-label">최종 수정 시간</label>
                            <input id="modifiedTime" class="form-control" type="text"
                                value="${post.modifiedTime}" readonly />
                        </div>
                    </form>
                </div>
                
                <%-- 글 작성자 아이디와 로그인 사용자 아이디가 같으면 수정하기 버튼을 보여줌. --%>
                <c:if test="${post.author eq signedInUser}">
                    <div class="card-footer">
                        <c:url var="postModifyPage" value="/post/modify">
                            <c:param name="id" value="${post.id}" />
                        </c:url>
                        <a class="btn btn-outline-primary"
                            href="${postModifyPage}">수정하기</a>
                    </div>
                </c:if>
            </div>
        </main>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
</body>
</html>
