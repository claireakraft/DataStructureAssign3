//----------------------------------------------------------------
// ArrayBoundedStack.java    by Dale/Joyce/Weems         Chapter 2
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//----------------------------------------------------------------

package assign3ABS;

/*** COSC 2100–Fall2021
 * Assignment#3* <This java file creates all the methods implemented in StackInterface java file>
 * @author<Claire Kraft>*/


public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1; // index of top element in stack
  

  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }
  
  public int size() {
	  return topIndex+1;
	  
  }
  
  //prints the elements of the stack from bottom to the top 
  public void printStack() {
	  
	  if (topIndex == -1)
		  System.out.println("Stack is empty");
	  else {
		  for (int i = topIndex; i >= 0; i--)
			  System.out.println("        " + elements[i]);
	  }
  }
  
  // this method gives the index of the bottom element
   public int bottomindex() {
	  int bottomIndex = 0;
	  while(elements[bottomIndex] == null && bottomIndex <= topIndex) {
	    bottomIndex = bottomIndex + 1;
	      }
	  return bottomIndex;
  }
  
  public T bottom()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns bottom element of this stack.
  {                 
    T bottomOfStack = null;
    int bottomIndex = this.bottomindex();
    while (isEmpty()) {
      throw new StackUnderflowException("bottom attempted on an empty stack.");
    }
      bottomOfStack = elements[bottomIndex];
    return bottomOfStack;
  }
  
 

  // this method pops the bottom element of the stack
  public void popbottom() {
	  int bottomIndex = this.bottomindex();
	  if (isEmpty())
	      throw new StackUnderflowException("Popbottom attempted on an empty stack.");
	    else
	    {
	      elements[bottomIndex] = null;
	      bottomIndex++;
	    }
  }
  
  // this element compares the top and bottom values of the stack, removes the smaller value, 
  // and repeats until no more values are left
  public void compare() {
	  int sumt = 0;
	  int sumb = 0;
	  int sumd = 0;
	  
	  while (this.bottomindex() <= topIndex) {
		int x = (int) this.bottom();
		int y = (int) this.top();
		
	  // if the bottom element is larger, the top element is set equal to null,
	  // one is add to sumb (score of bottom), and top is popped
	  	if (x > y) {
	  		this.pop();
	  		sumb = sumb + 1;
	  	}
	  // if the top element is larger, the bottom element is set equal to null,
	  // one is add to sumt (score of top), and bottom is popped
	  	else if (x < y) {
	  		this.popbottom();
	  		sumt = sumt + 1;
	  	}
	  // if they are equal, the top and bottom element are set equal to null,
	  // one is add to sumd (score of ties), top and bottom are popped when more than
	  // one element is left and only the top is poped if one element is left
	  	else{
	  		if (this.bottomindex() == topIndex) {
			    sumd = sumd + 1;
		  		this.pop();
	  		}
		  	else {
		  		this.pop();
		  		this.popbottom();
		  		sumd = sumd + 1;
		  	}
	  	}
	  }
	  
	  // score board is printed out 
	    System.out.println(" Score Card ");
	    System.out.println("B     T     D");
	    System.out.println(sumb + "     "+ sumt + "     " + sumd);
}
  

}