package datastructures;

import java.lang.reflect.Array;

public class ArrayStack<T> {

	private final int MAX_SIZE;
	private int top;
	private T data[];
	
	@SuppressWarnings("unchecked")
	public ArrayStack(Class<T> _class, int maxSize) {
		this.MAX_SIZE = maxSize;
		data = (T[])Array.newInstance(_class, MAX_SIZE);
		
		stack_init();
	}
	
	public void stack_init() {
		top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == MAX_SIZE;
	}
	
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
		if (!isEmpty()) {
			pop_private();
		}
	}
	
	private void pop_private() {
		top--;
	}
	
	public T top() {
		if (!isEmpty()) {
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
		if (isEmpty()) return false;
		
		//Store top val temporarily
		T val = this.top();
		this.pop();
		
		//Check if now empty
		boolean flag = this.isEmpty();
		
		//Remember to push back
		this.push(val);
		
		//Return result of flag
		return flag;
	}
}
