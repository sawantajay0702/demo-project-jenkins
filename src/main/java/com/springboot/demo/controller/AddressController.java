package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.beans.GlobalResponseHandler;
import com.springboot.demo.entites.Address;
import com.springboot.demo.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address")
	public ResponseEntity<Object> createUser(@RequestBody Address address){
		
		return GlobalResponseHandler.createResponse("Address Created",addressService.createUser(address) 
				, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/address")
	public ResponseEntity<Object> featchAlladdress(){
		
		return GlobalResponseHandler.createResponse("Address Created",addressService.findAllAddress() 
				, HttpStatus.OK);
		
	}

}
