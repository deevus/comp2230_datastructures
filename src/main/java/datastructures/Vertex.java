package datastructures;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Represents a Vertex in a Graph
 * 
 * @author Tyler Haigh - C3182929
 * @author Simon Hartcher - C3185790
 *
 */
public class Vertex {
	
	//Private static instance variables
	private static int _index = 1;
	
	//Private instance variables
	private LinkedList<Vertex> adjacentVertices;
	private int index;

	private boolean marked;
	
	//Constructors
	
	/**
	 * Constructor for a Vertex. Sets the instance data
	 */
	public Vertex() {
		//Set the private instance variables
		this.adjacentVertices = new LinkedList<Vertex>();
		this.index = _index;
		this.marked = false;
		
		//Increment the static index
		_index++;
	}
		
	//Getters
	
	/**
	 * Getter method for the List of Adjacent Vertices to this Vertex
	 * @return A List of Vertices adjacent to this Vertex
	 */
	public LinkedList<Vertex> getAdjacentVertices() {
		return adjacentVertices;
	}

	/**
	 * Getter method for the index of this Vertex in the Graph
	 * @return The index of this Vertex
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Getter method for whether this Vertex has been marked or visited. Used
	 * when traversing a Graph
	 * 
	 * @return True if this Vertex is marked, false otherwise
	 */
	public boolean isMarked() {
		return marked;
	}

	//Setters

	/**
	 * Setter method for the Adjacent Vertices to this Vertex
	 * @param adjacentVertices The new list of Adjacent Vertices
	 * @warning This will break an existing Graph
	 */
	public void setAdjacentVertices(LinkedList<Vertex> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}

	/**
	 * Setter method for the index of this Vertex within the Graph
	 * @param index The new index of this Vertex
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Setter method for whether this Vertex has been marked. Used when
	 * traversing a Graph
	 * 
	 * @param marked True if the Vertex is to be marked, false otherwise
	 */
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	//Queries
	
	/**
	 * Appends a new Vertex to the list of adjacent Vertices
	 * @param v The Vertex to become adjacent to this Vertex
	 */
	public void append(Vertex v) {
		adjacentVertices.add(v);
	}

	public int numEdgesOut() {
		return adjacentVertices.size();
	}
	
	public Vertex getAdjacentVertexAt(int index) {
		return adjacentVertices.get(index);
	}
	
	/**
	 * Generates a String representation of a Vertex object
	 * @return A String representation of a Vertex
	 * @example (1)
	 */
	@Override
	public String toString() {
		return "(" + this.index + ")";
	}
	
	/**
	 * Checks whether two Vertices are equal
	 * @param obj A generic object to test against
	 * @return True if the Vertices are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		//Check the actual references of the objects
		if (this == obj)
			return true;
		
		//Check the classes match
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Vertex other = (Vertex) obj;
		
		//Check that the Adjacent Vertices are equal
		if (this.adjacentVertices != null && other.adjacentVertices != null) {
			//Check the size is equal
			if (adjacentVertices.size() != other.adjacentVertices.size()) {
				return false;
			} else {
				//Iterate over each Vertex and confirm they are equal
				Iterator<Vertex> thisIt = this.adjacentVertices.iterator();
				Iterator<Vertex> otherIt = other.adjacentVertices.iterator();
				
				while (thisIt.hasNext()) {
					Vertex v = thisIt.next();
					Vertex w = otherIt.next();
					
					if (!v.equals(w)) {
						return false;
					}
				}
			}
		} else if (this.adjacentVertices == null && other.adjacentVertices != null) {
			return false;
		} else if (this.adjacentVertices != null && other.adjacentVertices == null) {
			return false;
		}
		
		//All tests have passed, return true
		return true;
	}
}