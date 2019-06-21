package com.glen.Zuul.filter;


import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.support.RequestContext;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class MyZuulFilter extends ZuulFilter{
	
	private static  Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	
	@Override
	public String filterType() {
		
		//return "route";
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}
	
	@Override
	public Object run() throws ZuulException {
		
		
		//String str = "http://localhost:8080/buybooks/5";
		
		String str = "http://localhost:8080/economy/";
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		/*
		log.info("%s request to %s", request.getMethod(), request.getRequestURL().toString());
		
		System.out.println();
		System.out.println(request.getMethod());
		System.out.println();
		System.out.println(request.getRequestURL().toString());
		
		*/
		
		// Duhet te merret nje pjese e stringut vetem
		String str1 = request.getRequestURL().toString();
		System.out.println(str1);
		
		String str2;
		
		if(str1.length() > 30) {
			
			str2 = str1.substring(0, 30);
	
		if(str.equalsIgnoreCase(str2)) {
			
			
			try 
			{
				//ctx.getResponse().sendRedirect("http://localhost:8080/books");
				ctx.getResponse().sendRedirect("http://localhost:8080/404.html");
			} 
			catch (IOException e) 
				{
					log.error("unable to send a redirect to the spcific page");
					//e.printStackTrace();
				}
			
			//System.out.println(str.equalsIgnoreCase(str1));
			//return "redirect:/http://localhost:8080/books";
			 //return "redirect:404.html";
		}
	
		}
			return null;
		
		
	}


}
