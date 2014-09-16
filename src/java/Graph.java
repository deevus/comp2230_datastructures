
public class Graph<T> {

	LinkedList<Vertex<T>> vertices;
	
	public Graph() {
		vertices = new LinkedList<Vertex<T>>();
	}
	
	public void add(int vertexIndex, T val) {
		Vertex<T> newVertex = new Vertex<T>();
		newVertex.value = val;

		Vertex<T> existingVertex = vertices.get(vertexIndex);
		existingVertex.append(newVertex);
	}
	
	public String degrees() {
		String result = "";
		for (Vertex<T> v : vertices) {
			int count = 0;

			for (Vertex<T> adjacentVertex : v.adjacentVertices) {
				count++;
			}
			
			result += "Vertex " + v.value.toString() + " has degree " + count + "\n";
		}
		
		return result;
	}
}
