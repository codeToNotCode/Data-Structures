/*
 * To do a Post-order traversal of a binary tree using recursion
 */

package trees;

public class PostOrderTraversalBinaryT 
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
	 * Function to carry out postOrder Traversal of the binary tree using recursion
	 * First all the elements on the left side of the root node are displayed
	 * Second, all elements to the right side of the root node are displayed
	 * In the end the root node is displayed
	 */
	public void postOrderTraversal(Node root)
	{
		//Check whether the tree is null or not
		if( root!= null )
		{
			/*
			 * Display left subtree
			 * Display right subtree
			 * Displlay root node
			 */
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data+" ");
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
		PostOrderTraversalBinaryT bt = new PostOrderTraversalBinaryT();
		Node root = bt.createBinaryTree();
		
		System.out.println("Contents of the binary tree in Post-Order Traversal :\n");
		bt.postOrderTraversal(root);
	}
}
