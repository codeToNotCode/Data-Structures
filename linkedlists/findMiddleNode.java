//To find the middle element of a linked list


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
public class findMiddleNode {

	
	Node head;
	
	public void push(int data)
	{
		Node new_node = new Node(data);
		
		new_node.next = head;
		
		head = new_node;
	}
	
	// Function to find middle element a linked list
    int getMiddle(Node head)
   {
         //Create nodes for fast traversal and slow traversal
         Node fastTraverse = head, slowTraverse = head;
         
        
         //Traverse the node
         while( fastTraverse!=null && fastTraverse.next != null)
         {
             fastTraverse = fastTraverse.next.next;
             slowTraverse = slowTraverse.next;
          
         }
         
         //Return the middle element
           return slowTraverse.data;
   }
    
    //display linked list
    public void display(Node head)
    {
    	Node traverse = head;
    	
    	while( traverse!=null)
    	{
    		System.out.print(" "+traverse.data);
    		traverse = traverse.next;
    	}
    }
    
    
	public static void main(String[] args) {
	
		
		findMiddleNode llist = new findMiddleNode();
		
		llist.push(45);
		llist.push(31);
		llist.push(12);
		llist.push(63);
		llist.push(23);
		llist.push(14);
		llist.push(23);
		llist.push(83);
	
		llist.display(llist.head);
		System.out.println("\nMiddle element of the Linked list is ::"+llist.getMiddle(llist.head));
	}

}
