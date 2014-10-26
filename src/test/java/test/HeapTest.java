package test;

import junit.framework.Assert;
import datastructures.*;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
	
	@Test
	public void testHeapify() {
		Integer[] array = new Integer[] {
			104, 71, 24, 66, 27, 23,
			8, 5, 32, 25, 18, 22
		};

		List<Integer> list = Arrays.asList(array);
		Collections.reverse(list);
		Heap<Integer> heap = new Heap<Integer>(list);

		Assert.assertEquals(array.length, heap.size());
		Assert.assertEquals(array[0], heap.largest());

		System.out.println(heap);
	}
	
	@Test
	public void testInsert() {
		Heap<Integer> heap = new Heap<Integer>(5);
	}
	
	@Test
	public void testDelete() {
		
	}
}
