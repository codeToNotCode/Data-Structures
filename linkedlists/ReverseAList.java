package linkedlists;

public class ReverseAList {
	
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
		
	//Reverse a List
	public Node reverse(Node head)
	{
		//Create 3 nodes-prev,curr and next
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		//Run the loop and perform the reversal
		
		while( curr!= null)
		{
			//Move next node to the node pointed by curr's next pointer
			next = curr.next;
			
			//Make curr's pointer point back to the previous node
			curr.next = prev;
			
			//Move previous node to current node
			prev = curr;
			
			//Move the current node to the next node
			curr = next;
		}
		
		return prev;
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
		// TODO Auto-generated method stub
		
		//Create a Linked list
		ReverseAList llist = new ReverseAList();
						
		//Insert nodes into the list
		llist.push(23);
		llist.push(4);
		llist.push(25);
		llist.push(225);
		llist.push(222);
		llist.push(57);
		llist.push(2633);
			
		llist.display(llist.head);
		Node newHead = llist.reverse(llist.head);	
		System.out.println();
		llist.display(newHead);
		
		
	}

}
