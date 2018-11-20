package edu.cofc.csci230;

/**
 * 
 * Hash Simulator (main method)
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
public class HashSimulator { 
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
        
		HashTable hashDS = new ClosedHashing( HashTable.HASH_FUNC1 );
		System.out.printf("\n%s ----------------------------------\n", "Closed Hashing: FUNC1" );
		
		if ( hashDS.loadWords() ) {
			
			((ClosedHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert each word into hash data structure
			 * 
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 *    
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 *    
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */
			
			//(1)----------------------------
			int flag = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);//list使用get搞定的！！
				try{
					((ClosedHashing)hashDS).insert(word);
				}
				catch( HashTableKeyException error2 ) {				
					//System.out.println( error2 );
					flag++;
				}
			}
			// ((ClosedHashing)hashDS).collsize();
			
			System.out.printf( "(1)Number of unique words that successfully insert = %d\n", hashDS.getWords().size()-flag );
			System.out.println( "-------" );
			
			//(2-4)----------------------------
			System.out.println( "(2)the LoadFactor is:" + ((ClosedHashing)hashDS).loadFactor());
			System.out.println( "(3)the successful searches value is:" + ((ClosedHashing)hashDS).successfulSearches());
			System.out.println( "(4)the unsuccessful searches value is:" + ((ClosedHashing)hashDS).unsuccessfulSearches());

			System.out.println( "-------" );
			
			//(5)----------------------------
			double sum = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);
				try{
					sum = sum + ((ClosedHashing)hashDS).search(word);
				}
				catch( HashTableKeyException error2 ) {				
					System.out.println( error2 );
				}
			}
			System.out.println( "(5)the mean probe value of search is:" + sum/(hashDS.getWords().size()));
					
			//(6)----------------------------
			try {
				
			//String wordnotexist = "rooms";
			String wordnotexist = "haha";
			System.out.println( "(6)the probe value of searching the unexisted key is:" + ((ClosedHashing)hashDS).search(wordnotexist));
			//((ClosedHashing)hashDS).insert(wordnotexist);
			
			}
			catch( HashTableKeyException error2 ) {				
				System.out.println( error2 );
			}
			System.out.println( "-------" );
			
			//(7)----------------------------
			double sum2 = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);
				try{
					sum2 = sum2 + ((ClosedHashing)hashDS).delete(word);
				}
				catch( HashTableKeyException error2 ) {				
				}
			}
			System.out.println( "(7)the mean probe value of delete is:" + sum2/(hashDS.getWords().size()));
			
			//(8)----------------------------
			try{
				String wordnotexist = "haha";
				System.out.println( "(8)the probe value of deleting the unexisted key is:" + ((ClosedHashing)hashDS).delete(wordnotexist));
			}
			catch( HashTableKeyException error2 ) {				
				System.out.println( error2 );
			}
			
		} else {
			
			System.out.println("Failed to load words from text file" );
		}
		
		
		
		
		// -----------------------------------------------------------------------------------------------
		// Repeat for second hash function
		
		System.out.printf("\n%s ----------------------------------\n", "Closed Hashing: FUNC2" );
		hashDS = new ClosedHashing( HashTable.HASH_FUNC2 );
		
		if ( hashDS.loadWords() ) {
			
			((ClosedHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			
			
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert each word into hash data structure
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */
			
			
			//(1)----------------------------
			int flag = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);//list使用get搞定的！！
				try{
					((ClosedHashing)hashDS).insert(word);
				}
				catch( HashTableKeyException error2 ) {				
					//System.out.println( error2 );
					flag++;
				}
			}
			System.out.printf( "(1)Number of unique words that successfully insert = %d\n", hashDS.getWords().size()-flag );
			System.out.println( "-------" );
			
			//(2-4)----------------------------
			System.out.println( "(2)the LoadFactor is:" + ((ClosedHashing)hashDS).loadFactor());
			System.out.println( "(3)the successful searches value is:" + ((ClosedHashing)hashDS).successfulSearches());
			System.out.println( "(4)the unsuccessful searches value is:" + ((ClosedHashing)hashDS).unsuccessfulSearches());

			System.out.println( "-------" );
			
			//(5)----------------------------
			double sum = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);
				try{
					sum = sum + ((ClosedHashing)hashDS).search(word);
				}
				catch( HashTableKeyException error2 ) {				
					System.out.println( error2 );
				}
			}
			System.out.println( "(5)the mean probe value of search is:" + sum/(hashDS.getWords().size()));
						
			//(6)----------------------------
			try {
			//String wordnotexist = "rooms";
			String wordnotexist = "haha";
			System.out.println( "(6)the probe value of searching the unexisted key is:" + ((ClosedHashing)hashDS).search(wordnotexist));
			}
			catch( HashTableKeyException error2 ) {				
				System.out.println( error2 );
			}
			System.out.println( "-------" );
			
			//(7)----------------------------
			double sum2 = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);
				try{
					sum2 = sum2 + ((ClosedHashing)hashDS).delete(word);
				}
				catch( HashTableKeyException error2 ) {				
				}
			}
			System.out.println( "(7)the mean probe value of delete is:" + sum2/(hashDS.getWords().size()));
			
			//(8)----------------------------
			try{
				String wordnotexist = "haha";
				System.out.println( "(8)the probe value of deleting the unexisted key is:" + ((ClosedHashing)hashDS).delete(wordnotexist));
			}
			catch( HashTableKeyException error2 ) {				
				System.out.println( error2 );
			}

			
		} else {
			
			System.out.println("Failed to load words from text file" );
		}
		
		
		
		System.out.println( "------------------------------------------------------------------------" );
		System.out.println( "------------------------------------------------------------------------" );
		
		hashDS = new OpenHashing( HashTable.HASH_FUNC1 );
		System.out.printf("\n%s ----------------------------------\n", "Open Hashing: FUNC1" );
		
		if ( hashDS.loadWords() ) {
			
			((OpenHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert each word into hash data structure
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */

			//(1)----------------------------
			int flag = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);
				try{
					((OpenHashing)hashDS).insert(word);
				}
				catch( HashTableKeyException error2 ) {				
					//System.out.println( error2 );
					flag++;
				}
			}
			System.out.printf( "(1)Number of unique words that successfully insert = %d\n", hashDS.getWords().size()-flag );
			//System.out.printf( "(1)Number of unique words that successfully insert = %d\n", ((OpenHashing)hashDS).size());
			System.out.println( "-------" );
			
			//(2-4)----------------------------
			System.out.println( "(2)the LoadFactor is:" + ((OpenHashing)hashDS).loadFactor());
			System.out.println( "(3)the successful searches value is:" + ((OpenHashing)hashDS).successfulSearches());
			System.out.println( "(4)the unsuccessful searches value is:" + ((OpenHashing)hashDS).unsuccessfulSearches());

			System.out.println( "-------" );
			
			//(5)----------------------------
			double sum = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);
				try{
					sum = sum + ((OpenHashing)hashDS).search(word);
				}
				catch( HashTableKeyException error2 ) {				
					System.out.println( error2 );
				}
			}
			System.out.println( "(5)the mean probe value of search is:" + sum/(hashDS.getWords().size()));
						
			//(6)----------------------------
			try {
			//String wordnotexist = "rooms";
			String wordnotexist = "haha";
			System.out.println( "(6)the probe value of searching the unexisted key is:" + ((OpenHashing)hashDS).search(wordnotexist));
			}
			catch( HashTableKeyException error2 ) {				
				System.out.println( error2 );
			}
			System.out.println( "-------" );
			
			//(7)----------------------------
			double sum2 = 0;
			for(int i =0; i < hashDS.getWords().size(); i++) {
				String word = (hashDS.getWords()).get(i);
				try{
					sum2 = sum2 + ((OpenHashing)hashDS).delete(word);
				}
				catch( HashTableKeyException error2 ) {				
				}
			}

			System.out.println( "(7)the mean probe value of delete is:" + sum2/(hashDS.getWords().size()));
			
			//(8)----------------------------
			try{
				String wordnotexist = "haha";
				System.out.println( "(8)the probe value of deleting the unexisted key is:" + ((OpenHashing)hashDS).delete(wordnotexist));
			}
			catch( HashTableKeyException error2 ) {				
				System.out.println( error2 );
			}
			
			
			
			
		} else {
			
			System.out.println("Failed to load words from text file" );
			
		}
		
		// ------------------------------------------------
		// Repeat for second hash function
		
		hashDS = new OpenHashing( HashTable.HASH_FUNC2 );
		System.out.printf("\n%s ----------------------------------\n", "Open Hashing: FUNC2" );
		
		if ( hashDS.loadWords() ) {
			
			((OpenHashing)hashDS).initialize();
			
			System.out.printf( "Number of non-unique words in file = %d\n", hashDS.getWords().size() );
			
			/* ------------------------------------------------
			 * TODO:
			 * ------------------------------------------------
			 * 1) Insert (unique) each word into hash data structure
			 * 2) Calculate load factor value and print to 
			 *    console (using System.printf or System.println)
			 * 3) Calculate successful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 4) Calculate unsuccessful searches value and print to 
			 *    console (using System.printf or System.println)
			 * 5) For each word in words list, search in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 *    
			 *    (sum of probes for all of the words) / (number of words = 650)
			 *    (Word1 number of Probs + word2 num probes...) / (number of words)
			 *    
			 * 6) For a word (you choose) that does not exist in hashDS, 
			 *    try to search for it in the hashDS and then print the probe 
			 *    value to console (using System.printf or System.println)
			 * 7) For each word in words list, delete word in the hashDS, 
			 *    and print mean probe value to console (using 
			 *    System.printf or System.println)
			 * 8) For a word (you choose) that does not exist in hashDS, 
			 *    try to delete in the hashDS and then print the probe value to 
			 *    console (using System.printf or System.println)
			 * 
			 */
			

				//(1)----------------------------
				int flag = 0;
				for(int i =0; i < hashDS.getWords().size(); i++) {
					String word = (hashDS.getWords()).get(i);//list使用get搞定的！！
					try{
						((OpenHashing)hashDS).insert(word);
					}
					catch( HashTableKeyException error2 ) {				
						//System.out.println( error2 );
						flag++;
					}
				}
				System.out.printf( "(1)Number of unique words that successfully insert = %d\n", hashDS.getWords().size()-flag );
				//System.out.printf( "(1)Number of unique words that successfully insert = %d\n", ((OpenHashing)hashDS).size());
				System.out.println( "-------" );
				
				//(2-4)----------------------------
				System.out.println( "(2)the LoadFactor is:" + ((OpenHashing)hashDS).loadFactor());
				System.out.println( "(3)the successful searches value is:" + ((OpenHashing)hashDS).successfulSearches());
				System.out.println( "(4)the unsuccessful searches value is:" + ((OpenHashing)hashDS).unsuccessfulSearches());

				System.out.println( "-------" );
				
				//(5)----------------------------
				double sum = 0;
				for(int i =0; i < hashDS.getWords().size(); i++) {
					String word = (hashDS.getWords()).get(i);
					try{
						sum = sum + ((OpenHashing)hashDS).search(word);
					}
					catch( HashTableKeyException error2 ) {				
						System.out.println( error2 );
					}
				}
				System.out.println( "(5)the mean probe value of search is:" + sum/(hashDS.getWords().size()));
						
				//(6)----------------------------
				try {
				//String wordnotexist = "rooms";
				String wordnotexist = "haha";
				System.out.println( "(6)the probe value of searching the unexisted key is:" + ((OpenHashing)hashDS).search(wordnotexist));
				}
				catch( HashTableKeyException error2 ) {				
					System.out.println( error2 );
				}
				System.out.println( "-------" );
				
				//(7)----------------------------
				double sum2 = 0;
				for(int i =0; i < hashDS.getWords().size(); i++) {
					String word = (hashDS.getWords()).get(i);
					try{
						sum2 = sum2 + ((OpenHashing)hashDS).delete(word);
					}
					catch( HashTableKeyException error2 ) {				
					}
				}
				System.out.println( "(7)the mean probe value of delete is:" + sum2/(hashDS.getWords().size()));
				
				//(8)----------------------------
				try{
					String wordnotexist = "haha";
					System.out.println( "(8)the probe value of deleting the unexisted key is:" + ((OpenHashing)hashDS).delete(wordnotexist));
				}
				catch( HashTableKeyException error2 ) {				
					System.out.println( error2 );
				}
		
		} else {
			
			System.out.println("Failed to load words from text file" );
		}
		
    } // end main() method
	
} // end Hash Simulator class definition