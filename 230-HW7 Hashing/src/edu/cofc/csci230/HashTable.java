package edu.cofc.csci230;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Hashtable abstract data structure.
 * 
 * @author CSCI 230: Data Structures and Algorithms 
 * 
 * Fall 2018 - Homework 7
 *
 */
public abstract class HashTable {
    
    /* constants */
    public static final int HASH_FUNC1 = 1; 
    public static final int HASH_FUNC2 = 2; 
    public static final int M = 210;

    /* private instance variables */    
    protected int hash_function = HASH_FUNC1;
    
    /* public class variables */
    protected static List<String> words = new ArrayList<String>();
    
    /**
     * Calculate hash value for a word
     * 
     * @param key
     * @return
     */
    public int calcHash( String key ) {
        
        int h_k = 0;
        
        switch ( hash_function ) {
        
            /**
             * Single hash function
             * 
             * h(k) = k mod m
             * 
             * k is the sum of ASCII integer values for each character 
             * in the string. See http://www.asciitable.com/ for character
             * to decimal conversions.
             * 
             * m = 210 (see M constant above)
             * 
             */
            case HASH_FUNC1:
                
                /*
                 * TODO: put solution here
                 */
            	char[] keychar=key.toCharArray();
            	int sum=0;
            	for(int i = 0; i<keychar.length;i++)
            		sum = sum + keychar[i];
            	h_k = sum%M; 
            	break;

            
            /**
            * Double hash function. See equation 7.6 on page 273
            * in the supplemental course text book (chapter is 
            * provided as PDF on OAKS in content section).
            * 
            * h(k) = ( l + 2*s(k) ) mod m
            * 
            * l is the sum of ASCII integer values for each character 
            * in the string. See http://www.asciitable.com/ for character
            * to decimal conversions.
            * 
            * s(k) = ( k mod m ) + 1
            * 
            * m = 210 (see M constant above)
            * 
            */
            default:
                
                /**
                 * TODO: put solution here
                 */
            	char[] keychar2=key.toCharArray();
            	int sum2=0;
            	for(int i = 0; i<keychar2.length;i++)
            		sum2 = sum2 + keychar2[i];
            	int s_k = (sum2 % M) + 1 ; 
            	h_k = ( sum2 + 2*s_k ) % M;  //so we supposed that K and L will be the same.
                
        }
        
        return h_k;

    } // end calcHash() method
    
    
    
    /**
     * 
     * @return
     */
    public List<String> getWords() {
        
        return words;
        
    } // end getWords() method
    
    
    
    /**
     * load words from text file into an Arraylist
     * 
     * 
     */
    public Boolean loadWords() {

        Boolean pass = true;
        File file = new File("words.txt");  
        Scanner scanner = null;

        words.clear();
        
        try {
            
            scanner = new Scanner( file );
            
            while ( scanner.hasNext() ) {
                
                /* read string and remove period if it exists */
                String word = scanner.next().replaceAll("\\.", "");
                word = word.replaceAll("\\!", "");
                word = word.replaceAll("\\,", "");
                word = word.replaceAll("\\?", "");
                word = word.replaceAll("\\:", "");
                word = word.replaceAll("\\;", "");
                
                words.add( word.toLowerCase() );
                    
            }
            
        } catch ( FileNotFoundException file_error ) {
            
            file_error.printStackTrace();
            
            pass = false;
            
        } finally {
            
            scanner.close();
            
        }
        
        return pass;
        
    } // end loadWords() method

} // end HashTable
