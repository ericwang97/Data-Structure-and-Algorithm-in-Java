package edu.cofc.csci230;

/**
 * 
 * Exception used in hash data structure project assignment.
 * 
 * This is thrown when key exception is raised by the open
 * or closed hashing classes. It may be used for various 
 * conditions such as: 1) duplicate key exists, 2) key does 
 * not exist, etc.
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
@SuppressWarnings("serial")
public class HashTableKeyException extends Exception {

	public HashTableKeyException( String error_message ) {
		super( error_message );
	}
	
} // end HashTableKeyException class definition
