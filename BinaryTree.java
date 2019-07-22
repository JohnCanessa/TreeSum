package canessa.tree.sum;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

	/*
	 * 
	 */
	enum ChildLocation {
		LEFT,
		RIGHT
	}
	
	/*
	 * Breadth first is a queue, depth first is a stack.
	 */
	public class BinaryTree {

		// **** ****
		private Node root;
		
		/*
		 * constructor
		 */
		public BinaryTree(int value) {
			Node root = new Node(value);
			this.root = root;
		}
		
		/*
		 * return the root of the binary tree
		 */
		public Node getRoot() {
			return this.root;
		}
		
		/*
		 * add a node to the binary tree
		 */
		public void add(Node parent, Node child, ChildLocation location) {
			
			// **** set level in child node ****
			child.level = parent.level + 1;
			
			// **** insert the child at the specified location ****
			if (location == ChildLocation.LEFT) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}
		
		/*
		 * in order traversal
		 * left - root - right
		 */
		public void inOrder(Node n) {
			if (n != null) {
				inOrder(n.left);
				n.displayNode();
				inOrder(n.right);
			}
		}
		
		/*
		 * post order traversal
		 * left - right - root
		 */
		public void postOrder(Node n) {
			if (n != null) {
				inOrder(n.left);
				inOrder(n.right);
				n.displayNode();
			}
		}
		
		/*
		 * pre order traversal
		 * root - left - right
		 */
		public void preOrder(Node n) {
			if (n != null) {
				n.displayNode();
				inOrder(n.left);
				inOrder(n.right);
			}
		}
		
		/*
		 * This method implements a breadth-first search traversal of a binary tree.
		 * This method is not recursive.
		 * It displays all nodes at each level on a separate line.
		 */
		public void BFS(Node root) {
			List<Node> currentQ = new LinkedList<Node>();
			List<Node> nextQ	= new LinkedList<Node>();
			
			currentQ.add(root);
			
			while (!currentQ.isEmpty()) {
				Node n = currentQ.remove(0);
				System.out.print(n.toString() + " ");
				
				if (n.left != null)
					nextQ.add(n.left);
				if (n.right != null)
					nextQ.add(n.right);
				
				// **** check if end of current level ****
				if (currentQ.isEmpty()) {
					System.out.println();
					currentQ = nextQ;
					nextQ = new LinkedList<Node>();
				}
			}
			
		}
		
		/*
		 * Similar to BFS but using stacks.
		 * Does not seem to provide a known order.
		 */
		public void MysteryOrder(Node root) {
			Stack<Node> currentS 	= new Stack<Node>();
			Stack<Node> nextS 		= new Stack<Node>();
			
			currentS.push(root);
			
			while(!currentS.isEmpty()) {
				Node n = currentS.pop();
				System.out.print(n.toString() + " ");
				
				if (n.left != null)
					nextS.push(n.left);
				if (n.right != null)
					nextS.push(n.right);
			
				// **** ****
				if (currentS.isEmpty()) {
					System.out.println();
					currentS = nextS;
					nextS	 = new Stack<Node>();
				}
			}
		}

		/*
		 * 
		 */
		public void DFSInOrder(Node root) {
			Stack<Node> s 	= new Stack<Node>();
			Node n 			= root;
			
			while ((n != null) || (s.size() > 0)) {
				
		        while (n !=  null) { 
		            s.push(n); 
		            n = n.left; 
		        } 			

	            n = s.pop(); 
	            n.displayNode();
	            n = n.right; 
			}
		}
		
		/*
		 * 
		 */
		public void DFSPostOrder(Node root)  
	    { 
	        Stack<Node> stack 	= new Stack<Node>(); 
	        stack.push(root); 
	        Node prev 			= null;
	        
	        while (!stack.isEmpty())  { 
	            Node n = stack.peek(); 
	   
	            if (prev == null || prev.left == n || prev.right == n) { 
	                if (n.left != null) 
	                    stack.push(n.left); 
	                else if (n.right != null) 
	                    stack.push(n.right); 
	                else { 
	                    stack.pop(); 
	                    n.displayNode();
	                } 
	            }  else if (n.left == prev) { 
	                if (n.right != null) 
	                    stack.push(n.right); 
	                else { 
	                    stack.pop(); 
	                    n.displayNode();
	                }                    
	            } else if (n.right == prev)  { 
	                stack.pop(); 
	                n.displayNode(); 
	            } 
	            prev = n; 
	        } 
	    } 
		
		/*
		 * Compute the sum of all intermediate nodes from the root to all leaf nodes.
		 */
		public int sumLeafs(Node t, int prevSum) {
			
			// **** reached a leaf node ****
			if ((t.left  == null) &&
				(t.right == null)) {
				return (prevSum * 2) + t.value;
			}
			
			// **** returned from leaf nodes ****
			int sum	 = 0;
			
			// **** update the current sum ****
			t.currentSum = (prevSum * 2) + t.value;
			
			// **** have left child ****
			if (t.left != null) {
				sum += sumLeafs(t.left, t.currentSum);
			}
			
			// **** have right child ****
			if (t.right != null) {
				sum += sumLeafs(t.right, t.currentSum);
			}
			
			// **** ****
			return sum;
		}
	}
