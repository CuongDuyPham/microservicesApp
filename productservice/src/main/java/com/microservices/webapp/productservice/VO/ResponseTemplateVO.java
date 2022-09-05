package com.microservices.webapp.productservice.VO;

import com.microservices.webapp.productservice.entity.Product;

public class ResponseTemplateVO {
	
	private Product product;
	private Category category;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
