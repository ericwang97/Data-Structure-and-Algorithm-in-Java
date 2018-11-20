package edu.cofc.csci230;

/**
 * 
 * Open hashing data structure
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
public class OpenHashing extends HashTable { 
	
	/* private instance variables */
	private ArrayList<String>[] hash_table;
	
	/**
	 * Constructor
	 */
    public OpenHashing( int hash_function ) {
    	
    	this.hash_function = hash_function;
    	
    } // end constructor
    
    /**
     * Initialize the hash table
     * 
     * The number of elements in the hash table (m) is equal M.
     * 
     */
    @SuppressWarnings("unchecked")
	public void initialize() {
    	
    	hash_table = (ArrayList<String>[]) new ArrayList[ HashTable.M ];
    	
    	for ( int i=0; i<hash_table.length; i++ ) {
    		
    		hash_table[i] = new ArrayList<String>();
    		
    	}
    	
    } // end initialize() method
    
    
    /**
     * Search for word in the hash table
     * 
     * Exceptions: If the key does not exist in the hash table, the throw
     * 		       a HashTableKeyException
     * 
     * return: The number of list probes needed to find the word in a list at 
     *         at the computed key location in the hash table, e.g. One if the 
     *         word is the first element in the list, n if the word is the very 
     *         last element in the list (where n is the number of elements in the 
     *         list at a the computed key location in the hash_table).
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
		ArrayList<String> wordlist = hash_table[index];
		for(probes = 0; probes < wordlist.size();probes++) {
			if(word.equals(wordlist.get(probes))) {
				return (probes+1);		
			}
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
			ArrayList<String> wordlist = hash_table[index];
			for(int i = 0; i < wordlist.size();i++) {
				if(word.equals(wordlist.get(i))) {
					throw new HashTableKeyException("Duplicate words");
				}
			}
			wordlist.add(word);

		
	} // end insert() method
	
	/**
	 * Delete a word from the hash table
	 * 
	 * Exceptions: if they word does not exist in the hash table, then throw
	 * 			   a HashTableKeyException
	 * 
	 * return: The number of list probes needed to delete the word in the list 
	 * 		   located at the key location in the hash table, e.g. One if the 
     *         word is the first element in the list, n if the word is the very 
     *         last element in the list (where n is the number of elements in the 
     *         list at a the computed key location in the hash_table).
	 * 
	 * @param key
	 * @return
	 */
	public int delete ( String word ) throws HashTableKeyException {
		
		int probes = 0;
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		int index = calcHash(word);
		ArrayList<String> wordlist = hash_table[index];
		for(probes = 0; probes < wordlist.size();probes++) {
			if(word.equals(wordlist.get(probes))) {
				wordlist.remove(probes);
				return (probes+1);		
			}
		}
		throw new HashTableKeyException("the key you want to delete does not exist");
	      
		
	} // end delete() method
	
	/**
	 * See page 271 in supplemental course textbook (chapter is provided as PDF 
	 * on OAKS in content section).
	 * 
	 * Also, refer to your lecture notes.
	 * 
	 * @return
	 */
	public double loadFactor() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		//Calculate the M: occupied position
		double loadFactor = 0;
		
		double OccupiedM = 0;
		ArrayList<String> wordlist2 = null;
		for(int i = 0; i < M; i++) {
			wordlist2 = hash_table[i];
			if(wordlist2.size() > 0) {
				OccupiedM++;
			}	
		}
		//System.out.println( "Dominator M:" + OccupiedM);
		
		//Calculate the N: number of keys that successfully inserted.
		double successinsert = 0;
		for(int i = 0; i < M; i++) {
			ArrayList<String> wordlist = hash_table[i];
			successinsert = successinsert+wordlist.size();
		}
		//System.out.println( "Numerator N:" +successinsert);
		
		loadFactor = successinsert/OccupiedM;
		return (loadFactor);
				
	} // end loadFactor() method

	
//    public int size() {
//        
//    	int successinsert = 0;
//		for(int i = 0; i < M; i++) {
//			ArrayList<String> wordlist = hash_table[i];
//			successinsert = successinsert+wordlist.size();
//		}
//		
//		return (successinsert);
//        
//    } // end size() method
    
	/**
	 * See equation (7.4) on page 271 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double successfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		return (1 + loadFactor()/2);
				
	} // end successfulSearches() method
	
	/**
	 * See equation (7.4) on page 271 in supplemental course textbook (chapter 
	 * is provided as PDF on OAKS in content section).
	 * 
	 * @return
	 */
	public double unsuccessfulSearches() {
		
		/* ----------------------------------
		 * TODO: Put your solution here
		 * ----------------------------------
		 */
		
		return loadFactor();
				
	} // end unsuccessfulSearches() method
	
	
	
	
	
	
		
} // end OpenHashing class definition
