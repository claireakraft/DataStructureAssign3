//----------------------------------------------------------------------------
// StackInterface.java           by Dale/Joyce/Weems                 Chapter 2
//
// Interface for a class that implements a stack of <T>.
// A stack is a last-in, first-out structure.
//----------------------------------------------------------------------------
package assign3ABS;

/*** COSC 2100–Fall2021
 * Assignment#3* <this abstract class groups all the methods for creating and analyzing a stack>
 * @author<Claire Kraft>*/


public interface StackInterface<T>
{
  void push(T element) throws StackOverflowException;
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.

  void pop() throws StackUnderflowException;
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  
  T top() throws StackUnderflowException;
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  
  boolean isEmpty();
  // Returns true if this stack is empty, otherwise returns false.

  boolean isFull();
  // Returns true if this stack is full, otherwise returns false.


  void printStack();

  void compare();

  T bottom();

void popbottom();
}
