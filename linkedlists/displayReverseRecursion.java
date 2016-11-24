//Displaying linked list in reverse order
//Not reversing the links

package linkedlists;

import linkedlists.ReverseAListRecursion.Node;

public class displayReverseRecursion {

	Node head;
	
	class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data =d;
			next = null;
		}
	}
	
	//Insert into a list
	public void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	public void displayReverse(Node head)
	{
		//Base condition for recursion to stop
		if(head == null)
			return;
		
		//Perform recursion by passing next node as the argument
		displayReverse(head.next);
		
		//Display for every time displayReverse() is popped off the stack
		System.out.print(" "+head.data);
	}
	
	//DIsplay linked list in normal order
	public void display(Node head)
	{
		Node traverse = head;
		
		if(traverse == null)
			System.out.println("\n EMPTY LIST");
					
		while( traverse!= null)
		{
			System.out.print(" "+traverse.data);
			traverse = traverse.next;
		}
	}
	
	//Driver Function
	public static void main(String[] args)
	{
		//Create a Linked list
		displayReverseRecursion llist = new displayReverseRecursion();
		
		//Insert nodes into the list
		llist.push(23);
		llist.push(4);
		llist.push(25);
		llist.push(225);
		llist.push(222);
		llist.push(57);
		llist.push(2633);
		
		System.out.println("Linked List in normal order::");
		llist.display(llist.head);			

		System.out.println("\n\nLinked List in backward order::");
		llist.displayReverse(llist.head);
	}

}
