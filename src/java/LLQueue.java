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

	public void enqueue() {

	}

	public void dequeue() {

	}

	public T front() {
		return front.data;
	}

}