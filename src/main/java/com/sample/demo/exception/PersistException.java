package com.sample.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class PersistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PersistException(String message) {
		super(message);
	}
	
	public PersistException(String message, Throwable t) {
		super(message, t);
	}
}
