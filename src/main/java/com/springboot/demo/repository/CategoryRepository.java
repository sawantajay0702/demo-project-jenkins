package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entites.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	

}
