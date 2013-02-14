package com.itcuties.java.enums.data;

/**
 * Enumerators can have both methods and fields just as normal classes.
 * 
 * @author itcuties
 */
public enum ComplexEnum {
	VALUE;

	private int customPrivateField = 9;
	public int customPublicField;

	public void customMethod() {
		System.out.println("This is a custom enum method!");
	}

	public int getCustomPrivateField() {
		return customPrivateField;
	}

	@Override
	public String toString() {
		return "Overriden toString: " + super.toString() + "("
				+ customPrivateField + ")";
	}
}
