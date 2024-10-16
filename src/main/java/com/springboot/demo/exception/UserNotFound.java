package com.springboot.demo.exception;

public class UserNotFound extends RuntimeException
{

	public UserNotFound(String message) {
		super(message);
	}
}
