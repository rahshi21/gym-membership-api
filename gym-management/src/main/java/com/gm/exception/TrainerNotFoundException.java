package com.gm.exception;

public class TrainerNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	// default constructor
	public TrainerNotFoundException() {
		super();
	}
	
	public TrainerNotFoundException(String message) {
		super(message);
	}
}
