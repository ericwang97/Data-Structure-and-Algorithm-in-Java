package edu.cofc.csci230;

import static java.lang.Math.log;

/**
 * ArrayList Data Structure
 *
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 */
public class ArrayList<AnyType extends Comparable<AnyType>> implements List<AnyType> {

  // instance variables
  private AnyType[] array;
  private int size = 0;
  private int MINIMUM_CAPACITY = 10;
  private int capacity = MINIMUM_CAPACITY;

  /**
   * Constructs an empty list with an initial capacity (for this assignment initial capacity is 10 -
   * see constant instance variable)
   */
  public ArrayList() {

    array = (AnyType[]) new Comparable[capacity];

  } // end constructor

  /**
   * Do not modify this method. Only use for testing purposes.
   */
  public int getCapacity() {

    return capacity;

  } // end getCapacity() method

  /**
   * Appends the specified element to the end of this list.
   *
   * @param t - element to be inserted
   */
  public void add(AnyType t) {

    if (size >= capacity) {
      grow();
    }

    array[size] = t;
    size++;

  } // end add() method

  /**
   * Inserts the specified element at the specified position in this list.
   *
   * @param index - index at which the specified element is to be inserted
   * @param t - element to be inserted
   * @throws IndexOutOfBoundsException, NullPointerException
   */
  public void add(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {

    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (t == null) {
      throw new NullPointerException();
    }
    if (size >= capacity) {
      grow();
    }

    for (int i = size; i > index; i--) {
      array[i] = array[i - 1];
    }
    array[index] = t;
    size++;

  } // end add() method

  /**
   * Replaces the element at the specified position in this list with the specified element.
   *
   * @param index - index of the element to replace
   * @param t - element to be inserted
   * @throws IndexOutOfBoundsException, NullPointerException
   */
  public void set(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (t == null) {
      throw new NullPointerException();
    }

    array[index] = t;
  } // end set() method

  /**
   * Removes the element at the specified position in this list.
   *
   * @param index - index of the element to be removed
   */
  public AnyType remove(int index) throws IndexOutOfBoundsException {

    /**
     * 
     * Requirement - you must use loops (i.e. may not use
     * System.arraycopy, or any other array copy operation
     * available in the Java API) to perform left or right
     * shift operations
     *
     */
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    AnyType obj = array[index];

    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    size--;

    if (size <= (capacity / 2)) {
      shrink();
    }
    return obj;

  } // end remove() method

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index - index of the element to be returned
   */
  public AnyType get(int index) throws IndexOutOfBoundsException {

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    return array[index];
  } // end get() method

  /**
   * Returns the number of elements in this list.
   */
  public int size() {
	  
	 return size;

  } // end size() method

  /**
   * Returns true if this list contains no elements.
   */
  public Boolean isEmpty() {

    return (size == 0);

  } // end isEmpty() method


  /**
   * Removes all of the elements from this list and the capacity is reset to the MINIMUM_CAPACITY
   */
  public void clear() {

    size = 0;
    capacity = MINIMUM_CAPACITY;
    array = (AnyType[]) new Comparable[capacity];
  } // end clear method


  /**
   * Trims the capacity of this ArrayList instance to be the list's current size. An application can
   * use this operation to minimize the storage of an ArrayList instance.
   */
  public void trimToSize() {
	 
	int newCapacity = size;
	if(newCapacity < MINIMUM_CAPACITY)
		newCapacity = MINIMUM_CAPACITY;
	
	if(newCapacity != capacity) {
	    AnyType[] temp = (AnyType[]) new Comparable[newCapacity];
	
	    for (int i = 0; i < newCapacity; i++) {
	      temp[i] = array[i];
	    }
	    capacity = newCapacity;
	    array = temp;
	}

  } // end trimToSize() method
  


  /**
   * Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at
   * least the number of elements specified by the minimum capacity argument.
   *
   * @param minCapacity - the desired minimum capacity
   */
  public void ensureCapacity(int minCapacity) {
	  
	MINIMUM_CAPACITY = minCapacity;
	
	if(minCapacity > capacity) {
	    AnyType[] temp = (AnyType[]) new Comparable[minCapacity];
	    capacity = minCapacity;
	
	    for (int i = 0; i < size; i++) {
	      temp[i] = array[i];
	    }
	    array = temp;
	}
  } // end ensureCapacity() method


  /**
   * The capacity of the array is resized using this function:
   *
   * new capacity = old capacity + 20 * log( log( old capacity ) )
   *
   * where log() is the natural logarithm.
   */
  private void grow() {

    /**
     *
     * Requirement - you must use loops (i.e. may not use
     * System.arraycopy, or any other array copy operation
     * available in the Java API)
     *
     */
    int newCapacity = (int) (capacity + (20 * log(log(capacity))));
    AnyType[] temp = (AnyType[]) new Comparable[newCapacity];
    capacity = newCapacity;

    for (int i = 0; i < size; i++) {
      temp[i] = array[i];
    }
    array = temp;
  } // end grow() method


  /**
   * The capacity of the array is resized using this function:
   *
   * new capacity = old capacity / 2
   *
   * Note: the new capacity should never be < MINIMUM_CAPACITY
   */
  private void shrink() {

    /**
     *
     * Requirement - you must use loops (i.e. may not use
     * System.arraycopy, or any other array copy operation
     * available in the Java API)
     *
     */
    int newCapacity = MINIMUM_CAPACITY;

    if ((capacity / 2) >= MINIMUM_CAPACITY) {
      newCapacity = capacity / 2;
    }

    AnyType[] temp = (AnyType[]) new Comparable[newCapacity];
    capacity = newCapacity;

    for (int i = 0; i < size; i++) {
      temp[i] = array[i];
    }
    array = temp;
  } // end shrink() method
  
  /**
	 * swaps to elements in a list at index 
	 * position i and j.
	 * 
	 * For example, 
	 * 	if A = 1->2->3->4->5 and swap( 1, 3 ) is executed
	 * 	then A = 1->4->3->2->5
	 *
	 * @param i
	 * @param j
	 * @throws IndexOutOfBoundsException
	 */
	public void swap( int i, int j )  throws IndexOutOfBoundsException {
		
		/**
		 * -------------------------------------------
		 * TODO: You fully implement this method
		 * 
		 */
	    if (i < 0 || i >= size || j < 0 || j >= size) {
	        throw new IndexOutOfBoundsException();
	      }
	    else {
		AnyType tmp = null;
		tmp = array[j];
		array[j]=array[i];
		array[i]=tmp;
	    }
		
		
	} // end swap() method


  /**
   * For debugging purposes :)
   *
   * Note: this only works for integer values hence, the %d format specifier in the string format
   * method. If you want a different specifier, like string %s, you can change.
   */
  public String toString() {

    StringBuffer buffer = new StringBuffer();

    buffer.append(String.format("Size=%d, A = [ ", size));

    if (!isEmpty()) {

      for (int i = 0; i < size - 1; i++) {
        buffer.append(String.format("%d, ", array[i]));
      }

      buffer.append(String.format("%d ]", array[size - 1]));

    } else {

      buffer.append("] ");
    }

    return buffer.toString();

  } // end toString()


  /**
   *
   * @param args
   */
  public static void main(String[] args) {

    /**
     * -------------------------------------------
     * TODO: Put your test cases here
     *
     */
	  
	  ArrayList<Integer> list = new ArrayList<Integer>();
	  
	  list.add( -1 );
      list.add( 100 );
      list.add( 100 );
      list.add( -100 );
      list.add( 20 );
      list.add( 13 );
      list.add( 13 );
      
      System.out.println( list );
      list.swap(3,1);
      System.out.println( list);
      
      list.swap(1,1);
      System.out.println( list);
      
      try{list.swap(-1,3);}
      catch(IndexOutOfBoundsException e1)
      {System.out.println( " there's is an IndexOutOfBoundsException in Swap ");}
      
      try{list.swap(0,list.size());}
      catch(IndexOutOfBoundsException e1)
      {System.out.println( " there's is an IndexOutOfBoundsException in Swap ");}
      
      
      System.out.println( "----------------------");
      System.out.println( "Start Bubble Sorting");

      Utils.ascending = true; // sort in ascending order
      
      Utils.bubbleSort( list );
      
      Utils.ascending = false; // sort in descending order
      
      try {
      	 Utils.bubbleSort( list );
       }
       catch(IndexOutOfBoundsException e1){
      	 System.out.println( "IndexOutOfBoundsException in bubbleSort");
  	 }
      
      System.out.println( "----------------------");
      System.out.println( "Start Selection Sorting");

      Utils.ascending = true; // sort in ascending order
      
      Utils.selectionSort( list );
      
      Utils.ascending = false; // sort in descending order
      
      try {
     	 Utils.selectionSort( list );
      }
      catch(IndexOutOfBoundsException e1){
     	 System.out.println( "IndexOutOfBoundsException in selectionSort");
 	 }

      
      System.out.println( "----------------------");
      System.out.println( "Start insertion Sorting");

      Utils.ascending = true; // sort in ascending order
      
      Utils.insertionSort( list );
      
      Utils.ascending = false; // sort in descending order
      
     try {
    	 Utils.insertionSort( list );
     }
     catch(IndexOutOfBoundsException e1){
    	 System.out.println( "IndexOutOfBoundsException in insertionSort");
	 }


	  
  } // end main() method

} // end ArrayList class definition