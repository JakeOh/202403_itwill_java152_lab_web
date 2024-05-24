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
		System.out.println("FilterEx::destroy() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
		System.out.println("FilterEx chain.doFilter() 호출 전");
	    
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("FilterEx chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FilterEx::init() 호출");
	}

}
