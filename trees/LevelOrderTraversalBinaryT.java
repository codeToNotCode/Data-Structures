/*
 * To do a level-order traversal of a binary tree using Queues
 */

package trees;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversalBinaryT 
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
	 * Function to carry out levelOrder Traversal of the binary tree using Queues
	 */
	public void levelOrderTraversal(Node root)
	{
		/*
		 * In java, java.util.Queue is not a class but is an interface
		 * Therefore Queue<Node> queue = new Queue<Node>(); will be a compilation error as you cannot create an object of an interface
		 * Correct method: create an Object of LinkedList class and have a reference of Queue interface pointing to the LinkedList class object
		 */
		Queue<Node> queue = new LinkedList<Node>();
	
		/*
		 * Create a Node temp to store the address of the next level nodes in the queue
		 * Also displays the elements present in the current level of the binary tree
		 */
		Node temp ;
		
		//Check whether the tree is null or not
		if( root!= null )
		{
			//Enqueue the root element to the queue
			queue.add(root);
			
			//The loop continues untill the queue has no more nodes in it
			while(!queue.isEmpty())
			{
				/*
				 * At a particular level , dequeue the first element of that level
				 * Store the dequeued element in a temp node
				 * Display the data field of the dequeued node
				 */
				temp = queue.remove();
				System.out.print(temp.data+" ");
				
				/*
				 * Check whether the particular level has more sub-levels or not
				 * If yes, enqueue their respective left and right sub-nodes in the queue
				 */
				if( temp.left != null )
					queue.add(temp.left);
				if( temp.right != null )
					queue.add(temp.right);
			}
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
		LevelOrderTraversalBinaryT bt = new LevelOrderTraversalBinaryT();
		Node root = bt.createBinaryTree();
		
		System.out.println("Contents of the binary tree in Pre-Order Traversal :\n");
		bt.levelOrderTraversal(root);
	}
}
