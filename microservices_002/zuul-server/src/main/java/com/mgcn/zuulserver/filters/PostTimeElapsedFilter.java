package com.mgcn.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

 
@Component
public class PostTimeElapsedFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(PostTimeElapsedFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		

		RequestContext ctxContext = RequestContext.getCurrentContext();
		HttpServletRequest request = ctxContext.getRequest();
		
		logger.info("Entrando a post filter");
		
		Long startTime = (Long) request.getAttribute("tiempoInicio");
		Long endTimeLong = System.currentTimeMillis();
		Long elapsedTimeLong = endTimeLong - startTime;
		
		logger.info(String.format("Tiempo transcurriido en segundos: %s", elapsedTimeLong.doubleValue()/1000.00));
		logger.info(String.format("Tiempo transcurriido en milisegundos: %s", elapsedTimeLong));
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	
}
