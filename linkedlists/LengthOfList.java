//TO find number of nodes in a Linked List
//Iteratively and Recursively

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

public class LengthOfList 
{	
	
	Node head;
	
	public void push(int data)
	{
		
		//Create a new node and assign its data to input
		Node new_node = new Node(data);

	
		//make new node point to the head
		new_node.next = head;
		
		//update head
		head = new_node;
	}
	
	//To count number of nodes ITERATIVELY
	public int getCount()
	{
		
		//Store head
		Node traverse = head;
		
		//Declare a count variable and initialize it to 0
		int count = 0;
		
		if( traverse == null )
			return 0;
		
		while( traverse != null )
		{
			count++;
			traverse = traverse.next;
		}
		
		return count;
	}

	//To count number of nodes RECURSIVELY
	public int count(Node head){
		
		//Empty list
		if( head == null)
			return 0;
		
		return 1+count(head.next);
	}
	
	
	public static void main(String[] args) 
	{
		//Create a linked list
		LengthOfList llist = new LengthOfList();
		
		llist.push(3);
		llist.push(3);
		llist.push(3);
		llist.push(3);
		
		System.out.println("Number of nodes in the given Linked List is ::"+llist.getCount());
		System.out.println("Number of nodes in the given Linked List is ::"+llist.count(llist.head));
	}

}
