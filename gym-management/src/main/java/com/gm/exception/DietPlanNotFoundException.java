package com.gm.exception;

public class DietPlanNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	// default constructor
	public DietPlanNotFoundException() {
		super();
	}
	
	public DietPlanNotFoundException(String message) {
		super(message);
	}
}
