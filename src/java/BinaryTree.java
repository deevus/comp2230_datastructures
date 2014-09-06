import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> {
  private BinaryNode<T> root = new BinaryNode<T>();

  public BinaryTree(T rootVal) {
    root.data = rootVal;
  }

  public Iterator<T> preOrderIterator() {
    return new PreOrderIterator();
  }

  public Iterator<T> iterator() {
    return preOrderIterator();
  }

  private abstract class BinaryTreeIterator implements Iterator<T> {
    Stack<BinaryNode<T>> stack = new LLStack<BinaryNode<T>>();

    public boolean hasNext() {
      return !stack.empty();
    }

    public void remove() { /* probably throw an exception  */ }
  }

  private class PreOrderIterator extends BinaryTreeIterator {
    public T next() {
      if (!this.hasNext()) throw new NoSuchElementException();
      BinaryNode<T> n = stack.top();
      stack.pop();

      if (n.right != null) stack.push(n.right);
      if (n.left != null) stack.push(n.left);

      return n.data;
    }
  }

  public int count() {
    return count_nodes(root);
  }

  private int count_nodes(BinaryNode<T> root) {
    if (root == null) return 0;

    return 1 + count_nodes(root.left) + count_nodes(root.right);
  }

}
