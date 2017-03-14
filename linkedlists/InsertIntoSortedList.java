/*
 * Insert a new node into an already sorted Linked List
 */

package linkedlists;

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

public class InsertIntoSortedList 
{

	Node head;
	
	public void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	/*
	 * Insert a new node into an already sorted linked list
	 */
	public Node insertIntoSorted(Node head, int new_data)
	{
		//Create a new node that has to be inserted
		Node new_node = new Node(new_data);
		
		//If list is empty, insert the new node at the head
		//If value of head's data is greater than the data of new node's
		//Change the head
				
		if( head == null || head.data > new_node.data)
		{
			new_node.next = head;
			head = new_node;
			return head;
		}
		
		
		//Traverse the list, find a node whose data value is greater than the new node's data
		//Insert before the found node
		Node traverse = head;
		Node previous = head;
		
		/*
		 * ----------Without creation of a previous pointer
		 */
		while (traverse.next != null && (traverse.next.data < new_node.data))
		{
			traverse = traverse.next;
		}
		
		new_node.next = traverse.next;
		traverse.next = new_node;
		
		
		
		/*
		 * ----------With creation of a previous pointer
		 */
			
//		while( traverse!=null )
//		{
//			if( traverse.data > new_node.data)
//			{
//				new_node.next = traverse;
//				previous.next = new_node;
//				return head;
//			}
//			else
//			{
//				previous = traverse;
//				traverse = traverse.next;
//				
//			}
//		}
//		
//		//If the new node's data is greater than all the elements is the list
//		if( traverse==null)
//		{
//			new_node.next = traverse;
//			previous.next = new_node;
//		}
//		
		return head;
	}
	
	
	/*
	 * Display list elements
	 */
	public void display(Node head)
	{
		Node traverse = head;
		
		if(traverse == null)
		{
			System.out.println("\nEMPTY LIST");
			return;
		}
		
		while (traverse!=null)
		{
			System.out.print(" "+traverse.data);
			traverse = traverse.next;
		}
	}
	public static void main(String[] args) 
	{

		InsertIntoSortedList llist = new InsertIntoSortedList();
		
		llist.push(54);
		llist.push(34);
		llist.push(24);
		llist.push(14);
		llist.push(4);
		llist.push(4);
		llist.push(4);
		
		System.out.println("List before insertion::\n");
		llist.display(llist.head);
		
		Node new_head = llist.insertIntoSorted(llist.head, 21);
	
		System.out.println("\n\nList After insertion::\n");
		llist.display(new_head);
		
	}

}
