public class Vertex {
	public LinkedList<Vertex> adjacentVertices;
	public int index;

	private static int _index = 1;
	
	public void Vertex() {
		adjacentVertices = new LinkedList<Vertex>();
		index = _index;
		_index++;
	}
		
	public void append(Vertex v) {
		adjacentVertices.add(v);
	}
}