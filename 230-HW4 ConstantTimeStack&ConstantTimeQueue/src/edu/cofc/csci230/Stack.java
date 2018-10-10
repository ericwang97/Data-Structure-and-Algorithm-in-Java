package edu.cofc.csci230;

import java.util.EmptyStackException;

/**
 * Last in First Out (LIFO) Stack
 *
 * Stack interface that "closely" resembles the Stack class
 * defined in the java.util package, see link below.
 * 
 * http://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public interface Stack<AnyType> {
	
	/**
	 * Pushes an item onto the top of the stack.
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push( AnyType t );
	
	/**
	 * Removes the object at the top of the stack and returns the 
	 * item
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public AnyType pop() throws EmptyStackException;
	
	/**
	 * Looks at the item at the top of the stack without removing it 
	 * from the stack.
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public AnyType peek() throws EmptyStackException;

} // end Stack interface description
