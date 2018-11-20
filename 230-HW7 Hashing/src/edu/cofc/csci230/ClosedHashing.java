package edu.cofc.csci230;

/**
 * 
 * Closed hashing data structure using linear probing.
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
public class ClosedHashing extends HashTable { 
	
	/* private instance variables */
	private String[] hash_table;
	private int[] collision_table;
	
	/**
	 * Constructor
	 */
    public ClosedHashing( int hash_function ) {
    	
    	this.hash_function = hash_function;
    	
    } // end constructor
    
    /**
     * Initialize the hash table
     * 
     * The number of elements in the hash table is equal
     * to 2 x the number of words (may or may not be unique) 
     * in the word list.
     * 
     */
    public void initialize() {
    	
    	hash_table = new String[ 2*words.size() ];
    	collision_table = new int[ 2*words.size() ];
    	
    	for ( int i=0; i<hash_table.length; i++ ) {
    		
    		hash_table[i] = null;
    		
    	}
    	
    } // end initialize() method
    
    
    
    /**
     * Search for word in the hash table.
     * 
     * The collision_table is used to indicate a word/key collision key has 
     * occurred. In the collision_table the number at the computed key index 
     * position stores the total number of collisions. For example, 
     * collision_table[16] = 3 means three collisions have occurred at key 
     * index position 16 in the hash_table.
     * 
     * Exceptions: If the word does not exist in the hash table, then throw 
     *             a HashTableKeyException
     * 
     * return: The number of linear probes needed to find the word in the 
     * 		   hash table, e.g. Zero if no probing, n if probed n times to
     *         find the word location.
     * 
     * @param word
     * @return
     */
	public int search( String word ) throws HashTableKeyException {
		
		int probes = 0;
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */

		int index = calcHash(word);
		int i = 0;
		while(probes < hash_table.length && (i <= collision_table[index])) {
			if((index+probes)<hash_table.length ) {
				if(word.equals(hash_table[index+probes])) {
					return (probes);
				}
				if((hash_table[index+probes]!= null)&&(calcHash(hash_table[index+probes])==index)&& !(word.equals(hash_table[index+probes])))
					i++;
			}
			else {
				if(word.equals(hash_table[probes-(hash_table.length-index)]))
					return (probes);
				if((hash_table[probes-(hash_table.length-index)]!= null)&&(calcHash(hash_table[probes-(hash_table.length-index)])==index)&& !(word.equals(hash_table[probes-(hash_table.length-index)])))
					i++;
			}
			probes++;
		}
		throw new HashTableKeyException("the key you search does not exist");

		
		
	    
		
	} // end search() method
	
	/**
	 * Insert word into hash table
	 * 
	 * Exceptions: Duplicate words are not allowed, e.g., if "dog" already exists
	 * 			   in the hash table, then another "dog" word cannot be inserted.
	 * 	           For a duplicate word insert operation throw a HashTableKeyException.
	 * 
	 * @param word
	 */
	public void insert( String word ) throws HashTableKeyException {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		int index = calcHash(word);
		//System.out.println(index);
		
		if(hash_table[index]==null) {
			hash_table[index] = word;
			//System.out.println(1);
		}
		
		else {
			collision_table[index]=collision_table[index]+1;
			for(int i = 0; i < hash_table.length;i++) {
				if((index+i)<hash_table.length ) {
					if(hash_table[index+i]==null) {
						hash_table[index+i] = word;
						//System.out.println(1);
						break;
					}
					if(word.equals(hash_table[index+i])) {
						//System.out.println(0);
						throw new HashTableKeyException("Duplicate words");
					}
				}
				else {
					if(hash_table[i-(hash_table.length-index)]==null) {
						hash_table[i-(hash_table.length-index)] = word;
						//System.out.println(1);
						break;
					}
					if(word.equals(hash_table[i-(hash_table.length-index)])) {
						//System.out.println(0);
						throw new HashTableKeyException("Duplicate words");
					}
						
				}
			}
		}

		
		
//		double successinsert = 0;
//		for(int i = 0; i < hash_table.length; i++) {
//			if(hash_table[i]!= null)
//				successinsert++;
//		}
//		System.out.println( "Numerator N:" + successinsert);
		
		
		
	} // end insert() method
	
	/**
	 * Delete a word from the hash table. 
	 * 
	 * The collision_table is used to indicate a word/key collision key has 
     * occurred. In the collision_table the number at the computed key index 
     * position stores the total number of collisions. For example, 
     * collision_table[16] = 3 means three collisions have occurred at key 
     * index position 16 in the hash_table. 
     * 
     * Every successful word deletion should decrement the corresponding 
     * collision_table value by one. For example, if the key index position 
     * is 3 and the word has been successfully deleted then 
     * collision_table[16] = collision_table[16] - 1; Note: the number of 
     * collisions will never be less than zero. If it is, you have a bug
     * in your code :)
	 * 
	 * Exceptions: if they word does not exist in the hash table then throw
	 * 			   a HashTableKeyException
	 * 
	 * return: The number of linear probes needed to delete the word in the 
     * 		   hash table, e.g. Zero if no probing, n if probed n times to
     *         find the word location.
	 * 
	 * @param word
	 * @return
	 */
	public int delete ( String word ) throws HashTableKeyException {
		
		int probes = 0;
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
	      
		int index = calcHash(word);
		int i = 0;
		while(probes < hash_table.length && (i <= collision_table[index])) {
			if((index+probes)<hash_table.length ) {
				if(word.equals(hash_table[index+probes])) {
					hash_table[index+probes]=null;
					collision_table[index]--;
					return (probes);
				}
				if((hash_table[index+probes]!= null)&&(calcHash(hash_table[index+probes])==index)&& !(word.equals(hash_table[index+probes])))
					i++;
			}
			else {
				if(word.equals(hash_table[probes-(hash_table.length-index)])) {
					hash_table[probes-(hash_table.length-index)]=null;
					collision_table[index]--;
					return (probes);
				}
				if((hash_table[probes-(hash_table.length-index)]!= null)&&(calcHash(hash_table[probes-(hash_table.length-index)])==index)&& !(word.equals(hash_table[probes-(hash_table.length-index)])))
					i++;
			}
			probes++;
		}
		throw new HashTableKeyException("the key you want to delete does not exist");
		
		
	} // end delete() method
	
	
	
//	public void collsize() {
//		for(int i = 0; i < collision_table.length; i++) {
//			System.out.println(collision_table[i]);
//		} 
//	}
	
	/**
	 * See page 271 in supplemental course textbook (chapter is provided as PDF 
	 * on OAKS in content section).
	 * 
	 * Also, refer to your lecture notes. Note, for closed hashing, m is 
	 * the number of locations in the hash table.
	 * 
	 * @return
	 */
	public double loadFactor() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		//Calculate the N: number of keys that successfully inserted.
		double successinsert = 0;
		for(int i = 0; i < hash_table.length; i++) {
			if(hash_table[i]!= null)
				successinsert++;
		}
		//System.out.println( "Numerator N:" + successinsert);

		return (successinsert/hash_table.length);
				
	} // end loadFactor() method
	
	
	/**
	 * See equation (7.5) on page 273 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double successfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		return (0.5*(1+1/(1-loadFactor())));
				
	} // end successfulSearches() method
	
	/**
	 * See equation (7.5) on page 273 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double unsuccessfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		return (0.5*(1+1/((1-loadFactor())*(1-loadFactor()))));
				
	} // end unsuccessfulSearches() method
	
} // end ClosedHashing class definition