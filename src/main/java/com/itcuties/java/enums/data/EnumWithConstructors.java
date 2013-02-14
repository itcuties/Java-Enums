package com.itcuties.java.enums.data;

/**
 * Enumerators can have as many constructors as needed. The constructors are
 * always private and cannot be invoked even by reflection. The constructors are
 * used in values definitions and only there. What is done with the parameters
 * is defined by the developer. They can be used as normal constructor
 * parameters.
 * 
 * In languages like C/C++/C# enums can have integer values assigned. enum
 * EnumName { VALUE1 = 10, VALUE2 = 20, VALUE3 = 30 }; In fact these enums are
 * treated there as constants and can be cast into <b>int</b> value. In Java you
 * cannot cast an enum to a primitive nor to any other class. But you can
 * simulate assigning a value to it by using a proper constructor. Constructor
 * can accept any kind of parameters and these can be stored in enum's fields.
 * 
 * Enumerators CANNOT have generic types.
 * 
 * @author itcuties
 */
public enum EnumWithConstructors {
	VALUE1(1), VALUE2, VALUE3(1, "test");

	/**
	 * An empty constructor. Here used to instantiate VALUE2.
	 */
	private EnumWithConstructors() {
	}

	/**
	 * Constructor with one argument. Used to instantiate VALUE1.
	 */
	private EnumWithConstructors(int a) {
	}

	/**
	 * Constructor with two arguments. Used to instantiate VALUE3.
	 */
	private EnumWithConstructors(int a, String b) {
	}
}
