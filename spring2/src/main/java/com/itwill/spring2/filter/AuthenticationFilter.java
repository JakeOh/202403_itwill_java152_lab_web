package com.itwill.spring2.filter;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter extends HttpFilter {
    private static final long serialVersionUID = 1L;
    public static final String SESSION_ATTR_USER = "signedInUser";
    
    @Override
    public void init() throws ServletException {
        log.debug("authFilter 초기화...");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Object signedInUser = session.getAttribute(SESSION_ATTR_USER);
        if (signedInUser != null) { // 세션에 로그인 정보가 있으면
            log.debug("로그인 됨: {}", signedInUser);
            
            // 필터 체인의 다음 단계(다음 필터 또는 서블릿)을 실행.
            chain.doFilter(request, response);
            return;
        }
        
        // 세션에 로그인 정보가 없는 경우:
        log.debug("로그인 안됨 ---> 로그인 페이지로 이동");
        
        String url = req.getRequestURL().toString();
        log.debug("[url] {}", url);
        
        String qs = req.getQueryString();
        log.debug("[query string] {}", qs);
        
        String target = ""; // 로그인 후 이동할 페이지(타겟)
        if (qs == null) {
            target = URLEncoder.encode(url, "UTF-8");
        } else {
            target = URLEncoder.encode(url + "?" + qs, "UTF-8");
        }
        log.debug("[target] {}", target);
        
        String signInPage = req.getContextPath()
                + "/user/signin?target="
                + target;
        
        // 로그인 페이지로 이동
        ((HttpServletResponse) response).sendRedirect(signInPage);
    }
    
}
