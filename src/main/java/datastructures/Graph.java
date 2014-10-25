package datastructures;

import java.util.LinkedList;

/**
 * Represents an adjacency matrix for a Graph using a list of Adjacent Vertices
 * 
 * @author Tyler Haigh - C3182929
 * @author Simon Hartcher - C3185790
 */
public class Graph {

	//Private Instance Variables
	private LinkedList<Vertex> vertices;
	private LinkedList<Edge> edges;
	private int size;
	
	/**
	 * Constructor for an Adjacency List. Initialises a new list on input size
	 * @param size The number of Vertices in the graph
	 */
	public Graph() {
		//Set the private instance variables
		this.vertices = new LinkedList<Vertex>();
		this.edges = new LinkedList<Edge>();
		this.size = 0;
	}
	
	/**
	 * Gets the size of the Adjacency List 
	 * @return The size of the list
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Adds a Vertex to the Adjacency List at the specified index. If the
	 * index has no previously set start Vertex, the input Vertex becomes the
	 * point of reference for adjacent Vertices
	 * 
	 * @param v The Vertex to add to the Adjacency List
	 * @param index The index to add the Vertex to
	 */
	public void add(Vertex v, int index) {
		
		if (index < vertices.size()) {
			
			Vertex w = this.vertices.get(index);
			
			//Append if the head Vertex exists at the index. Otherwise make a new
			//head node as a point of reference
			if (w != null) {
				w.append(v);
			} else {
				vertices.set(index, v);
				this.size++;
			}
		
		} else {
			//Add a filler for the list
			for (int i = vertices.size(); i < index; i++) {
				vertices.add(null);
			}
			
			//Add the new Vertex
			vertices.add(v);
			this.size++;
		}
		
	}
	
	/**
	 * Gets the number of adjacent vertices at a given index in the Adjacency
	 * List. Includes the Point of Reference Vertex
	 * 
	 * @param vertexIndex The index within the Adjacency List to refer to
	 * @return The number of adjacent Vertices in the input index
	 */
	public int adjacentVertices(int vertexIndex) {
		Vertex v = this.vertices.get(vertexIndex);
		return v.numEdgesOut();
	}
	
	public Vertex getVertex(int listIndex) {
		Vertex v = this.vertices.get(listIndex);
		return v;
	}
	
	/**
	 * Gets the Vertex at the List Index, at the Adjacent Vertex Index 
	 * 
	 * @param listIndex The index of the list of Adjacent Vertices to target
	 * @param vertexIndex The index of the Adjacent Vertex being requested
	 * @return The Vertex at the Adjacent Vertex position in the List Index row
	 */
	public Vertex getVertex(int listIndex, int vertexIndex) {
		Vertex v = this.vertices.get(listIndex);
		return v.getAdjacentVertexAt(vertexIndex);
	}
	
	/**
	 * Prints a formated String for a given row in the Adjacency List
	 * 
	 * @param index The row to print
	 * @return A formatted string containing all Vertices in the requested list
	 */
	public String printList(int index) {
		String result = "";
		Vertex v = this.vertices.get(index);
		
		result += v.toString() + ":";
		
		//Loop through all vertices in the index
		for (Vertex w: v.getAdjacentVertices()) {
			result += w.toString() + ",";
		}
		
		result = result.substring(0, result.length() - 1);
		return result;
	}
	
	/**
	 * Prints a formatted String representation of the entire Adjacency List
	 * 
	 * @return The String representation of the Adjacency List
	 */
	public String toString() {
		String result = "";
		
		//Loop through each list item
		for (Vertex v : vertices) {
			//Check the list is not empty
			if (v != null) {
				
				result += v.toString() + ":";
				
				//Loop through all Vertices in the list
				for (Vertex w : v.getAdjacentVertices()) {
					result += w.toString() + ",";
				}
				
				if (result.endsWith(","))
					result = result.substring(0, result.length() - 1);
				
				result += "\n";
			}
		}
		
		//Remove the last trailing \n and return
		result = result.substring(0,  result.length()-2);
		return result;
	}
	
	/**
	 * Getter method for the List containing the Points of Reference Vertices
	 * in the Adjacency List
	 * @return The List of Vertices maintained in the Adjacency List
	 * @notes This is for testing purposes only
	 */
	public LinkedList<Vertex> getList() {
		return this.vertices;
	}
	
	public String degrees() {
		String result = "";
		for (Vertex v : vertices) {
			
			int degree = v.numEdgesOut();
			
			result += "Vertex " + v.getIndex() + " has degree " + degree + "\n";
		}
		
		return result;
	}
}
