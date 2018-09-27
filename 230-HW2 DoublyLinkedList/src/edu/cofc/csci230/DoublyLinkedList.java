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
     * Implementation for public add(AnyType t) method
     * 
     * I did this one for you :)
     * 
     * @param t
     * 
     */
    private void addNode(Node<AnyType> t) {
        
        if ( isEmpty() ) {
        	
        	headNode = t;//这里t其实是一个node!!!也就是说t是head也是tail，并且还是空的
        	tailNode = headNode;
        	
        } else { 
        	
        	Node<AnyType> node = getNode( size-1 );
        	node.setNextNode( t );
        	t.setPreviousNode( node );
        	
        	tailNode = t;//
        	
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
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * 
         */
    	if (index > size || index < 0) throw new IndexOutOfBoundsException();   
    	 
    	else if (index == 0) {
    		 t.setNextNode(headNode);
    		 headNode = t;
    		 size++; 
    	 }
    	 else if (index == size) {
    		Node<AnyType> node = tailNode;
         	node.setNextNode( t );
         	t.setPreviousNode( node );
         	
         	tailNode = t;//
         	size++; 
    	 }

	   	 else { 
	   		 
	   		Node<AnyType> next = getNode(index); 		
   	   		Node<AnyType> prev = getNode(index-1);
   	   		next.setPreviousNode(t);
   	   		prev.setNextNode(t);
   	   		t.setNextNode(next);
   	   		t.setPreviousNode(prev);
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
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */        
    	 if (index >= size || index < 0) throw new IndexOutOfBoundsException();   
    	 else {
    		 
	   	if(index == size-1) {
		   		Node<AnyType> prev = getNode(index-1);
		   		tailNode = t;
		   		t.setPreviousNode(prev);
		   		prev.setNextNode(t);
		   	}
		   	else if(index == 0) {
		   		Node<AnyType> next = getNode(index+1);
		   		headNode = t;
		   		next.setPreviousNode(t); 
		   		t.setNextNode(next);
		   	}
			else { 
		   		 
		   		Node<AnyType> prev = getNode(index-1);
		   		Node<AnyType> next = getNode(index+1);
		   		prev.setNextNode(t);
		   		next.setPreviousNode(t); 
		   		t.setNextNode(next);
		   		t.setPreviousNode(prev);
		   	 }  
    	 } 
    } // end setNode() method
    
    
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
        
        return removeNode( index ).getData();//要把remove的Node的值也输出出来，不然咋知道删了什么
        
    } // end remove() method
    
    /**
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	 if (index >= size || size < 0) throw new IndexOutOfBoundsException();            
   	 
	   	 else { 
	   		 
	   		Node<AnyType> node = null; 
	   		
	   		if(index == 0) {
	   			node = headNode;
	   			headNode = node.getNextNode();
	   			size--;
	   		}
	   		else if(index == (size-1)) {
	   			node = tailNode;
	   			tailNode = node.getPreviousNode();
	   			size--;
	   		}
	   		else {
	   			node = getNode(index);
	   	   		Node<AnyType> prev = node.getPreviousNode();
	   	   		Node<AnyType> next = node.getNextNode();
	   	   		prev.setNextNode(next);
	   	   		next.setPreviousNode(prev);       
	   		    size--;       
	   		}  		 
	   		return node; 	
	   	 }       
	    	    
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
         * TODO: You fully implement this method
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
    	 if (index >= size || index < 0) throw new IndexOutOfBoundsException();   
      	 
      	 else { 
           	      		
            Node<AnyType> currentNode = null;
            
            if (index == 0) {
                currentNode = headNode;
            }            
            else {                
                if(index <= Math.floor(size/2)) {
                	int i = 0;
                	Node<AnyType> node = headNode;
                	while (i <= index) {
                        if (node != null) {
                            currentNode = node;
                            node = node.getNextNode();
                        }
                        i++;	
                	}
                }
                else {
                	int i = (size-1);
                	Node<AnyType> node = tailNode;
                	while (i >= index) {                		
                        if (node != null) {
                            currentNode = node;
                            node = node.getPreviousNode();
                        }
                        i--;	
                	}
                }
            }        
            return currentNode;    
      	 }
 
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
     * Removes all of the elements from this list.
     * 
     */
    public void clear() {
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */ 
        headNode = null;
        tailNode = null;
        size = 0;       

        
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
        // Add: [ 1, 2, 10333, 3, 99, 6 ];
    	// Get: Any two of them;
    	// Set: the 3rd one = 100;
    	// Remove: the first one, last one and the 3rd one;
       	// Clear();
        // -------------------------------------
        
        List<Integer> list = new DoublyLinkedList<Integer>();//为何不cast
    	//List <Integer> list = new ArrayList<Integer>();
    	
    	//DoublyLinkedList list = new DoublyLinkedList();//为何不可以任意type都加在一起？？

        System.out.println("the Original list is:  " + list );
        
        System.out.println( "Begin to Add" );
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2,10333);
        System.out.println( "the First list is:  " + list );
        list.add(list.size(),6);
        list.add(4,99);
        
        //list.add(4,'c');//为何不可以任意type都加在一起？？
        
        System.out.println( "the Second list is:  " +list );
        System.out.println( "Add method has no problems" );
        
        
        
        System.out.println( "Begin to Get" );
        System.out.println( "the First Element is:  " +list.get(0) );
        System.out.println( "the 5th Element is:  " +list.get(4) );
        System.out.println( "the Last Element is:  " +list.get(list.size()-1));
        System.out.println( "Get method has no problems" );
        
        
        
        System.out.println( "Begin to Set" );
        list.set(0,6666);
        System.out.println( "the First Element was changed to 6666" );
        System.out.println( "the new list is: " +list );
        list.set(2,100);
        System.out.println( "the Third Element was changed to 100" );
        System.out.println( "the new list is: " +list );
        list.set( list.size()-1, 333333 );
        System.out.println( "the Last Element was changed to 333333" );
        System.out.println( "the new list is: " +list );
        System.out.println( "Set method has no problems" );
        
        
        
        System.out.println( "Begin to Remove" );
        System.out.println( "the 3rd one was removed：" + list.remove( 2 ));
        System.out.println( "the list after removing is:  " +list );
        System.out.println( "the first one was removed：" + list.remove( 0 ));
        System.out.println( "the list after removing is:  " +list );
        System.out.println( "the last one was removed：" + list.remove( list.size()-1 ));
        System.out.println( "the list after removing is:  " +list );
        System.out.println( "Remove method has no problems" );
        
        System.out.println( "Begin to Exception checking" );
        
        try{list.add(-1,0);}
        catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Add ");}
        try{list.add(list.size()+1,0);}
        catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Add ");}
        
        try{list.get(-1);}
        catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Get ");}
        try{list.get(list.size());}
        catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Get ");}
        
        try{list.set(-1,0);}
        catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Set ");}
        try{list.set(list.size(),0);}
        catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Set ");}
    
        try{list.remove(-1);}
        catch(IndexOutOfBoundsException e1){System.out.println( " there's is an IndexOutOfBoundsException in Remove ");}
        try{list.remove(list.size());}
        catch( IndexOutOfBoundsException e2) {System.out.println( "there's is an  IndexOutOfBoundsException in Remove ");}
        
        System.out.println( "Begin to Clear" );
        list.clear();
        System.out.println( list );
        
        try{
        list.remove(0);}
        catch(IndexOutOfBoundsException e3){System.out.println( " there's is an IndexOutOfBoundsException becuase there's no element inside the list ");}

        try{
            list.set(0,0);}
            catch(IndexOutOfBoundsException e3){System.out.println( " there's is an IndexOutOfBoundsException becuase there's no element inside the list ");}
        
        try{
            list.get(0);}
            catch(IndexOutOfBoundsException e3){System.out.println( " there's is an IndexOutOfBoundsException becuase there's no element inside the list ");}




                
    } // end main() method
    
} // end DoublyLinkedList class definition