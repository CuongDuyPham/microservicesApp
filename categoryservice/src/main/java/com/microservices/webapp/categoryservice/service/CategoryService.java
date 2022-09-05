package com.microservices.webapp.categoryservice.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.webapp.categoryservice.entity.Category;
import com.microservices.webapp.categoryservice.repository.CategoryRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
//	@HystrixCommand(commandProperties = { @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE") })
	@HystrixCommand
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
//	@HystrixCommand(commandProperties = { @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE") })
	@HystrixCommand
	public Category getCategoryById(Long id) {
		Optional<Category> cat = categoryRepository.findById(id);
		return cat.get();
	}
	
}
