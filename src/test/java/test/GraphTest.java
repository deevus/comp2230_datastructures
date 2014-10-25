package test;

import java.util.LinkedList;

import junit.framework.Assert;
import datastructures.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

	@Test
	public void testConstructor() {
		Graph graph = new Graph();
		graph.add(null, 0);
		graph.add(null, 1);
			
		
		LinkedList<Vertex> ll = new LinkedList<Vertex>();
		ll.add(null);
		ll.add(null);
		
		Assert.assertEquals(ll, graph.getList());
	}
	
	@Test
	public void testSize_UniqueVertices() {
		Graph graph = new Graph();
		
		graph.add(new Vertex(), 0);
		graph.add(new Vertex(), 1);
		graph.add(new Vertex(), 2);
		
		int expectedSize = 3;
		
		Assert.assertEquals(expectedSize, graph.size());
	}
	
	@Test
	public void testSize_AppendedVertices() {
		Graph graph = new Graph();
		
		graph.add(new Vertex(), 0);
		graph.add(new Vertex(), 0);
		graph.add(new Vertex(), 1);
		
		int expectedSize = 2;
		
		Assert.assertEquals(expectedSize, graph.size());
	}
	
	@Test
	public void testAdd_TestAddReference() {
		Graph graph = new Graph();
		Vertex addVertex = new Vertex();
		graph.add(addVertex, 0);
		
		Assert.assertEquals(addVertex, graph.getVertex(0));
		
	}
	
	@Test
	public void testAdd_TestListModification() {
		Vertex v = new Vertex();
		Graph actualGraph = new Graph();
		actualGraph.add(v, 0);
		
		LinkedList<Vertex> expectedList = new LinkedList<Vertex>();
		expectedList.add(v);
		
		Assert.assertEquals(expectedList, actualGraph.getList());
	}
	
	@Test
	public void testAdjacentVertices() {
		Graph graph = new Graph();
		Vertex addVertex = new Vertex();
		
		graph.add(addVertex, 0);
		graph.add(addVertex, 0);
		int expetedSize = 1;
		
		Assert.assertEquals(expetedSize, graph.adjacentVertices(0));
	}
	
	@Test
	public void testGetVertex_HeadVertex() {
		Graph adjList = new Graph();
		Vertex v = new Vertex();
		adjList.add(v, 0);
		
		Assert.assertEquals(v, adjList.getVertex(0));
	}
	
	@Test
	public void testGetVertex_AppendedVertex() {
		Graph graph = new Graph();
		Vertex head = new Vertex();
		Vertex appended = new Vertex();
		
		graph.add(head, 0);
		graph.add(appended, 0);
		
		Assert.assertEquals(appended, graph.getVertex(0, 0));
	}
	
	@Test
	public void testPrintList_HeadVertex() {
		Graph graph = new Graph();
		NimVertex head = new NimVertex(5,4);
		NimVertex appended = new NimVertex(1,1);
		NimVertex included = new NimVertex(0,0);
		
		graph.add(head, 0);
		graph.add(appended, 0);
		graph.add(included, 1);
		
		String expectedOutput = "(0,0)";
		
		Assert.assertEquals(expectedOutput, graph.printList(1));
	}
	
	@Test
	public void testPrintList_AppendedVertex() {
		Graph graph = new Graph();
		NimVertex head = new NimVertex(5,4);
		NimVertex appended = new NimVertex(1,1);
		NimVertex notIncluded = new NimVertex(0,0);
		
		graph.add(head, 0);
		graph.add(appended, 0);
		graph.add(notIncluded, 1);
		
		String expectedOutput = "(5,4):(1,1)";
		
		Assert.assertEquals(expectedOutput, graph.printList(0));
	}
	
	@Test
	public void testToString() {
		Graph graph = new Graph();
		NimVertex head = new NimVertex(5,4);
		NimVertex appended = new NimVertex(1,1);
		NimVertex included = new NimVertex(0,0);
		
		graph.add(head, 0);
		graph.add(appended, 0);
		graph.add(included, 1);
		
		String expectedOutput = "(5,4):(1,1)\n(0,0)";
		String actualOutput = graph.toString();
		
		Assert.assertEquals(expectedOutput, actualOutput);
	}
}
