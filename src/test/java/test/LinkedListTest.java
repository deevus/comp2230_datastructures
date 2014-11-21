package test;

import datastructures.*;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

	@Test
	public void testSize() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		
		int expected = 2;
		int actual = ll.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSet() {
		LinkedList<Vertex> ll = new LinkedList<Vertex>();
		Vertex one = new Vertex();
		one.setIndex(1);
		Vertex two = new Vertex();
		two.setIndex(2);
		Vertex replace = new Vertex();
		replace.setIndex(3);
		
		ll.add(one);
		ll.add(two);
		
		assertEquals("(1)(2)", ll.toString());
		
		ll.set(0, replace);
		
		assertEquals("(3)(2)", ll.toString());
	}
	
	@Test
	public void testEquals() {
		LinkedList<Vertex> ll_one = new LinkedList<Vertex>();
		LinkedList<Vertex> ll_two = new LinkedList<Vertex>();
		
		Vertex one = new Vertex();
		Vertex two = new Vertex();
		
		ll_one.add(one);
		ll_one.add(two);
		
		ll_two.add(one);
		ll_two.add(two);
		
		boolean expected = true;
		boolean actual = ll_one.equals(ll_two);
		
		assertEquals(expected, actual);
	}
}
