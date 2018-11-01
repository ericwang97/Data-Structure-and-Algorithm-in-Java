package edu.cofc.csci230;


/**
 * Doubly Linked List Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class DoublyLinkedList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
    
    // instance variables
    private Node<AnyType> headNode = null;
    private Node<AnyType> tailNode = null;
    
    private int size = 0;
    
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) throws NullPointerException {
    	
    	if ( t == null ) throw new NullPointerException();
        
        addNode( new Node<AnyType>(t) );
        
    } // end add() method
    
    /**
     * 
     * implementation for public add(AnyType t) method
     * 
     * @param t
     * 
     */
    private void addNode(Node<AnyType> t) {
        
        if ( isEmpty() ) {
        	
        	headNode = tailNode = t;
        	
        } else { 
        	
        	Node<AnyType> node = getNode( size-1 );
        	node.setNextNode( t );
        	t.setPreviousNode( node );
        	
        	tailNode = t;
        	
        }
        
        size++;
        
    } // end addNode() method
    
    
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException, NullPointerException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {
    	
    	if ( t == null ) throw new NullPointerException();
        
        addNode( index, new Node<AnyType>(t) );
        
    } // end add() method
    
    /*
     * 
     * Implementation for public add(int index, AnyType t) method
     * 
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
        
        if ( index == 0 && !isEmpty() ) {
            
            t.setNextNode( headNode );
            headNode.setPreviousNode( t );
            headNode = t;
            size++;
            
        } else if ( index == 0 && isEmpty() ) { 
        	
        	t.setNextNode( headNode );
            headNode = tailNode = t;
            size++;
        	
        } else if ( index == size ) {
            
            addNode( t );
            
        } else {
        	
        	Node<AnyType> node = getNode( index );
        	
        	node.getPreviousNode().setNextNode( t );
        	t.setPreviousNode( node.getPreviousNode() );
        	node.setPreviousNode( t );
            t.setNextNode( node );
        
            size++;
            
        }
        
    } // end addNode() method
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException, NullPointerException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {

    	if ( t == null ) throw new NullPointerException();
    	
        setNode( index, new Node<AnyType>(t) );
        
    } // end set() method
    
    /**
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode( int index, Node<AnyType> t )  throws IndexOutOfBoundsException {
        
        getNode( index ).setData( t.getData() );
        
    } // end setNode() method
    
    
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
        
        return removeNode( index ).getData();
        
    } // end remove() method
    
    /**
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {
        
        
        Node<AnyType> node = getNode( index );
        
        if ( index == 0 ) {
            
            headNode = node.getNextNode();
            if ( headNode != null ) headNode.setPreviousNode( null );
            
        } else if ( index == ( size -1 ) ) {
        	
        	Node<AnyType> prev_node = node.getPreviousNode();
        	prev_node.setNextNode( null );
        	tailNode = prev_node;
        	
    	} else {
            
            Node<AnyType> prev_node = node.getPreviousNode();
            Node<AnyType> next_node = node.getNextNode();
            
            prev_node.setNextNode( next_node );
            next_node.setPreviousNode( prev_node );
            
        }
        
        node.setNextNode( null );
        node.setPreviousNode( null );
        
        size--;
        
        if ( isEmpty() ) clear();
        
        return node;
        
    } // end removeNode() method
    
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get( int index ) throws IndexOutOfBoundsException {
        
        return getNode( index ).getData();
        
    } // end get() method
    
    /**
     * 
     * Implementation of get(int index) method
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     * 
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
        
        /**
         * -------------------------------------------
         * 
         * Your implementation MUST do the following link traversals:
         * 
         * 1) If the index location is <= floor( size/2 ), start traversal from head node
         * 2) if the index location is > floor( size/2), start traversal from tail node
         * 
         * Your code will be reviewed by instructor to ensure the two conditions
         * are fully meet by your solution.
         * 
         */
        
        if ( index < 0 || index >= size ) {
            
            throw new IndexOutOfBoundsException();
            
        }
        
        Node<AnyType> node = null;
        
        if ( index <= Math.floor( ((double)size)/2.0 ) ) {
        	
        	node = headNode;
        	
        	for ( int i=1; i<=index; i++ ) {
                
                node = node.getNextNode();
                
            }
        	
        } else {
        	
        	node = tailNode;
        	
        	for ( int i=(size-1); i>index; i-- ) {
                
                node = node.getPreviousNode();
                
            }
        	
        }
        
        return node;
        
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
        
        return ( size == 0 ) ? true : false;
        
    } // end isEmpty() method
    
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
		 else if(i>j) {
			 int tmp = i;
			 i = j; j = tmp;
		 }
		 if(i!=j) {
			 Node<AnyType> i_node = getNode(i);
			 Node<AnyType> j_node = getNode(j);
			 Node<AnyType> i_next = i_node.getNextNode();
			 Node<AnyType> j_prev = j_node.getPreviousNode();
			 
			 if(i_node.getPreviousNode()!=null) {
				 i_node.getPreviousNode().setNextNode(j_node);
			 }
			 j_node.setPreviousNode(i_node.getPreviousNode());
			 i_node.setNextNode(j_node.getNextNode());
			 
			 if(j_node.getNextNode()!=null) {
				 j_node.getNextNode().setPreviousNode(i_node);
				 
			 }
			 if(i+1==j) {
				 j_node.setNextNode(i_node);
				 i_node.setPreviousNode(j_node);
				 
			 }
			 else {
				 j_node.setNextNode(i_next);
				 i_next.setPreviousNode(j_node);
				 i_node.setPreviousNode(j_prev);
				 j_prev.setNextNode(i_node);
			 }
			 if(i==0) {
				 headNode = j_node;
			 }
			 if(j==size-1) {
				 tailNode = i_node;
			 }
			 
		 }
		
		
		
	} // end swap() method
    
    
	/**
	 * 
	 * Do not modify
	 * 
	 * To help you debug your code
	 * 
	 */
    public void printList() {
    	
    	Node<AnyType> n = headNode;
    	
    	while ( n != null ) {
    		
    		System.out.println( n );
    		
    		n = n.getNextNode();
    		
    	}
    	
    } // end printlist()
    
    /**
     * Removes all of the elements from this list.
     * 
     */
    public void clear() {
        
        headNode = null;
        tailNode = null;
        size=0;
        
    } // end clear method
    
    
    /**
     * 
     * For debugging and testing purpose
     * 
     * !!! Do not remove or modify !!!
     * 
     */
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append( String.format( "Size=%d, A = [ ", size ) );
        
        if ( !isEmpty() ) {
            
            for ( int i=0; i<size-1; i++ ) {
                buffer.append( String.format( "%d, ", get(i) ) );    
            }
            
            buffer.append( String.format( "%d ]", get(size-1 ) ) );
            
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
                
        // -------------------------------------
        // Put your test cases here
        // -------------------------------------
        
        //DoublyLinkedList<Character> list = new DoublyLinkedList<Character>();
    	 //DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    	 DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
         
  	  list.add( -1 );
      list.add( 100 );
      list.add( 100 );
      list.add( -100 );
      list.add( 20 );
      list.add( 13 );
      list.add( 13 );
      //  list.add( 'a' );
       // list.add( 'b' );
       // list.add( 'b' );
       // list.add( 'a' );
       // list.add( 'c' );
       // list.add( 'f' );
        //list.add( 'A' );
    	//  list.add( "dsc" );
        // list.add( "abc" );
         //list.add( "ABC" );
        // list.add( "ABCd" );
        // list.add( "ABC" );
         //list.add( "sdc" );
        // list.add( "SDc" );
        // list.add( "Sdc" );
      
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
    
} // end DoublyLinkedList class definition