package edu.cofc.csci230;
import java.util.Scanner;
public class DNA {
	public static void main(String args[]){
        // create an object
        Scanner input=new Scanner(System.in);
        //object scanner from scanner
        //calling and define a constructor or default
                
        System.out.println("Enter upper DNA strand:");
        String upperdna = input.nextLine(); //input upper DNA, and its type
        System.out.println("Enter lower DNA strand:");
        String lowerdna = input.nextLine(); //input lower DNA, and its type
        input.close(); 
        if(upperdna.length()==0) {
        	System.out.println("The	entered	upper	strand	or	lower	strand	is	not	defined бн	\r\n" + 
        			"Exiting program");
        }
        //
        
        else {
        	if(upperdna.length()!=lowerdna.length()) {
        		System.out.println("The	entered	upper and lower strands	do	not	have the same \r\n" + 
        				"number	of	chemical bases бн Exiting program");
        	}
        	//length!!!!!!!!!!
        	
        	else {
        		char[] upperdna1 = upperdna.toCharArray();
        		char[] lowerdna1 = lowerdna.toCharArray();
        		// transfer type string into type char. Easier to use array/list in the loop
        		
        		int n = 0;int m = 0;
        		for(int x = 0;x < upperdna.length(); x++) {
        			if(upperdna1[x]=='A'||upperdna1[x]=='T'||upperdna1[x]=='G'||upperdna1[x]=='C'||
        					upperdna1[x]=='a'||upperdna1[x]=='t'||upperdna1[x]=='g'||upperdna1[x]=='c') {n++;}
        			if(lowerdna1[x]=='A'||lowerdna1[x]=='T'||lowerdna1[x]=='G'||lowerdna1[x]=='C'||
        					lowerdna1[x]=='a'||lowerdna1[x]=='t'||lowerdna1[x]=='g'||lowerdna1[x]=='c') {m++;}
        		}        			
        		if(n < upperdna.length()||m < lowerdna.length()){
        			System.out.println("The entered upper and lower stands must only contain combinations of A,\r\n" + 
    					"G, C, or T бн Exiting program"); 
        			}  
        		//combination!!!!!!!!!!
        		
        		else{
        			int j = 0;
        			for(int i = 0; i < lowerdna.length(); i++) {
        				char resultupper = upperdna.charAt(i);
        				char resultlower = lowerdna.charAt(i);        				
        				if((resultupper=='A'&&resultlower=='T')||
        						(resultupper=='T'&&resultlower=='A')||
        						(resultupper=='G'&&resultlower=='C')||
        						(resultupper=='C'&&resultlower=='G')||
        						(resultupper=='a'&&resultlower=='t')||
        						(resultupper=='t'&&resultlower=='a')||
        						(resultupper=='g'&&resultlower=='c')||
        						(resultupper=='c'&&resultlower=='g')) {             					
             					j++;
             				}
        				}        			
        			if(lowerdna.length()==j) {
        				System.out.println("The entered double-strand DNA pattern is correct бн Exiting program");
        			}
        			//finish!!!!!!!!!!!!        			        			
        			else {
    					System.out.println("The entered double-strand DNA pattern had base-pair errors that have\r\n" + 
    							"been corrected:");    					
    					int len = lowerdna.length();  
    					char[] correctlowerdna = new char[len];
    					//create the correct lower DNA, and its type. The same as before, type array/list,easier to use in the loop.
    					//use charAt in string, and use xxx[k] in array.
    					
    					for(int k = 0; k < len; k++) {    						    					
    						if(upperdna.charAt(k)=='A') {correctlowerdna[k]='T';}
    						if(upperdna.charAt(k)=='T') {correctlowerdna[k]='A';}   
    						if(upperdna.charAt(k)=='G') {correctlowerdna[k]='C';}   
    						if(upperdna.charAt(k)=='C') {correctlowerdna[k]='G';} 
    						if(upperdna.charAt(k)=='a') {correctlowerdna[k]='t';}
    						if(upperdna.charAt(k)=='t') {correctlowerdna[k]='a';}   
    						if(upperdna.charAt(k)=='g') {correctlowerdna[k]='c';}   
    						if(upperdna.charAt(k)=='c') {correctlowerdna[k]='g';}   
    					}
    					System.out.print(upperdna);
    					System.out.print("\b");
    					System.out.println(correctlowerdna);
    					System.out.println("бн Exiting program");    					
        			}//correct!!!!!
        		}
        	}
        }
	}
}

