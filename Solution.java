package canessa.tree.sum;


public class Solution {

	public static void main(String[] args) {
		
		// **** build the binary tree as illustrated here ****
		BinaryTree tree = new BinaryTree(1);	// was: 1
		Node root 		= tree.getRoot();

		// **** allocate nodes for the tree ****
		Node n2 = new Node(0);					// was: 0
		Node n3 = new Node(1);					// was: 1
		Node n4 = new Node(0);					// was: 0
		Node n5 = new Node(0);					// was: 0
		Node n6 = new Node(1);

		// **** add nodes to the tree ****
		tree.add(root, n2, ChildLocation.LEFT);
		tree.add(root, n5, ChildLocation.RIGHT);
		
		tree.add(n2, n3, ChildLocation.LEFT);
		tree.add(n2, n4, ChildLocation.RIGHT);
		
		tree.add(n5,  n6, ChildLocation.LEFT);
		
		// **** breadth first using queue ****
		System.out.println("main <<< BFS:");
		tree.BFS(root);
		System.out.println();
		
		// **** ****
		int sum = tree.sumLeafs(root, 0);
		System.out.println("main <<< sum: " + sum);
	}

}
