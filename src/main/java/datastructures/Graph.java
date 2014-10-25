package datastructures;

/**
 * Hello
 * @author Tyler 2
 *
 */
public class Graph {

	LinkedList<Vertex> vertices;
	LinkedList<Edge> edges;
	
	public Graph() {
		vertices = new LinkedList<Vertex>();
		edges = new LinkedList<Edge>();
	}
	
	/**
	 * Adds a disconnected Vertex
	 */
	public void add() {
		Vertex loneVertex = new Vertex();
	}

	/**
	 *	Adds a connected Vertex
	 */
	public void add(int existingVertexIndex) {
		//Create the new Vertex
		Vertex newVertex = new Vertex();

		//Append it to the connected Vertex
		Vertex existingVertex = vertices.get(existingVertexIndex);
		existingVertex.append(newVertex);

		newVertex.append(existingVertex);

		//Connect the two vertices via an edge
		Edge connectingEdge = new Edge();
		connectingEdge.v = existingVertex;
		connectingEdge.w = newVertex;

		this.vertices.add(newVertex);
		this.edges.add(connectingEdge);

	}

	public void connect(int vertexIndex1, int vertexIndex2) {
		//Get the respective Vertices
		Vertex v = vertices.get(vertexIndex1);
		Vertex w = vertices.get(vertexIndex2);

		//Create and Edge betwee the two
		Edge newEdge = new Edge();
		newEdge.v = v;
		newEdge.w = w;

		this.edges.add(newEdge);
	}
	
	public String degrees() {
		String result = "";
		for (Vertex v : vertices) {
			int count = 0;

			for (Vertex adjacentVertex : v.adjacentVertices) {
				count++;
			}
			
			result += "Vertex " + v.index + " has degree " + count + "\n";
		}
		
		return result;
	}
}
