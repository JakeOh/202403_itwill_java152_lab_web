package com.itwill.lab05.filter;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter extends HttpFilter {
    private static final long serialVersionUID = 1L;

    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 필터 객체가 소멸될 때 WAS가 호출하는 메서드.
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
		// 인증이 필요한 요청 주소들(예: 새 글, 상세보기, ...)에 대해서
	    // 로그인 여부를 확인하고,
	    // (1) 로그인되어 있으면, 컨트롤러로 요청을 전달해서 계속 요청을 처리.
	    // (2) 로그인되어 있지 않으면, 컨트롤러로 요청을 전달하지 않고 로그인 페이지로 이동.
	    // -> 로그인 컨트롤러(UserSignInController)에서 로그인 성공 후 최초 요청 주소로 이동.

	    HttpServletRequest req = ((HttpServletRequest) request);
	    
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// WAS가 필터 객체를 생성한 후 호출.
	}

}
