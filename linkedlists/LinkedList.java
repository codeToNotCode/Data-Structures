/*
 *Insertion and Deletion
 */
package linkedlists;

public class LinkedList 
{

	//Head of the list
	Node head;
	
	//Linked list Node
	//This class is made static so that the main method can access it
	static class Node
	{
		int data;
		Node next;
		
		//Constructor to create a new Node
		//next is by default initialized to null
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	//Insertion at the HEad of list
	public void push(int new_data)
	{
		//1. Allocate memory for new Node
		//2. Store new_data into the data field of the new Node
		Node new_node = new Node(new_data);
		
		//3. Make new node's next point to the current head
		new_node.next = head;
		
		//4. Make new node as the new head of the list
		head = new_node;
	}
	
	//Insert after a given node in the list
	public void insertAfter(Node prev_node, int new_data)
	{
		
		//1. Check if the given previous node is null
		if( prev_node == null)
		{
			System.out.println("The previous node cannot be null");
			return;
		}
		
		//2 and 3. Allocate memory and save ne data in the new node
		Node new_node = new Node(new_data);
		
		//4. Make new node's next point to previous node's next
		new_node.next = prev_node.next;
		
		//5. Make previous node's next point to the new node
		prev_node.next = new_node;
	}
	
	//Insert at the end of the list
	public void append(int new_data)
	{
		
		 //1. Allocate memory for the new node
		 //2. Store new_data in the data field of new node
		 //3. Set new node's next as null (default from constructor)
		 Node new_node = new Node(new_data);
		 
		 //4. If the linked list is empty, make the new node as the head
		 if(head == null)
		 {
			 head = new Node(new_data);
			 return;
		 }
		
		 //5. New node is going to be the last node in the list
		 //So make its next point to null
		 new_node.next = null;
		 
		 //6. Traverse the current list and reach the end of the list
		 Node traverse = head;
		 while(traverse.next!=null)
			 traverse = traverse.next;
		 
		 //7. Point the next of the last node to the new node
		 traverse.next = new_node;
		 
		 return;
	}
	
	//Given a key, delete the first occurence of key in the list
	void deleteNode(int key)
	{
		
		//Store head node 
		Node temp = head;
		
		//Create a new node to keep track of previous element
		Node prev = null;
		
		//If the node to be deleted is the head node itself
		if( temp!=null && temp.data == key)
		{
			//Change the head
			head = temp.next;
			return;
		}
		
		//Search for the key to be deleted
		//Keep track of the previous node
		while( temp!=null && temp.data!=key)
		{
			prev = temp;
			temp = temp.next;
		}
		
		//If key is not found and end of list is reached
		if (temp == null)
			return;
		
		//If key is found from the while condition
		//Unlink the found node from the list
		prev.next = temp.next;
		temp = null;
	}
	
	//Delete a list node at a give position
	void deleteNodeAtPosition(int position)
	{
		//If linked list is empty
		if( head == null)
			return;
		
		//Store head and create a node to keep track of previous node
		Node temp = head, prev = null;
		
		//If position = 0, delete the head node
		if( position == 0 )
		{
			//change the head
			head = temp.next;
			return;
		}
		
		//Variable to update position
		int pos = 0;
		
		//Search for the position number 
		//keep track of the previous node
		while( temp!=null && pos++!=position)
		{
			prev = temp;
			temp = temp.next;
		}
		
		//If end of list is reached
		if(temp == null)
			return;
					
		//Delete the node at position at which the condition in the while node turns false
		prev.next = temp.next;
		temp=null;
	}
	
	//Display Linked List
	static void printList(Node head)
	{
		 Node traverse = head;
			
		 if(traverse == null)
		    System.out.println("Empty List");
		else
		{    
		    while( traverse!= null)
		    {
			System.out.print(traverse.data+" ");
	    		traverse = traverse.next;
		    }
		}
	}
		
	
    /* Driver program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
	public static void main(String args[])
	{
		//Start with an empty list
		LinkedList llist = new LinkedList();
		
		
		/*
			llist.head = new Node(1);
		 
			Node second = new Node(2);
			Node third = new Node(3);
		
			//Link first node to the second node
			llist.head.next = second;
		
			//Link second node to the third
			second.next = third;
		*/
		
		//Insert 6. So Linked List becomes 6->Null
		llist.push(6);
		
		//Insert 7 at the begining. LL 7->6->Null
		llist.push(7);
		
		//Insert 1 at the begining. LL 1->7->6->Null
		llist.push(1);
		
		//Insert 4 at the end. LL 1->7->6->4->Null
		llist.push(4);
		
		//Insert 8 after 7. LL 1->7->8->6->4->Null
		llist.insertAfter(llist.head.next, 8);
		
		
		//display linkedlist
		printList(llist.head);
		
		//Delete node with key = 6
		llist.deleteNode(6);
		
		
		//Delete node at position 2
		llist.deleteNodeAtPosition(1);
		
		 System.out.println("\nLinked List after Deletion");
		//display linkedlist
		printList(llist.head);
				
		
	}
}
