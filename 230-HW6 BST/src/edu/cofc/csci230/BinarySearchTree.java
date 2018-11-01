package edu.cofc.csci230;

/**
 * 
 * Binary search that does not allow two (or more) binary nodes 
 * in the search tree to have the same element value.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 * @param <AnyType>
 */
public class BinarySearchTree <AnyType extends Comparable<AnyType>> {
	
	// --------------------------------------
	// instance variable
	private BinaryNode<AnyType> root;
	
	/**
	 *
	 * Constructor with one parameter that
	 * sets the root node of the BST.
	 * 
	 * @param rootElement
	 * @throws NullBinaryNodeException
	 */
	public BinarySearchTree( AnyType rootElement ) throws NullBinaryNodeException {
		
		if ( rootElement == null ) {
			throw new NullBinaryNodeException();
		}
		
		this.root = new BinaryNode<AnyType>( rootElement ) ;
		
	} // end constructor
	
	/**
	 * If the BST does not have a root node, then it is empty. 
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		
		return ( root == null );
		
	} // end isEmpty() method
	
	/**
	 * Make the BST empty, i.e. a BST that has 
	 * no nodes (including a root node).
	 * 
	 */
	public void clear() {
		
		root = null;
		
	} // end clear() method
	
	/**
	 * Method that inserts a new node with the specified element 
	 * value in the BST.
	 * 
	 * This method has one parameter:
	 *  1) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param element
	 * @throws DuplicateElementException
	 * @throws NullBinaryNodeException
	 */
	public void insert( AnyType element ) throws NullBinaryNodeException, DuplicateElementException {
		
		if ( element == null )
			throw new NullBinaryNodeException();
		
		if ( root == null )
			this.root = new BinaryNode<AnyType>( element );
		else
			insert( root, element );

	} // end insert() method
	
	/**
	 * Private recursive method that inserts a new node (with the 
	 * specified element value) in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param node
	 * @param element
	 * @throws DuplicateElementException
	 */
	private void insert( BinaryNode<AnyType> node, AnyType element )  throws DuplicateElementException {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */ 
		  BinaryNode<AnyType> insertnode = new BinaryNode<AnyType>( element );
		  
		  // base case: empty tree or end of a leaf	  
	      // base case: duplicate node, so throw exception
		  
	      if (element.compareTo(node.getElement()) == 0) {
	    	  throw new DuplicateElementException();
	      }
	      else if (element.compareTo(node.getElement()) < 0) {
	         if(node.getLeft() == null) {
	        	 node.setLeft(insertnode);
	         	insertnode.setParent(node);
	         	
	         }
	         else 
	        	 insert(node.getLeft(), element);
	      }
	      else if(element.compareTo(node.getElement()) > 0) {
	    	  if(node.getRight() == null) {
	    		  node.setRight(insertnode);
	    	  	insertnode.setParent(node);
	    	  }
	    	  else 
	    		  insert(node.getRight(), element);
	      }
	   }
		
		
//		//BinaryNode<AnyType> insertnode = new BinaryNode<AnyType>( element );
//
//		//BinaryNode<AnyType> currentNode = node;
//	//	BinaryNode<AnyType> parentNode = null;
//      //  while(true){
//      //      parentNode=currentNode;
//            
//       //     if(element.compareTo(currentNode.getElement())<0){
//       //         currentNode=currentNode.getLeft();
//       //         if(currentNode==null){
//                	////currentNode = insertnode;
//       //         	parentNode.setLeft(insertnode);
//        //        	insertnode.setParent(parentNode);
//        //            return;
//       //         }
//       //     }
//        //    else if(element.compareTo(currentNode.getElement())==0){
//        //    	throw new DuplicateElementException(); 
//        //        }
//        //    else if(element.compareTo(currentNode.getElement())>0){
//         //   	currentNode=currentNode.getRight();
//     //           if(currentNode==null){
//                	////currentNode = insertnode;
//      //          	parentNode.setRight(insertnode);
//      //          	insertnode.setParent(parentNode);
//      //              return;
//      //          }
//      //      }
//            
//      //  }
//     //}
//    
//	 // end insert() overloaded method
	
