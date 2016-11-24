//Delete an entire linked list
//Since in java, automatic garbage collection happens, just changing head to null will dereference the linked link
//Garbage collector will take care of the memory to be freed


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


public class DeleteList {
	
	Node head;
	
	
	//Insert nodes into linked list
	public void push(int data)
	{
		Node new_node = new Node(data);
		
		new_node.next = head;
		
		head = new_node;
	}
	
	//Delete the entire Linked list
	//If we pass head as an argument to this function, then only local copy of head will be made as null
	//The actual head will still point to the linked list and all its elements will be displayed
	public void deleteList()
	{
		head = null;
		System.out.println("List DELETED");
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
	
	
	public static void main(String[] args) {
	
		//Create a Linked list
		DeleteList llist = new DeleteList();
				
		//Insert nodes into the list
		llist.push(2);
		llist.push(4);
		llist.push(25);
		llist.push(24);
		llist.push(52);
		llist.push(57);
		llist.push(547);
				
		System.out.println("Linked list before Deletion:\n");
		llist.display(llist.head);
		
		System.out.println();
		
		llist.deleteList();
	
		System.out.println("Linked list After Deletion:");
		llist.display(llist.head);
		
	}

}
