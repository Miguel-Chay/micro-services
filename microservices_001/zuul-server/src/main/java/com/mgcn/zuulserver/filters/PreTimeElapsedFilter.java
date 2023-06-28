package com.mgcn.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

 
@Component
public class PreTimeElapsedFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(PreTimeElapsedFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		

		RequestContext ctxContext = RequestContext.getCurrentContext();
		HttpServletRequest request = ctxContext.getRequest();
		
		logger.info(String.format( "%s request enrutado a %s",request.getMethod(), request.getRequestURL().toString()));
		
		Long startTime = System.currentTimeMillis();
		
		request.setAttribute("tiempoInicio", startTime);
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	
}
