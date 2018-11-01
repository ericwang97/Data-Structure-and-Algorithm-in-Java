package edu.cofc.csci230;

import java.util.NoSuchElementException;

/**
 * Utilities class that will sort in ascending and descending order
 * the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort
 *	2. bubble sort
 *	3. insertion sort
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2018
 *
 */
public class Utils {
	
	
	public static boolean ascending = true; 
	
	/**
	 * 
	 */
	private Utils() {
		
	} // end private constructor
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void selectionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * 
		 * Implement selection sort algorithm as
		 * described in class. The pseudo-code for 
		 * this algorithm can also be found in the
		 * content section on OAKS and at the end
		 * of the homework assignment.
		 * 
		 * Must sort in:
		 * -----------------------------------------
		 * 1. ascending order (first element 
		 * in list is smallest value, last element in 
		 * list is largest value).
		 * 
		 * 2. descending order (first element 
		 * in list is largest value, last element in 
		 * list is smallest value).
		 * 
		 */
	    
		if(ascending == true) {
			try {
			int size = list.size();
			for(int i = 0; i < size-1;i++) {
				int min = i;
				for(int j = i+1; j < size; j++) {
					if((list.get(j)).compareTo(list.get(min))<0) {
						min = j;
					}
				
				}list.swap(i, min);
			}
		}
			 catch(IndexOutOfBoundsException e1){
				 throw new IndexOutOfBoundsException();
			 }
		}
		
		else if(ascending == false) {
			try {
			int size = list.size();
			for(int i = 0; i < size-1;i++) {
				int max = i;
				for(int j = i+1; j < size; j++) {
					if((list.get(j)).compareTo(list.get(max))>0) {
						max = j;
					}
				
				}list.swap(i, max);
			}
		}
			 catch(IndexOutOfBoundsException e1){
				 throw new IndexOutOfBoundsException();
			 }
		}
		
		System.out.println( list );
		System.out.printf( "Ascending order [%b]\n", ascending );
		
		
		
		
		
		
		
	} // end selectionSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * 
		 * Implement bubble sort algorithm as
		 * described in class. The pseudo-code for 
		 * this algorithm can also be found in the
		 * content section on OAKS and at the end
		 * of the homework assignment.
		 * 
		 * 
		 * Must sort in:
		 * -----------------------------------------
		 * 1. ascending order (first element 
		 * in list is smallest value, last element in 
		 * list is largest value).
		 * 
		 * 2. descending order (first element 
		 * in list is largest value, last element in 
		 * list is smallest value).
		 * 
		 */
		if(ascending == true) {
			try {
			int size = list.size();
			for(int i = 0; i < size-1;i++) {
				for(int j = 0; j < size-1-i; j++) {
					if((list.get(j+1)).compareTo(list.get(j))<0) {
						list.swap(j,j+1);
					}
				}
			}
		}
			 catch(IndexOutOfBoundsException e1){
				 throw new IndexOutOfBoundsException();
			 }
		}
		
		else if(ascending == false) {
			try {
			int size = list.size();
			for(int i = 0; i < size-1;i++) {
				for(int j = 0; j < size-1-i; j++) {
					if((list.get(j+1)).compareTo(list.get(j))>0) {
						list.swap(j,j+1);
					}
				}
			}
		}
			 catch(IndexOutOfBoundsException e1){
				 throw new IndexOutOfBoundsException();
			 }
		}
		
		System.out.println( list );
		
		System.out.printf( "Ascending order [%b]\n", ascending );
		
	} // end bubbleSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * 
		 * Implement insertion sort algorithm as
		 * described in class. The pseudo-code for 
		 * this algorithm can also be found in the
		 * content section on OAKS and at the end
		 * of the homework assignment.
		 * 
		 * 
		 * Must sort in:
		 * -----------------------------------------
		 * 1. ascending order (first element 
		 * in list is smallest value, last element in 
		 * list is largest value).
		 * 
		 * 2. descending order (first element 
		 * in list is largest value, last element in 
		 * list is smallest value).
		 * 
		 */
		if(ascending == true) {
			try {
			int size = list.size();
			for(int i = 1; i < size;i++) {
				AnyType v = list.get(i);
				int j = i-1;
				while(j>=0 && (list.get(j)).compareTo(v)>0) {
					list.set(j+1, (list.get(j)));
					j = j-1;
					}
				list.set(j+1, v);
				}
			}
			 catch(IndexOutOfBoundsException e1){
				 throw new IndexOutOfBoundsException();
			 }
		}
		
		
		else if(ascending == false) {
			try {
			int size = list.size();
			for(int i = 1; i < size;i++) {
				AnyType v = list.get(i);
				int j = i-1;
				while(j>=0 && (list.get(j)).compareTo(v)<0) {
					list.set(j+1, (list.get(j)));
					j = j-1;
					}
				list.set(j+1, v);
				}
			}
			 catch(IndexOutOfBoundsException e1){
				 throw new IndexOutOfBoundsException();
			 }
		}
		
		
		System.out.println( list );
		
		System.out.printf( "Ascending order [%b]\n", ascending );
		
		
		
		
		
	} // end insertionSort() method
	
} // end Utils class definition
