package com.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entites.Product;
import com.springboot.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Object addProduct(Product product) {
		return productRepository.save(product);
		
	}

	public List<Product> getAllProducts() {
		
		List<Product> findAllList = productRepository.findAll();
		
		return findAllList;
	}

}
