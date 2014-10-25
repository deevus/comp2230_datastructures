package datastructures;
public interface Queue<T> {
  /**
   * Make the queue empty.
   */
  public void init();

  /**
   * Return true if the queue is empty. Return false if the queue is not empty.
   */
  public boolean empty();

  /**
   * Add the item val to the queue.
   */
  public void enqueue(T val);

  /**
   * Remove the item least recently added ot the queue.
   */
  public void dequeue();

  /**
   * Return the item least recently added to the queue, but do not remove it.
   */
  public T front();
}