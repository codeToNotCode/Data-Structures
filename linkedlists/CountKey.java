//Count the number of times a particular element repeats itself in the list

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

	
	

public class CountKey {

	Node head;
	
	//Insert nodes into linked list
	public void push(int data)
	{
		Node new_node = new Node(data);
		
		new_node.next = head;
		
		head = new_node;
	}
	
	//Count repetition
	public int countRep(Node head, int key)
	{
		//NOde for traversal
		Node traverse = head;
		
		//Variable to count the number of repitions
		int count = 0;
		
		//traverse and search for key
		while(traverse != null)
		{
			if(traverse.data == key)
			{
				count++;
			}
			
			traverse = traverse.next;
		}
		
		return count;
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
		CountKey llist = new CountKey();
				
		//Insert nodes into the list
		llist.push(23);
		llist.push(4);
		llist.push(25);
		llist.push(225);
		llist.push(222);
		llist.push(57);
		llist.push(2633);
		
		int repeat = llist.countRep(llist.head, 2);
		
		if(repeat == 0)
			System.out.println("Key not present in the list");
		else
			System.out.println("Number of Repitions of the key in list::"+repeat);
	
	}

}
