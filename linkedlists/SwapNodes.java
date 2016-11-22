//Swap 2 nodes in a list without swapping their data


package linkedlists;


class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data =d;
		next = null;
	}
}
public class SwapNodes {

	Node head;
	
	public void push(int data)
	{
		//Create new node and initialize its data
		Node new_node = new Node(data);
		
		//make new node's next point to current head
		new_node.next = head;
		
		//change head
		head = new_node;
	}
	
	//swap two nodes
	public void swapNodes(int x, int y)
	{
		//Create Nodes to store current and previous values of X and Y
		//Initialize the previous nodes to null
		//Initialize the current nodes to head
		Node prevX = null, prevY = null, currX = head, currY = head;
		
		//Check whether X and Y are data elements of the same node
		//In this case, no swapping required
		if( x == y )
		{
			System.out.println("\n\nElements corrospond to the same node: NO SWAPPING");
			return;
		}
		
		//Check whether X and Y are there in the list or not
		while ( currX != null && currX.data != x )
		{
			prevX = currX;
			currX = currX.next;
		}
		while ( currY != null && currY.data != y )
		{
			prevY = currY;
			currY = currY.next;
		}
		
		//If either of X or Y is not in the list, Cannot swap
		if( currX == null || currY == null)
		{
			System.out.println("\n\nOne or Both of the elements is/are not in the list:: CANNOT SWAP");
			return;
		}
		
		//If X is not at the head of the list, make prevX point to the Y element
		if ( prevX != null )
			prevX.next = currY;
		else
		//Make Y the new head of the list
			head = currY;
	
		//If Y is not at the head of the list, make prevY point to the X element
		if ( prevY != null )
			prevY.next = currX;
		else
			//Make X the new head of the list
			head = currX;
		
		//Perform Swap operation using a temporary node
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}
	
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

		//Create a Linked list
		SwapNodes llist = new SwapNodes();
		
		//Insert nodes into the list
		llist.push(2);
		llist.push(4);
		llist.push(25);
		llist.push(24);
		llist.push(52);
		llist.push(57);
		llist.push(547);
		
		System.out.println("Linked list before Swapping:");
		llist.display(llist.head);
		
		llist.swapNodes(532,12421);
		
		System.out.println("\nLinked list After Swapping:");
		llist.display(llist.head);
		

	}

}
