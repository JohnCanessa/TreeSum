package canessa.tree.sum;

public class Node {

	// **** members ****
	int 	value;
	Node 	left;
	Node 	right;
	
	int		currentSum;
	Node	parent;
	int		level;
	
	/*
	 * constructor(s)
	 * Root level is zero (0).
	 */
	public Node(int value) {
		this.value 	= value;
		this.left	= null;
		this.right	= null;
		
		this.parent = null;
		this.level 	= 0;
	}
	
	/*
	 * Display the specified node.
	 */
	public void displayNode() {
		System.out.println("value: " + value);
	}
	
	/*
	 * Generate a string with the contents of the node.
	 */
	public String toString() {
		return "" + this.value;
	}
}

