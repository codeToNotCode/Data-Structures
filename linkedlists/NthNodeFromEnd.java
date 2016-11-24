//To find nth node from the end of the list


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

public class NthNodeFromEnd {

	

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
	
	//Using the formula length - nth + 1
	 int getNthFromLast(Node head, int n)
	    {
	        Node traverse = head;
	        
	        int len = 0;
	        int nth = 0;
	        
	        //Calculate the total number of nodes in the list
	        while ( traverse!=null )
	        {
	            traverse = traverse.next;
	            len++;
	        }
	        
	        //If required node that is required is greater than the total number of nodes, return -1
	        if (n>len)
	        {
	            return -1;
	        }
	        
	        //Initialize traverse to head again
	        traverse = head;
	    
	        for ( int i = 1 ; i <=len ; i++)
	        {
	        	//to find nth node from end = n-len+1 from the start
	            if( i == (len - n + 1))
	            {
	               nth =  traverse.data;
	               break;
	            }
	            else
	                traverse = traverse.next;
	        }
	        
	        //return the nth node from end
	        return nth;
	    
	    }    
	 
	 	//Using 2 Nodes
	 	int nthNode(Node head, int n)
	 	{
	 		//Create 2 nodes and initialize both to head
	 		Node traverse = head, main=head;
	 		
	 		int i =1;
	 		
	 		//Move the traverse node untill i == n
	 		while( i++ != n && traverse!=null)
	 			traverse = traverse.next;
	 		
	 		//If value of n is more than the number of nodes present in the list, return -1
	 		if (traverse == null)
	 			return-1;
	 		
	 		//Move the main node until traverse reaches null
	 		while (traverse.next!= null)
	 		{
	 			main = main.next;
	 			traverse = traverse.next;
	 		}
	 		
	 		return main.data;
	 	}
//	 	//Using Recursion
//	 	void nthNodeRecusion(Node head, int n)
//	 	{
//	 		
//	 		static int i = 0;   This works in C and C++ but not in java because in java static variables
//	 have class scope cannot be declared inside a function
//	 		if( head== null)
//	 			return;
//	 		
//	 		nthNodeRecusion(head.next, n);
//	 		
//	 		if( ++i == n)
//	 			System.out.println(head.data); 
//	 		
//	 	}

		//display linked list 
		public void display(Node head)
		{
			Node traverse = head;
			
			if( traverse == null)
			{
				System.out.println("Empty list");
				return;
			}
			else
			{
				while(traverse != null)
				{
					System.out.print(" "+traverse.data);
					traverse = traverse.next;
				}
					
			}
			
		}
		
		
	public static void main(String[] args) {
		
		//Create a linked list
		NthNodeFromEnd llist = new NthNodeFromEnd();
		
		llist.push(3);
		llist.push(3235);
		llist.push(31);
		llist.push(52);
		llist.push(64);
		llist.push(53);
		llist.push(343);
		llist.push(464);
		
		llist.display(llist.head);
		System.out.println("\n\nNth Node from the end is ::"+llist.getNthFromLast(llist.head, 1));
		System.out.println("\n\nNth Node from the end is ::"+llist.nthNode(llist.head, 1));
		
		
	}

}
