package com.itcuties.java.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itcuties.java.enums.data.ComplexEnum;
import com.itcuties.java.enums.data.SimpleEnum;

/**
 * This class shows how to use Java enumerators.
 * 
 * @author itcuties
 */
public class EnumsMain {

	public static void main(String[] args) {
		try {
			//EnumsMain.presentBasicEnumOperations();
			
			//EnumsMain.gettingEnumsReferences();
			
			EnumsMain.enumsBehavingLikeClasses();
		} catch (Exception e) {
			System.err.println("This exception should not happen: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method presents basic enums usage.
	 */
	private static void presentBasicEnumOperations() throws Exception {
		System.out.println("Basic operations on enumerators.");
		
		//declare enum variable with set up value
		SimpleEnum simpleEnum1 = SimpleEnum.VALUE1;
		SimpleEnum simpleEnum2 = SimpleEnum.VALUE2;
		SimpleEnum simpleEnum3 = SimpleEnum.VALUE3;
		
		System.out.println("Enum behaves like a normal instance of a class; they can be printed ...");
		System.out.println(simpleEnum1);
		System.out.println(simpleEnum2.toString());
		
		System.out.println("... they can be compared using equals...");
		System.out.println(simpleEnum1.equals(simpleEnum2));
		System.out.println(simpleEnum1.equals("string"));
		System.out.println(simpleEnum3.equals(simpleEnum3));
		
		//
		System.out.println("... but they can also be compared safely using == operator among themselves (which should NOT be used for normal classes).");
		System.out.println(simpleEnum1 == simpleEnum2);
		//System.out.println(simpleEnum1 == "string");//this will cause compilation ERROR
		System.out.println(simpleEnum3 == simpleEnum3);
		
		System.out.println("They can be used in a switch statement.");
		switch(simpleEnum1) {
			case VALUE1:
				System.out.println("Enum: VALUE1");
				break;
			case VALUE2:
				System.out.println("Enum: VALUE2");
				break;
			case VALUE3:
				System.out.println("Enum: VALUE3");
				break;
			default:
				throw new Exception("Unknown enum value!");
		}
		
		System.out.println("They can be put into table, list or any other container.");
		SimpleEnum[] enumTable = new SimpleEnum[] {
				simpleEnum1, simpleEnum2, simpleEnum3, SimpleEnum.VALUE2
		};
		System.out.println(Arrays.toString(enumTable));
		
		List<SimpleEnum> enumList = new ArrayList<SimpleEnum>();//it can e used in generics too
		enumList.add(simpleEnum1);
		enumList.add(SimpleEnum.VALUE2);
		System.out.println(enumList);
	}
	
	/**
	 * This method shows a way of getting the enum reference.
	 */
	private static void gettingEnumsReferences() throws Exception {
		System.out.println("Getting an enum reference.");
		//enums are instantiated when they are loaded by classloader and further instantiation is pointless
		//this means that there are only as many instances of the enum as the amount of its declared values
		
		System.out.println("In the application we only reference enumerators.");
		SimpleEnum simpleEnum1 = SimpleEnum.VALUE1;
		SimpleEnum simpleEnum2 = SimpleEnum.VALUE2;
		SimpleEnum simpleEnum3 = SimpleEnum.VALUE3;
		
		System.out.println("Enums CANNOT be created using the new operator ...");
		//SimpleEnum error = new SimpleEnum();    <------ THIS WILL CAUSE COMPILATION ERROR
		
		System.out.println("... and using reflection will be of no use either.");
		try {
			SimpleEnum.class.newInstance();
		} catch(InstantiationException e) {
			System.out.println("ERROR: Although the compiler will allow the operation from try block, it will always FAIL: " + e.getLocalizedMessage());
		}
		
		System.out.println("Enum can be retreivied by name (but this is NOT instantiation).");
		SimpleEnum simpleEnum = SimpleEnum.valueOf("VALUE1");
		System.out.println(simpleEnum);
		
		System.out.println("But providing invalid name will cause an error.");
		try {
			SimpleEnum.valueOf("vALUE1");//take notice that this is case-sensitive !!!!!!
		} catch(IllegalArgumentException e) {
			System.out.println("ERROR: When invoking valueOf it is important to remember about the case-sensitivness.");
		}
		
		System.out.println("All available enums can be simply enlisted.");
		SimpleEnum[] enums = SimpleEnum.values();
		for(SimpleEnum e : enums) {
			System.out.println(e);
		}
		
		System.out.println("Enum can be retrieved using an enum class name and the proper value name.");
		SimpleEnum e = Enum.valueOf(SimpleEnum.class, "VALUE1");
		System.out.println(e);
	}
	
	/**
	 * This method shows that an enum can be used like any other class instance. You can invoke methods and alter fields.
	 */
	private static void enumsBehavingLikeClasses() throws Exception {
		System.out.println("Enumerators can behave like normal classes.");
		ComplexEnum complexEnum = ComplexEnum.VALUE;
		
		System.out.println("A custom method can be called.");
		complexEnum.customMethod();
		
		System.out.println("Custom toString will be called when printing the enum.");
		System.out.println(complexEnum);
		
		System.out.println("Fields can be accessed (the access scope is of course defined by the access modifier).");
		System.out.println(complexEnum.customPublicField);
		
		System.out.println("The fields can be altered just like in a normal class.");
		complexEnum.customPublicField = 89;
		System.out.println(complexEnum.customPublicField);
	}
}
