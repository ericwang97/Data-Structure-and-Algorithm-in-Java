package edu.cofc.csci230;

/**
 * 
 * Exception used in binary search tree coding assignment.
 * 
 * This exception is thrown when an operation is applied to 
 * an binary search tree that is empty.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 */
@SuppressWarnings("serial")
public class EmptyBSTException extends Exception {
	
	public EmptyBSTException() {
		
		super( "Empty Binary Search Tree Exception" );
		
	}

} // end 
