package com.itwill.lab05.web;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "postListController", urlPatterns = { "/post/list" })
public class PostListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PostListController.class);
    
    // Service(Business) 계층의 기능(메서드)들을 사용하기 위해서.
    private final PostService postService = PostService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        log.debug("doGet()");
        
        // DB posts 테이블에서 전체 검색을 하고, 그 결과를 뷰에 전달.
        List<Post> list = postService.read();
        req.setAttribute("posts", list);
        
        req.getRequestDispatcher("/WEB-INF/views/post/list.jsp")
            .forward(req, resp);
    }
    
}
