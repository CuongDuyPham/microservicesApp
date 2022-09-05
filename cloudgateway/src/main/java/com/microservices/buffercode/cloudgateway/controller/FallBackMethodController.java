package com.microservices.buffercode.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FallBackMethodController extends com.netflix.hystrix.HystrixCommand<String>{
	
	protected FallBackMethodController() {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ApiGatewayGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ApiGateway"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("GatewayPool")));
		// TODO Auto-generated constructor stub
	}

//	@HystrixCommand(commandProperties = { @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE") })
	
	@HystrixCommand
	@GetMapping("/categoryServiceFallBack")
	public String categoryServiceFallBackMethod() {
		return "Category Service is taking longer than expected. Please try again later";
	}
	
	@HystrixCommand
	@GetMapping("/productServiceFallBack")
	public String productServiceFallBackMethod() {
		return "Product Service is taking longer than expected. Please try again later";
	}

	@Override
	protected String run() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
