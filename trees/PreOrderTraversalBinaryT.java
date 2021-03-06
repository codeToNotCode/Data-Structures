/*
 * To do a pre-order traversal of a binary tree using recursion
 */

package trees;

public class PreOrderTraversalBinaryT 
{
	/*
	 * Create a Node class to access every Node of the binary tree
	 * Since it is a binary tree, every node will point to exactly 2 more nodes namely left and right
	 * Every node also contains a data value
	 */
	public class Node
	{
		int data;
		Node left;
		Node right;
		
		//Constructor to initialize individual node values
		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	/*
	 * Function to carry out preOrder Traversal of the binary tree using recursion
	 * First the root node is displayed
	 * Second all the elements on the left side of the root node are displayed
	 * In the end all elements to the right side of the root node are displayed
	 */
	public void preOrderTraversal(Node root)
	{
		//Check whether the tree is null or not
		if( root!= null )
		{
			/*
			 * Display root node
			 * Display left subtree
			 * Displlay right subtree
			 */
			System.out.print(root.data+" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	//Function to create a Binary tree and initialize all the nodes
	public Node createBinaryTree()
	{
		Node rootNode = new Node(40);
		Node node20 = new Node(20);
		Node node10 = new Node(10);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		
		rootNode.left = node20;
		rootNode.right = node60;
		
		node20.left = node10;
		node20.right = node30;
		
		node60.left = node50;
		node60.right = node70;
		
		return rootNode;
	}
	
	//Driver Function
	public static void main(String[] args) 
	{
		PreOrderTraversalBinaryT bt = new PreOrderTraversalBinaryT();
		Node root = bt.createBinaryTree();
		
		System.out.println("Contents of the binary tree in Pre-Order Traversal :\n");
		bt.preOrderTraversal(root);
	}
}
