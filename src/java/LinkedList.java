import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
  private Node<T> start = new Node<T>(); //Sentinal Node
  private Node<T> tail = start;

  //*** Public Methods ***//

  /**
   * Insert val at the end of the list
   */
  public boolean add(T val) {
    insert(val, tail);
    tail = tail.next;
    return true;
  }

  public void add(T val, int index) {
    Node<T> currNode = start.next;
    
    //Finds the Node right before the node to insert at
    for (int i = 0; i < index; i++) {
      currNode = currNode.next;
    }

    insert(val, currNode);
  }

  public void addFirst(T val) {
    insert(val, start);
  }

  public void addLast(T val) {
    insert(val, tail);
    tail = tail.next;
  }

  public void clear() {
    while (start != null) {
      delete(start);
    }

    start = null;
    tail = null;
  }

  public boolean contains(T val) {
    Node<T> currNode = start.next;

    while (currNode != null) {
      if (currNode.data == val) return true;
      else currNode = currNode.next;
    }

    //Reached the end without finding the value
    return false;
  }

  public T get(int index) {
    Node<T> currNode = start.next;

    for (int i = 0; i < index; i++) {
      currNode = currNode.next;
    }

    return currNode.data;
  }

  public T getFirst() {
    return start.next.data;
  }

  public T getLast() {
    return tail.data;
  }

  public int indexOf(T val) {
    int index = 0;
    Node<T> currNode = start;

    while (currNode != null) {
      if (currNode.data == val) return index;
      else {
        currNode = currNode.next;
        index++;
      }
    }

    //Reached the end withotu finding the value
    return -1;
  }

  /**
  * Removes the element at the head of the list
  */
  public T remove() {
    T data = start.next.data;
    start.next = start.next.next;
    return data;
  }

  public T remove(int index) {
    Node<T> currNode = start.next;

    for (int i = 0; i < index; i++) {
      currNode = currNode.next;
    }

    T data = currNode.next.data;
    start.next = start.next.next;
    return data;
  }

  //*** Private Methods ***//

  /**
   * Deletes the node after the current node
   */
  private void delete(Node<T> pos) {
    pos.next = pos.next.next;
  }

  private void print(Node<T> start) {
    while (start != null) {
      System.out.println(start.data);
      start = start.next;
    }
  }

  /**
   * Inserts a node after the current position
   */
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