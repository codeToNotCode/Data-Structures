//To reverse a linked list using Recursion
package linkedlists;

public class ReverseAListRecursion {

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
		
	//Reverse a list RECURSIVELY
	public Node recReverse(Node curr, Node prev)
	   {
	       
	       //Base Case for Recursion
		   //When you reach the last node in the linked list, assign head to that node
	        if( curr.next == null )
	        {
	            head = curr;
	           
	            //Keep track of the previous element
	            curr.next = prev;
	            
	            return null;
	        }
	        
	        //A new pointer that points to the next node in the list
	        Node next1 = curr.next;
	        
	        //Make the current's next pointer to point to the previous node after saving its next node in next1
	        curr.next = prev;
	        
	        //Do a recursive call with next node and current node as arguments
	        recReverse(next1,curr);
	        return head;
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
		ReverseAListRecursion llist = new ReverseAListRecursion();
						
		//Insert nodes into the list
		llist.push(23);
		llist.push(4);
		llist.push(25);
		llist.push(225);
		llist.push(222);
		llist.push(57);
		llist.push(2633);
			
		llist.display(llist.head);
		System.out.println();
		
		Node recHead = llist.recReverse(llist.head, null);
		llist.display(recHead);
		
	}

}