	/**
	 * Method that determines if a node with the specified element value 
	 * exists in the BST. 
	 * 
	 * This method has one parameter:
	 *  1) The element value that is being searched.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @param element
	 * @throws EmptyBSTException
	 * @throws NullBinaryNodeException
	 * @return
	 */
	public boolean search( AnyType element ) throws NullBinaryNodeException, EmptyBSTException {
		
		if ( element == null )
			throw new NullBinaryNodeException();
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return search( root, element );
		
	} // end search() method
	
	/**
	 * Private recursive method that determines if the element is 
	 * currently stored in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being searched.
	 *  
	 *  Hint: use the compareTo() method
	 * 
	 * @param element
	 * @param node
	 * @return
	 */
	private boolean search( BinaryNode<AnyType> node, AnyType element ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
            if(node==null){
                return false;
            }
            else {
            	if(element.compareTo(node.getElement())==0) {
            		return true;
            	}
            	else if(element.compareTo(node.getElement())<0){
    				return search(node.getLeft(),element);		
                }else{
                	return search(node.getRight(),element);       	
                }   	
            }        
        }

  //  public boolean search( BinaryNode<AnyType> node, AnyType element){
   //     while(element.compareTo(node.getElement())!=0){
    //        if(element.compareTo(node.getElement())<0){
    //            node=node.getLeft();
    //        }else{
     //           node=node.getRight();
     //       }
     //       if(node==null){
     //           return false;
     //       }
     //   }
     //   return true;
   // }


	// end search() overloaded method
	
	/**
	 * Find the node with the minimum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType min() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return min( root ).getElement();
		
	} // end findMin() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the minimum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> min( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
		 if (node.getLeft() == null) {
	         return node;
	      }
	      // if not, keep looking on the Left
	      else {
	         return min(node.getLeft());
	      }
		
	} // end min() method
	
	/**
	 * Find the node with the maximum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType max() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return max( root ).getElement();
		
	} // end max() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the maximum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> max( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		 if (node.getRight() == null) {
	         return node;
	      }
	      // if not, keep looking on the right
	      else {
	         return max(node.getRight());
	      }
		 
		 
		 
		//BinaryNode<AnyType> parentNode = null;
       // while(node!=null){
       //     parentNode = node;
       //     node = node.getRight();
       // }
       // return parentNode;


		
	} // end max() method

	/**
	 * Delete the node with the specified element value in the BST.
	 * 
	 * This method has one parameter:
	 * 	1) the element value to be deleted
	 * 
	 * This method performs the following delete operations
	 * 	1) delete node with no children (case 1)
	 * 	2) delete node with one child (case 2)
	 * 	3) delete node with two children (case 3)
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * If the element is null, throw a null binary node 
	 * exception
	 *  
	 * @param element
	 * @throws EmptyBSTException
	 * @throws NullBinaryNodeException
	 */
	public AnyType delete( AnyType element ) throws EmptyBSTException, NullBinaryNodeException {
	
	//public void delete( AnyType element ) throws EmptyBSTException, NullBinaryNodeException {
		
		if ( element == null )
			throw new NullBinaryNodeException();
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		//delete( root, element );
		return delete( root, element ).getElement();
		
	} // end delete() method


