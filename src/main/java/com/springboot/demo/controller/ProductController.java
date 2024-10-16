package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.beans.GlobalResponseHandler;
import com.springboot.demo.entites.Product;
import com.springboot.demo.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired 
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		
		Object addProduct = productService.addProduct(product);
		
		ResponseEntity<Object> createResponse = GlobalResponseHandler.createResponse("Product Added", addProduct, HttpStatus.CREATED);
		
		return createResponse;
	}
	
	@GetMapping("/save")
	public ResponseEntity<Object> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return GlobalResponseHandler.createResponse("All UserList", products, HttpStatus.OK);
	}

}
