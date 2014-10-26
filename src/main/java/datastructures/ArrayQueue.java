package datastructures;

import java.lang.reflect.Array;

public class ArrayQueue<T> implements Queue<T> {

	private int front;
	private int rear;
	private T[] data;
	private final int MAX_SIZE;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(Class<T> _class, int maxSize) {
		this.MAX_SIZE = maxSize;
		this.data = (T[]) Array.newInstance(_class, maxSize);
		
		this.init();
	}

	@Override
	public void init() {
		this.front = -1;
		this.rear = -1;
	}

	@Override
	public boolean empty() {
		return rear == -1;
	}

	@Override
	public void enqueue(T val) {
		if (empty()) {
			front = 0;
			rear = 0;
		} else {
			rear++;
			if (rear == MAX_SIZE) {
				rear = 0;
			}
		}
		
		data[rear] = val;
	}

	@Override
	public void dequeue() {
		if (rear == front) {
			rear = -1;
			front = -1;
		} else {
			front = front + 1;
			if (front == MAX_SIZE) {
				front = 0;
			}
		}
	}

	@Override
	public T front() {
		return data[front];
	}
}
