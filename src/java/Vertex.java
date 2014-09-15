public class Vertex<E> {
	private LinkedList<Vertex<E>> adjacentVertices;
	private E value;
	
	public void Vertex(E value) {
		
	}
	
	public LinkedList<Vertex<E>> getAdjacentVertices() {
		return this.adjacentVertices;
	}
	
	public E getValue() {
		return this.value;
	}
	
	public void append(Vertex<E> v) {
		adjacentVertices.add(v);
	}
}