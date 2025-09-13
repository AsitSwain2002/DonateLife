package com.org.DonateLife.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public static ResponseEntity<?> resourceNotFound(ResourceNotFound rs) {
		return new ResponseEntity(rs.getMessage(), HttpStatus.NOT_FOUND);
	}
}
