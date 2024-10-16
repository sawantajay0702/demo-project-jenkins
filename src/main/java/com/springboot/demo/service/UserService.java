package com.springboot.demo.service;

import java.beans.Encoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entites.Address;
import com.springboot.demo.entites.User;
import com.springboot.demo.exception.UserNotFound;
import com.springboot.demo.repository.AddressRepo;
import com.springboot.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User createUser(User user) {		
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id) {
	 Optional<User> optionalUser=userRepository.findById(id);
	 return optionalUser;
	}
	
	public String deleteById(Long id) {
		
      Optional<User> exestingUser=userRepository.findById(id);
		
		if(exestingUser.isPresent()) {
			userRepository.deleteById(id);
			return "Deleted";
		}
		throw new  UserNotFound("User not Found for delete with id "+id);
		
		
		
	}
	
	public Object updateUser(Long id,User user) throws Exception {
		Optional<User> exestingUser=userRepository.findById(id);
		
		if(exestingUser.isPresent()) {
			
			exestingUser.get().setEmail(user.getEmail());
			exestingUser.get().setName(user.getName());
			return userRepository.save(exestingUser.get());
		}
		throw new UserNotFound("User Not Found");
		
	}
}
