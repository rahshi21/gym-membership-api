package com.gm.exception;

public class EquipmentNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	// default constructor
	public EquipmentNotFoundException() {
		super();
	}
	
	public EquipmentNotFoundException(String message) {
		super(message);
	}
}
