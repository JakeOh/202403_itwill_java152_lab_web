package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "userSignUpController", urlPatterns = { "/user/signup" })
public class UserSignUpController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UserSignUpController.class);
    
    private final UserService userService = UserService.INSTANCE;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        log.debug("doGet()");
        
        req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp")
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        log.debug("doPost()");
        
        // 회원가입 폼에서 제출된 userid, password, email 요청 파라미터 값을 읽음.
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = User.builder()
                .userid(userid).password(password).email(email)
                .build();
        log.debug("{}", user);
        
        // 서비스 계층의 메서드를 호출해서 회원가입.
        userService.signUp(user);
        
        // 홈페이지로 이동(redirect)
        String url = req.getContextPath() + "/";
        resp.sendRedirect(url);
    }
    
}
