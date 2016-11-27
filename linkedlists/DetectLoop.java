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
	
	//Detect a loop --- Using Visited Flags --- Changes the Linked List  Data structure as a new instance variable has to be added
	public void detectLoop(Node head)
	{
		 Node traverse = head;
	        
	        while (traverse!=null)
	        {
	        	//Traverse the list untill a loop is encountered
	            if(traverse.visited == false)
	            {
	            	  //Mark the visited nodes as true once visited
	                  traverse.visited = true;
	                  //Move the traverse node to point to the next pointer
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
	
	
	//Detect a Loop --- Using Floyd's Cyccle Finding Algorithm
	//Traverse Linked List using 2 pointers
	//move slow pointer by 1 and fast pointer by 2
	//If they meet, there is a loop else not
	public void detectLoopFloyd(Node head)
	{
		//Slow and Fast Traverse node
		Node slowTraverse = head, fastTraverse = head;
		
		//Loop condition --- will exit if any of the current pointers is null 
		//Also if fastTraverse's next is null (Coz we are moving fastTraverse by 2, Therefore checking its next as we are skipping it)
		while( fastTraverse!= null && slowTraverse!=null && fastTraverse.next!=null)
		{
			//Move fast pointer by two nodes
			fastTraverse = fastTraverse.next.next;
			
			//Move slow pointer by 1 node
			slowTraverse = slowTraverse.next;
		
			//If both the pointers are same
			if(slowTraverse == fastTraverse)
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
				
		/*Create loop for testing */
		llist.head.next.next.next.next = llist.head;
        
		llist.detectLoop(llist.head);
		llist.detectLoopFloyd(llist.head);
	}

}
