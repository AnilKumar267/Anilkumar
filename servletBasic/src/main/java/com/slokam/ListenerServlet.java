package com.slokam;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerServlet implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		String uer = (String) arg0.getSession().getAttribute("key");
		System.out.println("sessionCreated..."+uer);
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		String uer = (String) arg0.getSession().getAttribute("key");
		System.out.println("sessionDestroyed...."+uer);
		
	}

}
