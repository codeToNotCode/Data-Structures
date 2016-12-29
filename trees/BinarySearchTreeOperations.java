/*
 * To perform Operations on Binary Search Tree 
 * Find()
 * Insert()
 * 		Insertion in a BST always happen at the last level 
 *		Insertion increases the number of levels in a BST by 1
 * Delete()
 * 		Element to be deleted is at the leaf node
 * 		Element to be deleted has only one child
 * 		Element to be deleted has 2 children
 * Max/Min()
 */

package trees;

import java.util.Scanner;

public class BinarySearchTreeOperations 
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
	 * Function to carry out Find Operation using Recursion
	 */
	public Node find(Node root, int data)
	{
		//Store the root node in a traverse node
		Node traverse = root;
		
		//Return null if the BST is not initialized or the data element to be searched is not present in the BST
		if(traverse == null)
			return null;
		
		//If the data to be searched is less than the data element of the current node, search the left sub-tree
		if( data < traverse.data )
			return find( traverse.left, data);
		
		//If the data to be searched is greater than the data element of the current node, search the right sub-tree
		else if( data > traverse.data)
			return find( traverse.right, data);
		
		/*
		 * Return the Node that contains the data element that was being searched
		 * This line of code will never run if the data element that is being searched is not present in the BST
		 */
		return traverse;
	}
	
	
	/*
	 * To insert a new node at the appropriate position in the BST
	 */
	public void insert(Node root, int data)
	{
		
		//Create a new node with the data value that has to be inserted in the BST
		Node newNode = new Node(data);
		
		//If the BST is empty, insert the newNode at the root itself
		if( root == null )
			root = newNode;
		
		//Create a new node to traverse the BST and initialize it to the root node of BST
		Node traverse = root;
		
		//Traverse the BST untill you reach a leaf node and there are no more nodes left to traverse
		while( traverse != null )
		{
			/*
			 * Search for the appropriate spot under which the newNode will be attached in the BST
			 * If value of the data to be inserted is less than the current node's data element, then:
			 * Traverse the left sub-tree
			 * Else Traverse the right sub-tree
			 * Exit from the loop once the newNode has been successfully attached to the BST
			 */
			if( traverse.data > data )
			{
				if( traverse.left != null )
					traverse = traverse.left;
				else
				{	
					traverse.left = newNode;
					break;
				}
			}
			else if ( traverse.data < data )
			{
				if( traverse.right != null )
					traverse = traverse.right;
				else
				{
					traverse.right = newNode;
					break;
				}
			}
		}
	}
	
	
	/*
	 * To Delete a particular element from the BST
	 * Return the deleted Node
	 */
	public Node delete(Node root, int data)
	{
		//Create a new node and store the root node in it
		Node traverse = root;
		
		//Return null if the BST is not initialized
		if ( traverse == null )
		{
			System.err.println("Error: BST is not initialized/Element not found");
			return null;
		} 
		
		/*
		 * If value that has to be deleted is less than the current node's value:
		 * Traverse the left subTree for the value to be deleted
		 * Else Traverse the right subTree for the value to be deleted
		 */
		else if ( data < traverse.data )
			traverse.left = delete( traverse.left, data);
		else if ( data > traverse.data )
			traverse.right = delete( traverse.right, data);
		
		//Once the value to be deleted has been located: The following cases arise
		else
		{
			/*
			 * Case 1: The node to be deleted has no child
			 * Simply delete the node as it is a leaf node and deletion of a leaf node will not affect the BST
			 */
			if( traverse.left == null && traverse.right == null )
				traverse = null;
			
			/*
			 * Case 2: The node to be deleted has only one child
			 * Make the child as the current node
			 * This will automatically delete the current node
			 */
			else if( traverse.left == null )
				traverse = traverse.right;
			else if( traverse.right == null )
				traverse = traverse.left;
			
			/*
			 * Case 3: The node to be deleted has two children
			 * Find the minimum element from the right subtree
			 * Copy the data element of the newly found minimum element into the current node's data element
			 * Delete the minimum node from the right subtree.
			 * 
			 * Alternate Way: The above case can also be solved using the left subtree.
			 * Find the maximum element from the left subtree
			 * Copy the data element of the newly found maximum element into the current node's data element
			 * Delete the maximum node from the left subtree.
			 */
			else
			{
				Node min = getMin(traverse.right);
				traverse.data = min.data;
				traverse.right = delete(traverse.right, min.data);
			}
		}
		
		return traverse;
	}
	
	
	/*
	 * To return the MAXIMUM element in the BST
	 * Since it is a BST, maximum element will be the leftmost element in the BST
	 */
	public Node getMax(Node root)
	{
		//Store the root node in a traverse node
		Node traverse = root;
		
		if( traverse == null )
		{
			System.err.println("Error: BST is empty : Cannot find Maximum element");
			return null;
		}
		
		//Traverse the tree untill you reach the rightmost element of the BST
		while( traverse.right != null )
			traverse = traverse.right;
		
		//Return the rightmost(maximum) node 
		return traverse;
	}
	
	
	/*
	 * To return the MINIMUM element in the BST
	 * Since it is a BST, minimum element will be the rightmost element in the BST
	 */
	public Node getMin(Node root)
	{
		//Store the root node in a traverse node
		Node traverse = root;
		
		if( traverse == null )
		{
			System.err.println("Error: BST is empty : Cannot find Minimum element");
			return null;
		}
		
		//Traverse the tree untill you reach the leftmost node of the BST
		while( traverse.left != null )
			traverse = traverse.left;
		
		//Return the rightmost(maximum) node 
		return traverse;
	}
		
	//To display contents of the BST using PreOrder Traversal technique
	public void preOrderTraversal(Node root)
	{
		//Store the root node in a traverse node
		Node traverse = root;
		
		//Check whether the tree is null or not
		if( traverse!= null )
		{
			/*
			 * Display root node
			 * Display left subtree
			 * Displlay right subtree
			 */
			System.out.print(traverse.data+" ");
			preOrderTraversal(traverse.left);
			preOrderTraversal(traverse.right);
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
		BinarySearchTreeOperations bt = new BinarySearchTreeOperations();
		Node root = bt.createBinaryTree();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the element you wish to find in the given Binary Search Tree : ");
		int data  = in.nextInt();
		
		Node elementFound = bt.find(root, data);
		
		System.out.println(elementFound != null ? "Element Present in the BST" : "Element Not Present in the BST");
		
		System.out.println("BST before insertion :\n");
		bt.preOrderTraversal(root);
		bt.insert(root,5);
		System.out.println("\nBST after insertion :\n");
		bt.preOrderTraversal(root);
		
		System.out.println("\n\nMaximum element of the BST : "+bt.getMax(root).data);
		System.out.println("Minimum element of the BST : "+bt.getMin(root).data);
		
		System.out.println("\n\nEnter the element you wish to delete : ");
		int delete = in.nextInt();
		System.out.println("BST before Deletion :\n");
		bt.preOrderTraversal(root);
		bt.delete(root,delete);
		System.out.println("\nBST after Deletion :\n");
		bt.preOrderTraversal(root);
		
		
		in.close();
	}
}
