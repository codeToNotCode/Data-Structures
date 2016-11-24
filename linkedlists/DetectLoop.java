//To detect a loop in the linked list

package linkedlists;

public class DetectLoop {
	
	Node head;
	
	class Node
	{
		int data;
		Node next;
		boolean visited;
		
		Node(int d)
		{
			data = d;
			next = null;
			visited = false;
		}
	}
	
	//Push a node
	public void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	//Detect a loop
	public void detectLoop(Node head)
	{
		 Node traverse = head;
	        
	        while (traverse!=null)
	        {
	            if(traverse.visited == false)
	            {
	                  traverse.visited = true;
	                  traverse = traverse.next;
	            }
	            else
	            {
	            	System.out.println("Loop In List");
	            	return;
	            }
	        }
	        
	        System.out.println("No loops");
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		//Create a Linked list
		DetectLoop llist = new DetectLoop();
			
		//Insert nodes into the list
		llist.push(23);
		llist.push(4);
		llist.push(25);
		llist.push(225);
		llist.push(222);
		llist.push(57);
		llist.push(2633);
				
			
		llist.detectLoop(llist.head);
	}

}
