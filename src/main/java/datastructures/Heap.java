package datastructures;

import java.util.*;
import java.lang.UnsupportedOperationException;

public class Heap<T extends Comparable<T>> implements Collection<T> {

	private final int MAX_SIZE;
	private int size;
	private ArrayList<T> data;
	
	@SuppressWarnings("unchecked")
	public Heap(int maxSize) {
		this.MAX_SIZE = maxSize;
		this.data = new ArrayList<T>(MAX_SIZE);
		
		init();
	}

	public Heap(List<T> data) {
		this.MAX_SIZE = data.size();
		this.data = new ArrayList<T>(data);
		this.size = data.size();
		this.heapify(this.data);
	}
	
	public void init() {
		this.size = -1;
	}

	public int size() {
		return size;
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}

	public boolean isEmpty() {
		return size == -1;
	}

	public void clear() {
		this.size = -1;
		this.data.clear();
	}

	public boolean add(T val) {
		try {
			insert(val);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean addAll(Collection<? extends T> c) {
		boolean result = this.data.addAll(c);
		this.heapify(this.data);

		return result;
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public boolean retainAll(Collection<?> c) {
		return this.data.retainAll(c);
	}

	public boolean contains(Object o) {
		return this.data.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return this.data.containsAll(c);
	}

	public Object[] toArray() {
		return this.data.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return data.toArray(a);
	}

	public Iterator iterator() {
		return this.data.iterator();
	}
	
	public void insert(T val) {
		size++;
		int childIndex = size;
		
		while (childIndex > 1 &&
			  (val.compareTo(data.get(childIndex / 2)) == 1)) {
			
			data.set(childIndex, data.get(childIndex / 2));
			childIndex = childIndex / 2;
		}
		
		data.set(childIndex, val);
	}
	
	public T largest() {
		return data.get(0);
	}
	
	public void delete() {
		data.set(1, data.get(size));
		size--;
		siftdown(data, size);
	}
	
	private static <T extends Comparable<T>> void siftdown(List<T> data, int rootIndex) {
		//last index
		int last = data.size() - 1;

		//get the root 
		T temp = data.get(rootIndex);
		System.out.println("Root: " + temp);

		//check for left child
		while (2 * rootIndex <= last) {
			int childIndex = 2 * rootIndex;

			//if there is a right child and it is begger than
			//the left child, move child
			if (childIndex < last) {
				int compareVal = data.get(childIndex + 1).compareTo(data.get(childIndex));
				if (compareVal == 1) childIndex++;
			}

			//move child up?
			int compareVal = data.get(childIndex).compareTo(temp);
			if (compareVal == 1) {
				data.set(rootIndex, data.get(childIndex));
			}
			else break; //exit loop
			
			rootIndex = childIndex;
		}
		
		//insert original root in correct spot
		data.set(rootIndex, temp);
	}
	
	public static <T extends Comparable<T>> void heapify(List<T> data) {
		for (int i = (int)Math.floor(data.size() / 2); i > 0; i--) {
			siftdown(data, i);
		}
	}

	public String toString() {
		return this.data.toString();
	}

}
