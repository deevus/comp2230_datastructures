package datastructures;

import java.lang.reflect.Array;

public class IndirectHeap<T extends Comparable<T>> {

	private T[] key;
	private int[] into;
	private int[] outOf;
	
	private final int MAX_SIZE;
	private int size;
	
	@SuppressWarnings("unchecked")
	public IndirectHeap(Class<T> _class, int maxSize) {
		key = (T[]) Array.newInstance(_class, maxSize);
		into = new int[maxSize];
		outOf = new int[maxSize];
		
		this.MAX_SIZE = maxSize;
		
		init();
	}
	
	public void init() {
		this.size = -1;
	}
	
	public boolean isEmpty() {
		return this.size == -1;
	}
	
	public boolean isFull() {
		return this.size == MAX_SIZE;
	}
	
	public void add(T val) {
		if (!isFull()) {
			size++;
			increase(size, val);
		}
	}
	
	public void set(int index, T val) {
		if (index > MAX_SIZE)
			throw new ArrayIndexOutOfBoundsException();
		
		increase(index, val);
	}
	
	public void swap(int index1, int index2) {
		int temp = outOf[index1];
		outOf[index1] = outOf[index2];
		outOf[index2] = temp;
		
		temp = into[outOf[index1]];
		into[outOf[index1]] = into[outOf[index2]];
		into[outOf[index2]] = temp;
	}
	
	private void increase(int index, T newValue) {
		key[index] = newValue;
		int child = into[index];
		int parent = child / 2;
		
		while (parent >= 1) {
			int compareVal = key[outOf[parent]].compareTo(newValue);
			if (compareVal >= 0) break;
			
			outOf[child] = outOf[parent];
			into[outOf[child]] = child;
			child = parent;
			parent = child / 2;
		}
		
		outOf[child] = index;
		into[index] = child;
	}
}
