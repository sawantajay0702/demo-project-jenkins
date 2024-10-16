package com.springboot.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.bean.ErrorBean;
import com.springboot.demo.beans.GlobalResponseHandler;
import com.springboot.demo.entites.User;
import com.springboot.demo.service.UserService;
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//@PostMapping("/save/users")
     @RequestMapping(method = RequestMethod.POST,path = "/save/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody User user){
	User createdUser = userService.createUser(user);
		
		if(Objects.nonNull(createdUser))
		 return GlobalResponseHandler.createResponse("User Created",createdUser,HttpStatus.CREATED);
		else {
			 return GlobalResponseHandler.createResponse("Error",createdUser,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	// return new ResponseEntity<Object>(null,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getUsers(){
		List<User> allUsers = userService.getAllUsers();
		 return GlobalResponseHandler.createResponse("All Users featched",allUsers,HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public <T> ResponseEntity<Object> getUserById(@PathVariable Long id){
		
		Optional<User> userById = userService.getUserById(id);
		ErrorBean errorBean = null;
		if(userById.isPresent()) {
			return GlobalResponseHandler.createResponse("User Featched by id"+id, userById, HttpStatus.OK);
		}else {
			errorBean.setErrorMessage("User not found for id"+id);
			return GlobalResponseHandler.createResponse("User Featched by id"+id, errorBean, HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		return GlobalResponseHandler.createResponse("Deleted", userService.deleteById(id), HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) throws Exception{
		return GlobalResponseHandler.createResponse("User Updated", userService.updateUser(id, user),HttpStatus.OK);
	}

}
