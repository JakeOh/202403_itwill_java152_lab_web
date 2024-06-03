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

@WebServlet(name = "userProfileController", urlPatterns = { "/user/profile" })
public class UserProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UserProfileController.class);
    
    private UserService userService = UserService.INSTANCE;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        log.debug("doGet()");
        
        String userid = req.getParameter("userid");
        log.debug("userid={}", userid);
        
        User user = userService.read(userid);
        req.setAttribute("user", user);
        
        req.getRequestDispatcher("/WEB-INF/views/user/profile.jsp")
            .forward(req, resp);
    }

}
