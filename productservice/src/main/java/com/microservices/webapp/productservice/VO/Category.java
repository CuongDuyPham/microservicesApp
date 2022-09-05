package com.microservices.webapp.productservice.VO;

public class Category {
	
	private Long categoryId;
	private String categoryName;
	
	public Long getId() {
		return categoryId;
	}
	public void setId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
