package com.itwill.lab05.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

public class CharacterEncodingFilter extends HttpFilter {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CharacterEncodingFilter.class);
    
    private String encoding;
    
    // WAS가 Filter 객체를 생성한 후, 필터의 초기화 작업을 하기 위해서 호출하는 메서드.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // web.xml에서 <filter> <init-param>의 <param-name> 값을 아규먼트로 전달하면,
        // <filter> <init-param>의 <param-value> 값을 리턴해줌.
        encoding = filterConfig.getInitParameter("encoding");
        log.debug("init: encoding={}", encoding);
    }
    
    // 필터 체인(-> 서블릿)으로 진행하기 위해서 WAS가 호출하는 메서드.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String remoteAddr = request.getRemoteAddr();
        log.debug("누구? {}", remoteAddr);
        
        // 요청(request) 객체의 문자열 인코딩 타입을 (UTF-8로) 설정: 
        request.setCharacterEncoding(encoding);
        
        // 다음 필터 체인을 진행(-> 서블릿 메서드(doGet, doPost) 호출)
        chain.doFilter(request, response);
    }

}
