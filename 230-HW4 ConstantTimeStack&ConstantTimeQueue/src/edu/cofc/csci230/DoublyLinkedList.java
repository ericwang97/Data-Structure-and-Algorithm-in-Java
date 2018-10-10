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
            
            headNode = t;
            tailNode = headNode;
            
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
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
        
        if ( index == 0 && !isEmpty() ) {
            
            t.setNextNode( headNode );
            headNode.setPreviousNode( t );
            headNode = t;
            size++;
            
        } else if ( index == 0 && isEmpty() ) { 
            
            t.setNextNode( headNode );
            headNode = t;
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
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
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
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
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
        
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        
        System.out.println( list );
        
        list.add(1);
        list.add(2);
        list.add(3);
        
        list.remove( list.size() - 1 );
        
        System.out.println( list );
        
//        list.add(2);
//        list.add(3);
//        
//        System.out.println( list );
//        
//        list.remove( 2 );
//        
//        list.add( 2, 4 );
//        list.add( 3, 5 );
//        
//        System.out.println( list );
//        
//        list.remove( 2 );
//        list.remove( 0 );
//        
//        System.out.println( list );
        

                
    } // end main() method
    
} // end DoublyLinkedList class definition