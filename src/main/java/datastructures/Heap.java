package datastructures;

import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>> {

	private final int MAX_SIZE;
	private int size;
	private T[] data;
	
	@SuppressWarnings("unchecked")
	public Heap(Class<T> _class, int maxSize) {
		this.MAX_SIZE = maxSize;
		this.data = (T[]) Array.newInstance(_class, maxSize);
		
		init();
	}
	
	public void init() {
		this.size = -1;
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public boolean isEmpty() {
		return size == -1;
	}
	
	public void insert(T val) {
		size++;
		int childIndex = size;
		
		while (childIndex > 1 &&
			  (val.compareTo(data[childIndex / 2]) == 1)) {
			
			data[childIndex] = data[childIndex / 2];
			childIndex = childIndex / 2;
		}
		
		data[childIndex] = val;
	}
	
	public T largest() {
		return data[1];
	}
	
	public void delete() {
		data[1] = data[size];
		size--;
		siftdown(data, size);
	}
	
	private static <T extends Comparable<T>> void siftdown(T[] data, int size) {
		int currentIndex = size;
		
		T temp = data[currentIndex];
		while (2 * currentIndex <= size) {
			int childIndex = 2 * currentIndex;
			if (childIndex < size) {
				int compareVal = data[childIndex + 1].compareTo(data[childIndex]);
				if (compareVal == 1) childIndex++;
			}
			
			int compareVal = data[childIndex].compareTo(temp);
			if (compareVal == 1) data[currentIndex] = data[childIndex];
			else break;
			
			currentIndex = childIndex;
		}
		
		data[currentIndex] = temp;
	}
	
	public static <T extends Comparable<T>> void heapify(T[] data, int size) {
		for (int i = size / 2; i > 0; i--) {
			siftdown(data, size);
		}
	}
	
}
