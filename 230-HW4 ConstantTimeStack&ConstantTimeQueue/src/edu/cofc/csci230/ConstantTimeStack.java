package edu.cofc.csci230;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and 
 * peek).
 * 
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable<AnyType>> implements Stack<AnyType> {
	
	/**
	 * ------------------------------
	 * 
	 * ------------------------------
	 * 
	 * Select and instantiate a new ArrayList or DoublyLinkedList
	 * that will achieve constant time performance
	 */
	//Inheritance interface
	// modify this line of code
	//Use DoublyLinkedList to achieve O(1) operation.
	//Composition
	
	private List<AnyType> list = new DoublyLinkedList<AnyType>();
	    

	/**
	 * Pushes an item onto the top of this stack in constant 
	 * time O(1)
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(AnyType t) {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation
         * 
         */
		if(t != null) {list.add(t);}
		else{
			try{
				list.add(null);
	        }
	        catch(NullPointerException e1){
	        	//System.out.println( " there's is an NullPointerException in Push ");
	        	//System.out.println( " xxx ");
	        }
		}
		
		
		
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the 
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public AnyType pop() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your pop solution must be a constant 
         * time O(1) operation
         * 
         */
		if ( list.size() == 0 ) {
			 try{list.remove(list.size());}
		        catch( IndexOutOfBoundsException e2) {
		        }
		       
			throw new EmptyStackException();
		}
  
		else {
        
		AnyType data = null; 
		data = list.get(list.size()-1);
		list.remove(list.size()-1);
        
        return(data);
		}
		
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it 
	 * from the stack in constant time O(1)
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public AnyType peek() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your peek solution must be a constant 
         * time O(1) operation
         * 
         */
		if (list.size() == 0 ) throw new EmptyStackException();
        
        list.get(list.size()-1);
        
        return(list.get(list.size()-1));
		
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		
		ConstantTimeStack<Integer> stack = new ConstantTimeStack<Integer>();
		  try{
	        	stack.pop();
	        }
	        catch(EmptyStackException e1){
	        	System.out.println( " there's is an EmptyStackException in pop ");
	        	}
		  try{
	        	stack.peek();
	        }
	        catch(EmptyStackException e1){
	        	System.out.println( " there's is an EmptyStackException in Peek ");
	        	}
		  
        System.out.println( "Begin to Push" );
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println( "Peek:  " + stack.peek() );
        
        System.out.println( "Begin to Pop" );
        System.out.println( "Pop the end:  " + stack.pop() );
        stack.push(null);
        System.out.println( "Peek after Pop:  " + stack.peek() );
      
        
        try{
        	stack.push(null);
        }
        catch(NullPointerException e1){
        	System.out.println( " there's is an NullPointerException in Push ");
        	}
        
        try{
        	stack.pop();
        	stack.pop();
        	stack.pop();
        }
        catch(EmptyStackException e1){
        	System.out.println( " there's is an EmptyStackException in pop ");
        	}
        
        try{
        	stack.peek();
        }
        catch(EmptyStackException e1){
        	System.out.println( " there's is an EmptyStackException in Peek ");
        	}
		
	} // end main method

} // end ConstantTimeStack class definition
