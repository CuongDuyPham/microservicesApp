package com.microservices.webapp.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.webapp.productservice.VO.ResponseTemplateVO;
import com.microservices.webapp.productservice.entity.Product;
import com.microservices.webapp.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	//Get thong tin product va category trong ResponseTemplateVO
	@GetMapping("/{id}")
	public ResponseTemplateVO getProductWithCategoryByProductId(@PathVariable("id") Long id) {
		return productService.getProductwithCategory(id);
	}
	
}
