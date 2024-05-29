package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "postDetailsController", urlPatterns = { "/post/details" })
public class PostDetailsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PostDetailsController.class);
    
    private final PostService postService = PostService.INSTANCE;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        log.debug("doGet()");
        
        // 질의 문자열(query string)에 포함된 요청 파라미터 id 값을 읽음.
        int id = Integer.parseInt(req.getParameter("id"));
        log.debug("id={}", id);
        
        // 서비스 계층의 메서드를 호출해서 해당 id의 Post 정보를 DB에서 읽음.
        // 검색된 Post 객체를 뷰(JSP)에게 전달.
        
        // 뷰로 이동(forward)
        req.getRequestDispatcher("/WEB-INF/views/post/details.jsp")
            .forward(req, resp);
    }

}
