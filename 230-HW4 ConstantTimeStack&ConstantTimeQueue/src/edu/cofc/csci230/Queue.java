package edu.cofc.csci230;

import java.util.NoSuchElementException;

/**
 * First In First Out (FIFO) Queue
 *
 * Queue interface that "closely" resembles the Queue interface
 * defined in the java.util package, see link below.
 * 
 * http://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public interface Queue<AnyType> {
	
	/**
	 * Inserts the specified element at the end the queue.
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null (queue does not permit null elements)
	 */
	public void add( AnyType t ) throws NullPointerException;
	
	/**
	 * Retrieves and removes the head of the queue.
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException;
	
	/**
	 * Retrieves, but does not remove, the head of the queue, or 
	 * returns null if the queue is empty.
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public AnyType peek();

} // end Queue interface description
