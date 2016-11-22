//Search for an element in the linked list
//RECURSIVELY and ITERATIVELY

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


public class Search {

	Node head;
	
	//Insert elements into the list
	public void push(int data)
	{
		//Create a new node and intialize its data
		Node new_node = new Node(data);
		
		//make new node's next point to the current head
		new_node.next = head;
		
		//Change head
		head = new_node;
	}
	
	//Search for an element ITERATIVELY
	public boolean searchITR(Node head, int element)
	{
		//Store the current head
		Node traverse = head;
		
		//If element to be searched matches up with the head, return true
		if( head.data == element)
			return true;
		
		//Search for element in the list
		while( traverse!= null )
		{
			if( traverse.data == element)
				return true;
			traverse = traverse.next;
		}
		
		//Element not found
		return false;
	}
	
	//Search for an element RECURSIVELY
	public boolean searchREC(Node head, int element)
	{
		//Base case
		if( head == null )
			return false;
		
		if( head.data == element)
			return true;
		
		return searchREC(head.next,element);			
	}
	
	public static void main(String[] args) {
		
		//Create a Linked List
		Search llist = new Search();
		
		//insert elements
		llist.push(12);
		llist.push(1);
		llist.push(2);
		llist.push(123);
		llist.push(122);
		llist.push(1222);
		llist.push(10);
		
	
		System.out.println(llist.searchITR(llist.head, 1));
		System.out.println(llist.searchREC(llist.head, 1241));
		
	}

}
