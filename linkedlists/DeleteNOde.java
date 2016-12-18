/*
 * Given only a pointer/reference to a node to be deleted in a singly linked list
 */

package linkedlists;
public class DeleteNOde 
{

	Node head;

	class Node
	{
		int data;
		Node next;
	
		Node(int d)
		{
			data = d;
			next = null;
		}
	}


	//Insert nodes into linked list
	public void push(int data)
	{
		Node new_node = new Node(data);
		
		new_node.next = head;
		
		head = new_node;
	}
	
	/*
	 * Delete a node based on the pointer to that node provided by the user
	 */
	public void deleteNOde(Node head, Node delete)
	{
		if(delete.next != null)
		{
			Node temp = delete.next;
			delete.data = temp.data;
			delete.next = temp.next;
		}
		
		else
			System.out.println("\nCannot Delete the last node");
	}
	
	//DIsplay linked list
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
	public static void main(String[] args) 
	{
		
		//Create a Linked list
		DeleteNOde llist = new DeleteNOde();
						
		//Insert nodes into the list
		llist.push(23);
		llist.push(4);
		llist.push(25);
		llist.push(225);
		llist.push(222);
		llist.push(57);
		llist.push(2633);
				
		//List before deletion
		System.out.println("\nList before Deletion");
		llist.display(llist.head);
		
		llist.deleteNOde(llist.head, llist.head.next.next.next.next.next	);
	
		//List after deletion
		System.out.println("\nList after Deletion");
		llist.display(llist.head);
				
				
	}

}
