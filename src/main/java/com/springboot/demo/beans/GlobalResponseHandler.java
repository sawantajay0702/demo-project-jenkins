package com.springboot.demo.beans;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalResponseHandler {
	
	public static ResponseEntity<Object> createResponse(String message,Object data,HttpStatus httpStatus){
		
		
		HashMap<String, Object> response=new HashMap<>();
		
		response.put("message", message);
		response.put("payload", data);
		
		return new ResponseEntity<Object>(response,httpStatus);
		
	}
	
public static ResponseEntity<Object> createResponse(String message,HttpStatus httpStatus){
		
		HashMap<String, Object> response=new HashMap<>();
		
		response.put("message", message);
		
		
		return new ResponseEntity<Object>(response,httpStatus);
		
	}

}
