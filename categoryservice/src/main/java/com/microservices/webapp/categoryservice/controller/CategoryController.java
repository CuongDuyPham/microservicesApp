package com.microservices.webapp.categoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.webapp.categoryservice.entity.Category;
import com.microservices.webapp.categoryservice.fallback.CommandFailure;
import com.microservices.webapp.categoryservice.service.CategoryService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

@RestController
@RequestMapping("/category")
public class CategoryController{

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	@GetMapping("/{id}")
	public Category findCategoryById(@PathVariable("id") Long id) {
		return categoryService.getCategoryById(id);
	}

//	@Override
//	protected Category run() throws Exception {
//		// TODO Auto-generated method stub
//		throw new RuntimeException("forcing failure for example");
//	}
	
}
