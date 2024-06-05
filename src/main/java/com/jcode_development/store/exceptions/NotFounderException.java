package com.jcode_development.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFounderException extends RuntimeException implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 300373281966559963L;
	
	public NotFounderException(String message) {
		super(message);
	}
	
	public NotFounderException() {
	}
}
