package datastructures;

import java.lang.reflect.Array;

public class ArrayStack<T> implements Stack<T> {

	private final int MAX_SIZE;
	private int top;
	private T data[];
	
	@SuppressWarnings("unchecked")
	public ArrayStack(Class<T> _class, int maxSize) {
		this.MAX_SIZE = maxSize;
		data = (T[])Array.newInstance(_class, MAX_SIZE);
		
		init();
	}
	
	@Override
	public void init() {
		top = -1;
		
	}
	
	@Override
	public boolean empty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == MAX_SIZE;
	}
	
	@Override
	public void push(T val) {
		if (!isFull()) {
			push_private(val);
		}
	}
	
	private void push_private(T val) {
		top++;
		data[top] = val;
	}
	
	public void pop() {
		if (!empty()) {
			pop_private();
		}
	}
	
	private void pop_private() {
		top--;
	}
	
	public T top() {
		if (!empty()) {
			return top_private();
		} else {
			return null;
		}
	}
	
	private T top_private() {
		return data[top];
	}
	
	public boolean containsOne() {
		//Check if already empty
		if (empty()) return false;
		
		//Store top val temporarily
		T val = this.top();
		this.pop();
		
		//Check if now empty
		boolean flag = this.empty();
		
		//Remember to push back
		this.push(val);
		
		//Return result of flag
		return flag;
	}
	
}
