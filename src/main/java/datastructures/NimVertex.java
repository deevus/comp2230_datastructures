package datastructures;

/**
 * Represents a game state within the Game of NIM. Each state is defined by two
 * attributes: number of sticks remaining, and number of sticks the player can
 * take up to. NIM Vertices capture such information such as the state of the
 * game, and whether it is a "Winning" or "Losing" position
 * 
 * @author Tyler Haigh - C3182929
 * @author Simon Hartcher - C3185790
 *
 */
public class NimVertex extends Vertex {

	//Private instance variables
	private int sticksRemaining;
	private int sticksCanTake;
	
	private boolean winning;
	
	/**
	 * Constructor for a NIM Vertex. Sets the state of the Vertex
	 * 
	 * @param sticksRemaining The number of sticks remaining
	 * @param sticksCanTake The number of sticks the player can take up to
	 */
	public NimVertex(int sticksRemaining, int sticksCanTake) {
		super();
		
		//Set the private instance variables
		this.sticksRemaining = sticksRemaining;
		this.sticksCanTake = sticksCanTake;
	}

	/**
	 * Getter method for the number of sticks remaining
	 * @return The number of sticks remaining for this Vertex's game state
	 */
	public int getSticksRemaining() {
		return sticksRemaining;
	}

	/**
	 * Getter method for the number of sticks the player can take up to
	 * @return The number of sticks the player can take up to for this Vertex's
	 * 			game state
	 */
	public int getSticksCanTake() {
		return sticksCanTake;
	}
	
	/**
	 * Getter method for if the Vertex is a winning state or not
	 * @return True if the state is winning, false otherwise
	 */
	public boolean isWinning() {
		return winning;
	}

	/**
	 * Setter method for the number of sticks remaining
	 * @param sticksRemaining The new number of sticks remaining
	 */
	public void setSticksRemaining(int sticksRemaining) {
		this.sticksRemaining = sticksRemaining;
	}

	/**
	 * Setter method for the number of sticks the player can take up to
	 * @param sticksCanTake The new number of sticks the player can take
	 */
	public void setSticksCanTake(int sticksCanTake) {
		this.sticksCanTake = sticksCanTake;
	}
	
	/**
	 * Setter method for whether the Vertex state is winning or not
	 * @param winning True if the Vertex state is winning, false otherwise
	 */
	public void setWinning(boolean winning) {
		this.winning = winning;
	}
	
	/**
	 * Generates a formatted String representation of a NIM Vertex.
	 * @example (5,4)
	 * @return A String representation of the NIM Vertex 
	 */
	@Override
	public String toString() {
		return "(" + sticksRemaining + "," + sticksCanTake + ")";
	}
}
