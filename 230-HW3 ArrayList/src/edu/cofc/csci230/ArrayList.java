package edu.cofc.csci230;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
     
    // instance variables
    private AnyType[] array;
    private int size = 0;
    private static int MINIMUM_CAPACITY = 10;
    private int capacity = MINIMUM_CAPACITY;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
        
        array = (AnyType[]) new Comparable[ capacity ];
        
    } // end constructor
    
    /**
     * Do not modify this method.
     * Only use for testing purposes.
     * 
     * @return
     */
    public int getCapacity() {
        
        return capacity;
        
    } // end getCapacity() method
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t - element to be inserted
     */
    public void add( AnyType t) {
         
        if ( size >= capacity )
            grow();
        
        array[size]=t;
        size++;
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index  - index at which the specified element is to be inserted
     * @param t - element to be inserted
     * @throws IndexOutOfBoundsException, NullPointerException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	if ( t == null ) throw new NullPointerException();
    	else if (index > size || index < 0) throw new IndexOutOfBoundsException();    
    	
    	else if(index == size){
    		add(t);
    	}
    	
    	else {
    		ensureCapacity(capacity);
            for(int i=size; i>=index+1; i--) {//腾出一个空位，从后往前移，前一个代替后一个
            	array[i] = array[i-1];
            }
            array[index]=t;

            size++;	

    	}


    } // end add() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index - index of the element to replace
     * @param t - element to be inserted
     * @throws IndexOutOfBoundsException, NullPointerException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	if ( t == null ) throw new NullPointerException();
    	else if (index >= size || index < 0) throw new IndexOutOfBoundsException();    
    	
    	else {
    		array[index]=t;
    	}

    } // end set() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index - index of the element to be removed
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API) to perform left or right
         * shift operations
         * 
         */
    	AnyType t = null;
    	if (index >= size || index < 0) throw new IndexOutOfBoundsException();    
    	
    	else {
    		ensureCapacity(capacity);
    		t = array[index];
            for(int i=index+1; i<=size; i++) {//减小一个空位，从前到后，后一个代替前一个
            	array[i-1] = array[i];
            }           
            size--;	
    	}
    	return (t);

         
    } // end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index - index of the element to be returned
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	if (index >= size || index < 0) throw new IndexOutOfBoundsException();            
      	 
	   	return(array[index]); 

    } // end get() method
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list and 
     * the capacity is reset to the MINIMUM_CAPACITY
     * 
     */
    public void clear() {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        capacity = MINIMUM_CAPACITY; 
    	array = (AnyType[]) new Comparable[ capacity ];
    	size = 0;
            
        
    } // end clear method
    
    
    /**
     * 
     * Trims the capacity of this ArrayList instance to be the list's current size. 
     * An application can use this operation to minimize the storage of an ArrayList 
     * instance.
     * 
     */
    public void trimToSize() {
        
         /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	capacity = size;
    	AnyType[] newarray = (AnyType[]) new Comparable[ capacity ];
        newarray = array;
 
    } // end trimToSize() method
    
    
    /**
     * 
     * Increases the capacity of this ArrayList instance, if necessary, to ensure 
     * that it can hold at least the number of elements specified by the minimum 
     * capacity argument.
     * 
     * @param minCapacity - the desired minimum capacity
     */
    public void ensureCapacity( int minCapacity ) {
        
         /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        if ( size >= capacity ) 
        	grow();
        
    } // end ensureCapacity() method
    
    
    /**
     * The capacity of the array is resized using this function:
     * 
     * new capacity = old capacity + 20 * log( log( old capacity ) )
     * 
     * where log() is the natural logarithm.
     * 
     */
    private void grow() {
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
   	
    	capacity = (int)Math.floor( capacity + 20 * Math.log(Math.log(capacity )));
     	AnyType[] newarray = (AnyType[]) new Comparable[ capacity ];
        
    	for(int i= 0; i<=size-1; i++) {
    		newarray[i] = array[i];
        }
    	array = newarray;
        
        
    } // end grow() method
    
    
    /**
     * The capacity of the array is resized using this function:
     * 
     * new capacity = old capacity / 2
     * 
     * Note: the new capacity should never be < MINIMUM_CAPACITY
     * 
     */
    private void shrink() {
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
    	if(((int)Math.floor( capacity/2 )>size) && ((int)Math.floor( capacity/2 )>=MINIMUM_CAPACITY)) {
    		capacity = (int)Math.floor( capacity/2 );
        	AnyType[] newarray = (AnyType[]) new Comparable[ capacity ];
        	if(capacity >= MINIMUM_CAPACITY) {
        		for(int i=0; i<=size-1; i++) {
            		newarray[i] = array[i];
            	}
        	}
        	else {
        		System.out.println( "Shrink is failed because Size is greater than Capacity/2" );
        	}
    	}
    	
    } // end shrink() method
    
    
    /**
     * For debugging purposes :)
     * 
     * Note: this only works for integer values 
     * hence, the %d format specifier in the 
     * string format method. If you want a 
     * different specifier, like string %s, 
     * you can change.
     * 
     */
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append( String.format( "Size=%d, A = [ ", size ) );
        
        if ( !isEmpty() ) {
            
            for ( int i=0; i<size-1; i++ ) {
                buffer.append( String.format( "%d, ", array[i] ) );    
            }
            
            buffer.append( String.format( "%d ]", array[size-1] ) );
            
        } else {
            
            buffer.append( "] " );
        }
        
        return buffer.toString();
        
    } // end toString()
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         
        /**
         * -------------------------------------------
         * TODO: Put your test cases here
         * 
         */
    	 ArrayList<Integer> list = new ArrayList<Integer>();
         System.out.println("the Original list is:  " + list );
         
         System.out.println( "Begin to test initialization" );
         System.out.println( "the original capacity of list is:  " + list.getCapacity() );//test: getCapacity;
         //list.shrink();
         //System.out.println( "the new capacity of list is:  " + list.getCapacity() );//test: shrink;
         System.out.println( "---------------------------------------" );
         
         System.out.println( "Begin to Add" );
         list.add(0);//test: add(index,t)
         list.add(1);
         list.add(2,222);
         list.add(3,333);
         list.add(4,444);
         list.add(5,555);
         list.add(6,666);
         list.add(7,777);
         list.add(888);
         list.add(5,-55);
         list.add(7,-77);
         list.add(list.size(),6666666);
         System.out.println( "the First list is:  " + list );
         System.out.println( "the new capacity of list is:  " + list.getCapacity() );//test: grow;
         
         list.shrink();
         System.out.println( "the new capacity of list after shrink is:  " + list.getCapacity() );//test: grow;
         list.trimToSize();
         System.out.println( "the new capacity of list after trimTosize is:  " + list.getCapacity() );
         System.out.println( "---------------------------------------" );
         
         list.add(7,-7799);
         list.add(8,-8899);
         list.add(-100000);
         list.add(-111111);
         System.out.println( "the Second list is:  " + list );
         System.out.println( "the new capacity of list is:  " + list.getCapacity() );//test: grow;
         
         list.shrink();
         System.out.println( "the new capacity of list after shrink is:  " + list.getCapacity() );//test: grow;
         System.out.println( "Shrink is failed because Size is greater than Capacity/2" );
     	
         
         //list.trimToSize();
         //System.out.println( "the new capacity of list after trimTosize is:  " + list.getCapacity() );
         System.out.println( "Add, Shrink and trimTosize method has no problems" );
         System.out.println( "---------------------------------------" );
         
         System.out.println( "Begin to Get" );
         System.out.println( "the First Element is:  " +list.get(0) );
         System.out.println( "the 5th Element is:  " +list.get(4) );
         System.out.println( "the Last Element is:  " +list.get(list.size()-1));
         System.out.println( "Get method has no problems" );
         System.out.println( "---------------------------------------" );
         
         System.out.println( "Begin to Set" );
         list.set(0,-9999);
         System.out.println( "the First Element was changed to -9999" );
         System.out.println( "the new list is: " +list );
         list.set(2,-100);
         System.out.println( "the Third Element was changed to -100" );
         System.out.println( "the new list is: " +list );
         list.set( list.size()-1, -333333 );
         System.out.println( "the Last Element was changed to -333333" );
         System.out.println( "the new list is: " +list );
         System.out.println( "Set method has no problems" );
         System.out.println( "---------------------------------------" );
         
         System.out.println( "Begin to Remove" );
         System.out.println( "the 3rd one was removed：" + list.remove( 2 ));
         System.out.println( "the list after removing is:  " +list );
         System.out.println( "the first one was removed：" + list.remove( 0 ));
         System.out.println( "the list after removing is:  " +list );
         System.out.println( "the last one was removed：" + list.remove( list.size()-1 ));
         System.out.println( "the list after removing is:  " +list );
         System.out.println( "the new capacity of list is:  " + list.getCapacity() );
         System.out.println( "Remove method has no problems" );
         System.out.println( "---------------------------------------" );
         
         System.out.println( "Begin to Exception checking" );
         try{list.add(-1,0);}
         catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Add ");}
         try{list.add(list.size()+1,0);}
         catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Add ");}
         
         try{list.add(2,null);}
         catch( NullPointerException e2) {System.out.println( "there's is an  NullPointerException in Add ");}
         
         
         try{list.get(-1);}
         catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Get ");}
         try{list.get(list.size());}
         catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Get ");}
         
         try{list.set(-1,0);}
         catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Set ");}
         try{list.set(list.size(),0);}
         catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Set ");}
         try{list.set(1,null);}
         catch(NullPointerException e1){System.out.println( " there's is an NullPointerException in Set ");}
         
         try{list.remove(-1);}
         catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Remove ");}
         try{list.remove(list.size());}
         catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Remove ");}
         
         System.out.println( "---------------------------------------" );
         
         System.out.println( "Begin to Clear" );
         list.clear();
         System.out.println( list );
         System.out.println( "the original capacity of list is:  " + list.getCapacity() );
         list.trimToSize();
         System.out.println( "the capacity of list after trimTosize is:  " +list.getCapacity() );
         System.out.println( "---------------------------------------" );
         
         try{
             list.remove(0);}
             catch(IndexOutOfBoundsException e3){System.out.println( " there's is an IndexOutOfBoundsException becuase there's no element inside the list ");}

             try{
                 list.set(0,0);}
                 catch(IndexOutOfBoundsException e3){System.out.println( " there's is an IndexOutOfBoundsException becuase there's no element inside the list ");}
             
             try{
                 list.get(0);}
                 catch(IndexOutOfBoundsException e3){System.out.println( " there's is an IndexOutOfBoundsException becuase there's no element inside the list ");}

             try{list.set(1,null);}
             catch(NullPointerException e1){System.out.println( " there's is an NullPointerException in Set ");}
             
             try{list.add(2,null);}
             catch( NullPointerException e2) {System.out.println( "there's is an  NullPointerException in Add ");}
            


//3,trimTosize应该是最后再用？grow是每次要用到的时候就用？
//  grow和ensureCapacity和shrink等之类的关系？shrink是大于两倍时候用？（不能大于等于，否则就相当于trimtosize了？）
             

         
         
    } // end main() method
  
} // end ArrayList class definition
