package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.beans.GlobalResponseHandler;
import com.springboot.demo.entites.CartsItems;
import com.springboot.demo.service.CartItemsService;

@RestController
@RequestMapping("/api/v1/carts")
public class CartItemsController {

	@Autowired
	private CartItemsService cartItemsService;

	@PostMapping("/save")
	public ResponseEntity<Object> createCarts(@RequestBody CartsItems cartItems) {

		Object createCartItem = cartItemsService.createCartItem(cartItems);

		return GlobalResponseHandler.createResponse("Cart Items Created", createCartItem, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<Object> getAllCarts(){
		List<CartsItems> allCarts = cartItemsService.getAllCarts();
		ResponseEntity<Object> createResponse = GlobalResponseHandler.createResponse("All carts Featched", allCarts, HttpStatus.OK);
		return createResponse;
	}
}
