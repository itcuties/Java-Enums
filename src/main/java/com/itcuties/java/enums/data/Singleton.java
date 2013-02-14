package com.itcuties.java.enums.data;

/**
 * Enums can be used as a perfect singletons :) Because Java Virtual Machine
 * will do most of the job for us: <li>first invoke of Singleton.INSTANCE will
 * cause an instance to be initialized <li>there will NEVER be another instance
 * of this enum <li>it can be used as a normal class
 * <br/><br/>
 * To turn a class into a singleton many more steps must be taken. The
 * constructor need to be declared private. It will need to be initialized only
 * once in a method that will return an instance of a singleton (a need to write
 * a static access method). And in Java there should be a way to prevent
 * developers from creating another instance using reflection.
 * <br/><br/>
 * So the following enum is a MUCH better way to create a singleton, isn't it?
 * ;)
 * 
 * @author itcuties
 * 
 */
public enum Singleton {
	INSTANCE;
}
