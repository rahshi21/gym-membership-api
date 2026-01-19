package com.gm.exception;

public class BookingNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	// default constructor
	public BookingNotFoundException() {
		super();
	}
	
	public BookingNotFoundException(String message) {
		super(message);
	}
}
