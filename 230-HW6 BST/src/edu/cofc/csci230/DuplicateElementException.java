package edu.cofc.csci230;

/**
 * 
 * Exception used in binary search tree coding assignment.
 * 
 * This exception is thrown when a duplicate element (i.e. 
 * an existing node in the binary search tree has the same 
 * element value.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 */
@SuppressWarnings("serial")
public class DuplicateElementException extends Exception {

	public DuplicateElementException() {
		super( "Duplicate Element Exception" );
	}
	
} // end DuplicateElementException class definition
