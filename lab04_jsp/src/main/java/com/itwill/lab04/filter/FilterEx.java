package com.itwill.lab04.filter;

import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FilterEx
 */
// 필터 요청 주소 매핑 설정:
// (1) web.xml(deployment descriptor) 파일에서 <filter>, <filter-mapping> 태그에서 설정하거나,
// (2) @WebFilter 애너테이션으로 설정.
// web.xml과 애너테이션을 중복으로 설정하면 안됨.
// 필터 체인이 있을 때, 필터들이 실행되는 순서는 web.xml에 설정된 순서대로 실행됨.
public class FilterEx extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterEx() {
        System.out.println("FilterEx 생성");
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
    public void destroy() {
	    // WAS가 종료될 때 생성된 필터 객체를 소멸시키기 위해서 호출하는 메서드.
		System.out.println("FilterEx::destroy() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
		System.out.println("FilterEx chain.doFilter() 호출 전");
	    // 클라이언트로부터 온 요청을 필터 체인(-> 서블릿)으로 전달하기 전에 실행할 코드를 작성.
		
		// 요청을 필터 체인으로 전달 -> 요청 주소에 매핑된 서블릿 메서드 호출.
		chain.doFilter(request, response);
		
		// 요청 처리가 끝난 후 실행할 코드를 작성.
		System.out.println("FilterEx chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	    // 필터가 생성된 후 초기화 작업을 수행하기 위해서 호출되는 메서드.
		System.out.println("FilterEx::init() 호출");
	}

}
