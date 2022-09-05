package com.microservices.webapp.categoryservice.fallback;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CommandFailure extends HystrixCommand<String> implements Filter{
	
//	private final String name="/categoryServiceFallBack";
	
	public CommandFailure() {
		  super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CatgoryGroup"))
	                .andCommandKey(HystrixCommandKey.Factory.asKey("Category"))
	                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("CategoryPool")));
	}

	@Override
	protected String run() {
		throw new RuntimeException("This commmand is failed");
	}

	@Override
	protected String getFallback() {
		return "This commmand is failed";
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HystrixRequestContext context = HystrixRequestContext.initializeContext();
	        try {
	            chain.doFilter(request, response);
	        } finally {
	            context.shutdown();
	        }
	}
	
}
