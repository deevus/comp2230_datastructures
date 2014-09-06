public class LLStack<T> implements Stack<T> {
  Node<T> t;

  public void init() {
    t = null;
  }

  public boolean empty() {
    return t == null;
  }

  public void push(T val) {
    Node<T> temp = new Node<T>();
    temp.data = val;
    temp.next = t;
    t = temp;
  }

  public void pop() {
    t = t.next;
  }

  public T top() {
    return t.data;
  }
}