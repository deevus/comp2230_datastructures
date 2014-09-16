public class Vertex<E> {
	public LinkedList<Vertex<E>> adjacentVertices;
	public E value;
	
	public void Vertex() {
		adjacentVertices = new LinkedList<Vertex<E>>();
	}
		
	public void append(Vertex<E> v) {
		adjacentVertices.add(v);
	}
}