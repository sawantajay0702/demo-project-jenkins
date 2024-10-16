package com.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entites.CartsItems;
import com.springboot.demo.repository.CartItemRepository;

@Service
public class CartItemsService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	public Object createCartItem(CartsItems cartsItems) {
		return cartItemRepository.save(cartsItems);
	}

	public List<CartsItems> getAllCarts() {
		return cartItemRepository.findAll();
	}

}
