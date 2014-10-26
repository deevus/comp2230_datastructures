package datastructures;
public class Edge {

	public int weight = 1;
	public Vertex v; //From Vertex
	public Vertex w; //To Vertex
	public int index;

	private static int _index = 1;


	public Edge() {
		index = _index;
		_index++;
	}
	
	public Edge(Vertex v, Vertex w) {
		this.v = v;
		this.w = w;
	}
	
	public Edge(Vertex v, Vertex w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
}