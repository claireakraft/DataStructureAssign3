package assign3ABS;

import java.util.Random;
import java.util.Scanner;

/*** COSC 2100–Fall2021
 * Assignment#3* <This implements the methods created in the ArrayBoundedStack java file which are implemented in StackInterface>
 * @author<Claire Kraft>*/

public class StackDriver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackInterface<Integer> stack;
	    // instead of T, String is used 
		
		// using scanner to prompt the user for number of elements in stack
		Scanner s = new Scanner(System.in);
		
		System.out.println("How many elements do you want in the stack?");
		int x = s.nextInt();
		
		// setting the stack bounds to the number the user gave
	    stack = new ArrayBoundedStack<Integer>(x); 
	    
	    // label
	    System.out.println("Top");
	    
	    // using random class to randomly select numbers and fill the stack
	    Random r = new Random();
	    for(int i = 0 ; i< x; i++) {
	    	stack.push(r.nextInt());
	    }
	    
	    // printing the stack from top to bottom 
	    stack.printStack();
	    
	    // label
	    System.out.println("bottom");
	    
	    // method called for comparing the values in the stack 
	    stack.compare();
	
	    System.out.println(" ");
	 
	    
	    
	}

}
