package datastructures;
public class LLQueue<T> implements Queue<T> {
	Node<T> front;
	Node<T> end;

	public void init() {
		front = null;
		end = null;
	}

	public boolean empty() {
		return front == null && end == null;
	}

	public void enqueue(T val) {
		Node<T> newNode = new Node();
		newNode.data = val;

		end.next = newNode;
		end = newNode;
	}

	public void dequeue() {
		front = front.next;
	}

	public T front() {
		return front.data;
	}

}