package datastructures;
public interface Stack<T> {

  /**
   * Make the stack empty
   */
  public void init();

  /**
   * Return true if the stack is empty. Return false if the stack is not empty
   */
  public boolean empty();

  /**
   * Add the item val to the stack
   */
  public void push(T val);

  /**
   * Remove the item most recently added to the stack.
   */
  public void pop();

  /**
   * Return the item most recently added to the stack,
   * but do not remove it.
   */
  public T top();
}