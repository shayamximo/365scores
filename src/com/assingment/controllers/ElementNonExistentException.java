package com.assingment.controllers;

public class ElementNonExistentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String cause = "Element Controller does not exist for given Section, check the Name field in Section";

	@Override
	public String getMessage() {
		return cause;
	}

	@Override
	public String getLocalizedMessage() {
		return cause;
	}

}
