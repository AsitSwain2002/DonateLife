package com.org.DonateLife.ExceptionHandling;

public class ResourceNotFound extends RuntimeException {
	public ResourceNotFound(String message) {
		super(message);
	}
}
