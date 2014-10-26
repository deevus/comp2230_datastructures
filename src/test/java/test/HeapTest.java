package test;

import junit.framework.Assert;
import datastructures.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
	
	@Test
	public void testHeapify() {
		Integer[] array = new Integer[] {
			104, 71, 24, 66, 27, 23,
			8, 5, 32, 25, 18, 22
		};
		
		Integer[] expected = array.clone();
		
		Heap.heapify(array, array.length);
		
		Assert.assertEquals(expected, array);
	}
	
	@Test
	public void testInsert() {
		Heap<Integer> heap = new Heap<Integer>(Integer.class, 5);
	}
	
	@Test
	public void testDelete() {
		
	}
}
