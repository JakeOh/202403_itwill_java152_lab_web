package com.itwill.lab04.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerEx
 *
 */
public class ListenerEx 
    implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public ListenerEx() {
        System.out.println("ListenerEx 생성자 호출");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent se)  { 
        // 세션이 생성됐을 때 WAS가 호출하는 메서드.
        System.out.println("세션 생성: " + se.getSession());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // 세션이 소멸됐을 때 WAS가 호출하는 메서드.
        System.out.println("세션 소멸: " + se.getSession());
    }
    
    /**
     * @See HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeAdded(se);
        System.out.println("세션 속성 추가: " + se.getName());
    }
	
}
