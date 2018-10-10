package edu.cofc.csci230;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A FIFO stack that has constant time complexity O(1) for
 * all three queue interface methods (i.e., add, remove, and 
 * peek).
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class ConstantTimeQueue<AnyType extends Comparable<AnyType>> implements Queue<AnyType> {
	
	/**
	 * ------------------------------
	 * TODO:
	 * ------------------------------
	 * 
	 * Select and instantiate a new ArrayList or DoublyLinkedList
	 * that will achieve constant time performance
	 */
	
	// modify this line of code
	//The same, use DoublyLinkedList to achieve O(1) operation.
	
	private List<AnyType> list = new DoublyLinkedList<AnyType>();
	
	
	/**
	 * Inserts the specified element at the end of the queue in 
	 * constant time O(1)
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null 
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation.
         * 
         */
		if ( t == null ) throw new NullPointerException();
        
        list.add(t);
		
		
	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * constant time O(1).
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation. 
         * 
         *
         */
		if ( list.size() == 0 ) {
			 try{list.remove(list.size());}
		        catch( IndexOutOfBoundsException e2) {
		        }
		       
			throw new NoSuchElementException();
		}
        
		else{
			//System.out.println( list.size() );
			AnyType data = null; 
			data = list.get(0);
			list.remove(0);
	        
	        return(data);
	        }
	
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue, 
	 * or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation 
         * 
         */
		
        
		if (list.size() == 0 ) 
			return null;
		else
			return(list.get(0));
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		ConstantTimeQueue<Integer> queue = new ConstantTimeQueue<Integer>();
		 try{
	        	queue.remove();

	        }
	        catch(NoSuchElementException e1){
	        	System.out.println( " there's is an NoSuchElementException in Remove ");
	        	}
	        
	        try{
	        	System.out.println( "Peek when empty:  " + queue.peek() );
	        }
	        catch(NoSuchElementException e1){
	        	System.out.println( " there's is an NoSuchElementException in Peek ");
	        	}
	        
        System.out.println( "Begin to Add" );
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println( "Peek:  " + queue.peek() );
        
        System.out.println( "Begin to Remove" );
        System.out.println( "Remove the head:  " + queue.remove() );
        System.out.println( "Peek after Remove:  " + queue.peek() );
        

		
        try{
        	queue.add(null);
        }
        catch(NullPointerException e1){
        	System.out.println( " there's is an NullPointerException in Add ");
        	}
        
        try{
        	queue.remove();
        	queue.remove();
        	queue.remove();
        	queue.remove();
        }
        catch(NoSuchElementException e1){
        	System.out.println( " there's is an NoSuchElementException in Remove ");
        	}
        
        try{
        	System.out.println( "Peek when empty:  " + queue.peek() );
        }
        catch(NoSuchElementException e1){
        	System.out.println( " there's is an NoSuchElementException in Peek ");
        	}
        
        
	} // end main() method

} // end ConstantTimeQueue class definition