	/**
	 * Private recursive method that walk the BST looking for 
	 * the specified element value to be removed.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being removed.
	 *  
	 * @param node
	 * @param element
	 */
	private BinaryNode<AnyType> delete( BinaryNode<AnyType> node, AnyType element ) {
	//private void delete( BinaryNode<AnyType> node, AnyType element ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */	

		BinaryNode<AnyType> nullnode = new BinaryNode<AnyType>( null );
		if(search(root,element) == false) {
			return nullnode;
		}

		//node is not in the BST

		else {
			BinaryNode<AnyType> tmp = new BinaryNode<AnyType>( element );
		
			if(element.compareTo(node.getElement())==0){
				
				// Case1: node with no leaf nodes, directly delete it.
				if(node.getLeft() == null && node.getRight() == null) {
					tmp = node;
					if(node.getParent()!=null) {
						if(element.compareTo(node.getParent().getElement())<0)
							node.getParent().setLeft(null); 
						else  //node is on the right of parents
							node.getParent().setRight(null); 	
					}
					else
					//which will be the root, the only root;
						
						root = null;
				}
				
				else if(node.getLeft() == null && node.getRight() != null) {
				// Case2.1: node with one node (no left node)
					tmp = node;
					if(node.getParent()!=null) {
					// Case2.1.1: not the root node.
						if(element.compareTo(node.getParent().getElement())<0) { 
						// Case2.1.1.1:
							node.getParent().setLeft(node.getRight()); 
							node.getRight().setParent(node.getParent());
						}
						
						else {
						// Case2.1.1.2:
							node.getParent().setRight(node.getRight()); 
							node.getRight().setParent(node.getParent());
						}
					}
					else {
					// Case2.1.2: which is the root node, reassign the root
						
						node.getRight().setParent(null);
						root = node.getRight();
						node.setRight(null);
					}
						
				} 
				
				
				else if(node.getRight() == null && node.getLeft() != null) {
				// Case2.2: node with one (left) node (no right node),delete left child
					tmp = node;
					if(node.getParent()!=null) {
						if(element.compareTo(node.getParent().getElement())<0) {
							node.getParent().setLeft(node.getLeft()); 
							node.getLeft().setParent(node.getParent());
						}
						else {
							node.getParent().setRight(node.getLeft()); 
							node.getLeft().setParent(node.getParent());
						}
					}
					
					else {
						
						node.getLeft().setParent(null);
						root = node.getLeft();
						node.setLeft(null);
					}
				} 	
				
				// Case3: node with two nodes 
				//find Min in right subtree and assignment	
				//delete it, use the method of either case1 or case2
				else   {
					tmp = node;
					BinaryNode<AnyType>  minNodeForRight = min(node.getRight());
					node.setElement(minNodeForRight.getElement());	
					delete(node.getRight(),minNodeForRight.getElement()); 
				
				}
			}		
			else {
				if(element.compareTo(node.getElement())<0) {	
					delete(node.getLeft(), element);						
				} 
				else if(element.compareTo(node.getElement())> 0) {
					delete(node.getRight(), element);	
				}
			}
	
			return tmp;
			}	

	}
		
	 // end delete() method

	/**
	 * Recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an pre-order 
	 * tree traversal format.
	 * 
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	2,1,3
	 * Hint: you may want to use regular expressions
	 * 
	 * Discussed in class, please review 
	 * your notes
	 * 
	 * If the BST is empty, throw an empty binary search 
	 * tree exception
	 * 
	 * @throws EmptyBSTException 
	 * @return 
	 * 
	 */
	public String preOrder() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return preOrder( root );
		
	} // end preOrder() method
	
	/**
	 * Private recursive method that traverses the BST 
	 * dynamically creating a string with the
	 * element values stored in an pre-order 
	 * tree traversal format. 
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *  
	 * @param node
	 * @return
	 * 
	 */
	private String preOrder( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution MUST USE recursion
		 * 
		 */
		String displayNodes = "";
		if(node == null)
			return "";
		if(node!=null){
			
			displayNodes = displayNodes + node.toString() +  ",";
	        displayNodes = displayNodes + preOrder(node.getLeft()) ;
	        displayNodes = displayNodes + preOrder(node.getRight()) ;
//	    	if(node==null){
//				return null;
//			}
        }
		return displayNodes;
	
			


	} // end preOrder() method

	
	/**
	 * 
	 * ------------------------------------
	 * You may modify this (no restrictions) to help debug your code.
	 * 
	 */
	public String toString() {
		
		
	    return preOrder(root);
		   
		
		
		//return null;


	} // end toString() method
	
	
	/**
	 * 
	 * ------------------------------------
	 * You may modify this (no restrictions) to help debug your code.
	 * 
	 */
	public void printBST() {
		
		System.out.println( "*the root is:" + root.getElement() );
		System.out.println( "*the preOrder BST is:" + toString() );
		//System.out.println( "*the size of BST is:" + size() );
	} 
	// end printBST() method
	
	
	
