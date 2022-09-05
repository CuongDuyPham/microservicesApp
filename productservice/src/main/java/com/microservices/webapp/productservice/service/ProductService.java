package com.microservices.webapp.productservice.service;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.webapp.productservice.VO.Category;
import com.microservices.webapp.productservice.VO.ResponseTemplateVO;
import com.microservices.webapp.productservice.entity.Product;
import com.microservices.webapp.productservice.repository.ProductRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RestTemplate restTemplate;
	
//	Truong hop: muon cau hinh cho hystrix command hoac co the bo sung trong application.properties
//	@HystrixCommand(commandProperties = { @HystrixProperty(name="execution.isolation.strategy", value="THREAD") })
	
	@HystrixCommand
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		Optional<Product> prod = productRepository.findById(id);
		return prod.get();
	}

	// Lay thong tin cua responseTemplateVO (Product + Category)
	@HystrixCommand
	public ResponseTemplateVO getProductwithCategory(Long id) {
		ResponseTemplateVO res = new ResponseTemplateVO();

		// 1.Lay product trong data bang id
		Optional<Product> prod = productRepository.findById(id);
		Product product = prod.get();

		// 2.Lay categoryId co trong Product va gui request qua categoryservice de lay
		// ve thong tin Category trong VO cua Product
		Category category = restTemplate.getForObject("http://CATEGORY-SERVICE/category/" + product.getCategoryId(),
				Category.class);

		// 3.Set data cho ResponseTemplateVO de hien thi cho viewer
		res.setProduct(product);
		res.setCategory(category);

		return res;
	}
}
