
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

		//Connect the two vertices via an edge
		Edge connectingEdge = new Edge();
		connectingEdge.v = existingVertex;
		connectingEdge.w = newVertex;
		
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