//	public int size() {
//		return size(root);
//	}
//	   private int size(BinaryNode<AnyType> node) 
//	    { 
//	        if (node == null) 
//	            return 0; 
//	        else
//	            return(size(node.getLeft()) + 1 + size(node.getRight())); 
//	    } 

	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
		 * ------------------------------------
		 * TODO: You put your test cases here
		 * 
		 * 
		 */
		
		// this will get you started :)
		
		System.out.println( "------------------------------------ " );
		System.out.println( "the first trial,preOrder, Insert,Search and Min/Max " );
		System.out.println( "------------------------------------ " );

		
		BinarySearchTree<Integer> bst = null;
		
		try {
			
			bst = new BinarySearchTree<Integer>( 7 );
			bst.insert(14);
			bst.insert(21);
			bst.insert(-18);
			bst.insert(-28);
			bst.insert(0);
			bst.insert(1000);
			bst.insert(1);
			bst.printBST();
			//System.out.println( "*the size:" + bst.size() );
			
			System.out.println( "search 11:" + bst.search(11) );
			System.out.println( "search 1:" + bst.search(1) );
			
			System.out.println(  "the preOrder of BST: " + bst.preOrder() );
			
			System.out.println( "the min is:" + bst.min() );
			System.out.println( "the max is:" +bst.max() );
			
		} catch( NullBinaryNodeException error1 ) {
			
			System.out.println( error1 );
			
		}catch( DuplicateElementException error2 ) {
			
			System.out.println( error2 );
			
		}catch( EmptyBSTException error3 ) {
			
			System.out.println( error3 );
			
		}
		
		System.out.println( "------------------------------------ " );
		System.out.println( "the second trial, Delete" );
		System.out.println( "------------------------------------ " );
		try {
			System.out.println("delete 1000,which has no children:" + bst.delete(1000));
			bst.printBST();
			//System.out.println( "*the size after the first delete:" +bst.size() );
			System.out.println( "------------- " );
			System.out.println("delete 14,which has one child:" +bst.delete(14));
		    bst.printBST();
			//System.out.println( "*the size after the second delete:" + bst.size() );
			System.out.println( "------------- " );
			System.out.println("delete -18,which has two children:" + bst.delete(-18));
			bst.printBST();
			//System.out.println( "*the size after the 3rd delete:" + bst.size() );
			System.out.println( "------------- " );
			System.out.println("delete 7,which is the root with two children:" + bst.delete(7));
			bst.printBST();
			//System.out.println( "*the size after the 4th delete:" + bst.size() );
			System.out.println( "------------- " );
			System.out.println("delete 21,which is the root with one child:" + bst.delete(21));
			bst.printBST();
			//System.out.println( "*the size after the 5th delete:" + bst.size() );
			System.out.println( "------------- " );
			System.out.println("delete 22,which is not in the BST:" + bst.delete(22));
			bst.printBST();
			//System.out.println( "*the size after the 6th delete:" + bst.size() );
			
			System.out.println( "------------- " );
			
			
			System.out.println( "the min is:" + bst.min() );
			System.out.println( "the max is:" +bst.max() );
		} catch( NullBinaryNodeException error1 ) {
			
			System.out.println( error1 );
			
		}catch( EmptyBSTException error3 ) {
			
			System.out.println( error3 );
			
		}
		

		System.out.println( "------------------------------------ " );
		System.out.println( "the 3rd trial, Clear and Exception" );
		System.out.println( "------------------------------------ " );
		
		try {
			bst.clear();
			//bst.max();
			//bst.preOrder();
			//System.out.println( "the max is: " + bst.max() );
			//bst.delete(1000);
			//bst.delete(null);
			bst.insert(1);
			bst.printBST();
			System.out.println("delete 1,which is the only element/root in BST:" + bst.delete(1));
			System.out.println( "------------- " );
			//bst.printBST();
			bst.insert(1);
			bst.printBST();
			bst.insert(null);
			bst.max();
			
		} catch( NullBinaryNodeException error1 ) {
			
			System.out.println( error1 );
			
		}catch( DuplicateElementException error2 ) {
			
			System.out.println( error2 );
			
		}catch( EmptyBSTException error3 ) {
			
			System.out.println( error3 );
			
		}
		
	} // end main method
	

} // end BinarySearchTree class
