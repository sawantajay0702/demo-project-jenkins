package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entites.CartsItems;

@Repository
public interface CartItemRepository extends JpaRepository<CartsItems, Long> {

	
}
