
public class Graph {

	LinkedList<Vertex<int>> vertices;
	
	public Graph() {
		vertices = new LinkedList<Vertex<int>>();
	}
	
	public void add(int vertexIndex, int val) {
		Vertex newVertex = new Vertex(val);
		Vertex existingVertex = vertices.get(vertexIndex);
		existingVertex.append(newVertex);
	}
	
	public String degrees() {
		String result = "";
		for (Vertex v : vertices) {
			int count = 0;
			
			for (Vertex adjacentVertex : v.getAdjacentVertices()) {
				count++;
			}
			
			result += "Vertex " + v.getValue().toString() + " has degree " + count + "\n";
		}
		
		return result;
	}
}
