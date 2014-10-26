package test;

import datastructures.*;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NimVertexTest {

	@Test
	public void testToString() {
		NimVertex v = new NimVertex(5,4);
		String expectedOutput = "(5,4)";
		String actualOutput = v.toString();
		
		Assert.assertEquals(expectedOutput, actualOutput);
	}
}
