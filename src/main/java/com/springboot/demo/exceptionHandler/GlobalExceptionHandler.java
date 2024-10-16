package com.springboot.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.demo.beans.GlobalResponseHandler;
import com.springboot.demo.exception.UserNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({UserNotFound.class})
	public ResponseEntity<Object> userNotFoundException(UserNotFound userNotFound){
		
		return GlobalResponseHandler.createResponse(userNotFound.getMessage(), HttpStatus.NOT_FOUND);
	}

}
