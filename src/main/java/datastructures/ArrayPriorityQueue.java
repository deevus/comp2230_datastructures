package datastructures;

import java.lang.reflect.Array;

/**
 * @author Tyler 2
 *
 * @param <T>
 */
public class ArrayPriorityQueue<T extends Comparable<T>> {

	private final int MAX_SIZE;
	private T[] data;
	private int size;
	
	private PriorityScheme priority; 
	private SortScheme sort;
	
	@SuppressWarnings("unchecked")
	public ArrayPriorityQueue(Class<T> _class, int maxSize,
			PriorityScheme priority, SortScheme sort) {
		
		this.MAX_SIZE = maxSize;
		this.data = (T[])Array.newInstance(_class, MAX_SIZE);
		this.priority = priority;
		this.sort = sort;

		init();
	}
	
	public void init() {
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public int size() {
		return this.size;
	}
	
	public T[] getData() {
		return this.data;
	}
	
	public void enqueue(T val) {
		//Check that the queue is no full
		if (isFull())
			throw new IndexOutOfBoundsException("Priority Queue is full");
		
		//Insert based on the priority scheme
		if (priority == PriorityScheme.FastInsert) {
			fastInsert(val);
		} else {
			slowInsert(val);
		}
		
		//Increment the size
		size++;
	}
	
	/**
	 * Inserts at the end of the queue
	 * @param val
	 * @runningTime Theta(1)
	 */
	private void fastInsert(T val) {
		//Add the value at the end
		data[size] = val;
	}
	
	/**
	 * Inserts into the queue, keeping the order
	 * @param val
	 * @runningTime Theta(n)
	 */
	private void slowInsert(T val) {
		//This method keeps the priority queue in order so it
		//can remove in constant time. This requires updating the list
		//to keep it ordered (with the highest/lowest value at the end,
		//depending on the sorting scheme)
		
		//Find point of insertion
		int pointOfInsertion = size;
		
		for (int i = 0; i < size; i++) {
			//Compare values
			int compareVal = val.compareTo(data[i]);
			
			//Check if this is the point of insertion based on the
			//Sorting scheme and the resultant comparison value
			if (sort == SortScheme.HighestFirst && compareVal == -1) {
				pointOfInsertion = i;
				break;
			} else if (sort == SortScheme.LowestFirst && compareVal == 1) {
				pointOfInsertion = i;
				break;
			}
		}
		
		//Insert the value at the point of insertion
		T nextVal = data[pointOfInsertion];
		data[pointOfInsertion] = val;
		
		//Update remaining part of list
		for (int j = pointOfInsertion; j < (MAX_SIZE - 1); j++) {
			T temp = data[j+1];
			data[j+1] = nextVal;
			nextVal = temp;
		}
	}
	
	public void dequeue() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Priority Queue is empty");
		
		if (priority == PriorityScheme.FastDelete) {
			fastDelete();
		} else {
			slowDelete();
		}
		
		size--;
	}
	
	private void fastDelete() {
		//Do nothing??
	}
	
	/**
	 * @runningTime Theta(n)
	 * - Theta(n) to find remove val
	 * - Oh(n) to shift remaining values
	 */
	private void slowDelete() {
		//Slow delete must find the value with the highest "priority".
		//This involves scanning the entire list for the correct value
		//and then removing it by shifting elements in the array
		
		//Find max item
		int removalIndex = 0;
		T maxValue = data[0];
		
		for (int i = 0; i < size; i++) {
			int compareVal = data[i].compareTo(maxValue);
			
			if (sort == SortScheme.HighestFirst && compareVal == 1) {
				removalIndex = i;
				maxValue = data[i];
			} else if (sort == SortScheme.LowestFirst && compareVal == -1) {
				removalIndex = i;
				maxValue = data[i];
			}
		}
		
		//Shift remaining cells to the left
		for (int j = removalIndex; j < (MAX_SIZE - 1); j++) {
			data[j] = data[j + 1];
		}
		
	}
}
