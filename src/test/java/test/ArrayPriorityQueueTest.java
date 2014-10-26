package test;

import junit.framework.Assert;
import datastructures.*;

import org.junit.Test;

import static org.junit.Assert.*;


public class ArrayPriorityQueueTest {

	@Test
	public void testSlowInsertHighestFirst() {
		
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastDelete, SortScheme.HighestFirst);
		
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		Integer[] actualList = queue.getData();
		Integer[] expectedList = new Integer[] { 1,2,3,4,5 };
		
		Assert.assertEquals(actualList.length, expectedList.length);
		
		for (int i = 0; i < expectedList.length; i++) {
			Assert.assertEquals(expectedList[i], actualList[i]);
		}
	}
	
	@Test
	public void testSlowInsertLowestFirst() {
		
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastDelete, SortScheme.LowestFirst);
		
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		Integer[] actualList = queue.getData();
		Integer[] expectedList = new Integer[] { 5,4,3,2,1 };
		
		Assert.assertEquals(actualList.length, expectedList.length);
		
		for (int i = 0; i < expectedList.length; i++) {
			Assert.assertEquals(expectedList[i], actualList[i]);
		}
	}
	
	@Test
	public void testFastInsertHighestFirst() {
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastInsert, SortScheme.HighestFirst);
		
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		Integer[] actualList = queue.getData();
		Integer[] expectedList = new Integer[] { 4,1,3,2,5 };
		
		Assert.assertEquals(actualList.length, expectedList.length);
		
		for (int i = 0; i < expectedList.length; i++) {
			Assert.assertEquals(expectedList[i], actualList[i]);
		}
	}
	
	@Test
	public void testFastInsertLowestFirst() {
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastInsert, SortScheme.LowestFirst);
		
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		Integer[] actualList = queue.getData();
		Integer[] expectedList = new Integer[] { 4,1,3,2,5 };
		
		Assert.assertEquals(actualList.length, expectedList.length);
		
		for (int i = 0; i < expectedList.length; i++) {
			Assert.assertEquals(expectedList[i], actualList[i]);
		}
	}

	@Test
	public void testFastDeleteHighestFirst() {
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastDelete, SortScheme.HighestFirst);
		
		//Insert values
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		//Assert that the lists were initially equal
		Integer[] expectedList = new Integer[] { 1,2,3,4,5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		//Dequeue all values
		
		queue.dequeue();
		expectedList = new Integer[] { 1,2,3,4 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 1,2,3 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 1,2 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 1 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { };
		Assert.assertTrue(assertLists(expectedList, queue));
		
	}
	
	@Test
	public void testFastDeleteLowestFirst() {
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastDelete, SortScheme.LowestFirst);
		
		//Insert values
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		//Assert that the lists were initially equal
		Integer[] expectedList = new Integer[] { 5,4,3,2,1 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		//Dequeue all values
		
		queue.dequeue();
		expectedList = new Integer[] { 5,4,3,2 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 5,4,3 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 5,4 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { };
		Assert.assertTrue(assertLists(expectedList, queue));
	}
	
	@Test
	public void testSlowDeleteHighestFirst() {
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastInsert, SortScheme.HighestFirst);
		
		//Insert values
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		//Assert that the lists were initially equal
		Integer[] expectedList = new Integer[] { 4,1,3,2,5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		//Dequeue all values
		
		queue.dequeue();
		expectedList = new Integer[] { 4,1,3,2 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 1,3,2 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 1,2 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 1 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { };
		Assert.assertTrue(assertLists(expectedList, queue));
	}
	
	@Test
	public void testSlowDeleteLowestFirst() {
		ArrayPriorityQueue<Integer> queue =
				new ArrayPriorityQueue<Integer>(Integer.class, 5,
						PriorityScheme.FastInsert, SortScheme.LowestFirst);
		
		//Insert values
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(5);
		
		//Assert that the lists were initially equal
		Integer[] expectedList = new Integer[] { 4,1,3,2,5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		//Dequeue all values
		
		queue.dequeue();
		expectedList = new Integer[] { 4,3,2,5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 4,3,5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 4,5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { 5 };
		Assert.assertTrue(assertLists(expectedList, queue));
		
		queue.dequeue();
		expectedList = new Integer[] { };
		Assert.assertTrue(assertLists(expectedList, queue));
	}
	
	private boolean assertLists(Integer[] expectedList, ArrayPriorityQueue<Integer> queue) {
		
		if (queue.size() != expectedList.length)
			return false;
		
		Integer[] actualList = queue.getData();
		
		for (int i = 0; i < queue.size(); i++) {
			if (!expectedList[i].equals(actualList[i]))
				return false;
		}
		
		return true;
	}
}
