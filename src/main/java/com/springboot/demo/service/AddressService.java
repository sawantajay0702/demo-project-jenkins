package com.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entites.Address;
import com.springboot.demo.repository.AddressRepo;
import com.springboot.demo.repository.UserRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;
	
	public Address createUser(Address address) {
		return addressRepo.save(address);
	}

	public Object findAllAddress() {
		return addressRepo.findAll();
		
	}
	
}
