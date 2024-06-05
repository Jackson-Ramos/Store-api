package com.jcode_development.store.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -9133062547395636198L;
	
	private Date timestamp;
	private String message;
	private String details;
}
