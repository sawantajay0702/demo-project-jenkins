package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entites.Category;
import com.springboot.demo.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save")
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
		
	}
	
	@GetMapping("/save")
	public List<Category> findAllCategory() {
		return categoryService.findAllCategory();
		
	}


}
