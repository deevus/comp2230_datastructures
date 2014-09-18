public class Edge {

	public int weight = 1;
	public Vertex v; //First Vertex
	public Vertex w; //Second Vertex
	public int index;

	private static int _index = 1;


	public Edge() {
		index = _index;
		_index++;
	}
}