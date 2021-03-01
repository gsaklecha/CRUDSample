package com.sample.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StateNotMatchException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StateNotMatchException(String message) {
		super(message);
	}
	
	public StateNotMatchException(String message, Throwable t) {
		super(message, t);
	}
}
