import java.util.Iterator;

public class LinkedList<T> {
  private Node<T> start = new Node<T>();
  private Node<T> tail = start;

  /**
   * Insert val at the end of the list
   */
  public void insert(T val) {
    insert(val, tail);
    tail = tail.next;
  }

  private void delete(Node<T> pos) {
    pos.next = pos.next.next;
  }

  private void print(Node<T> start) {
    while (start != null) {
      System.out.println(start.data);
      start = start.next;
    }
  }

  private void insert(T val, Node<T> pos) {
    Node<T> temp = new Node<T>();
    temp.data = val;
    temp.next = pos.next;
    pos.next = temp;
  }

  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {
    private Node<T> current = start.next;

    public boolean hasNext() {
      return current != null && current.next != null;
    }

    public T next() {
      current = current.next;

      return current.data;
    }

    public void remove() { }
  }
}