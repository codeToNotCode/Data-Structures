package linkedlists;

public class LinkedList {

	//Head of the list
	Node head;
	
	//Linked list Node
	//This class is made static so that the main method can access it
	static class Node{
		
		int data;
		Node next;
		
		//Constructor to create a new Node
		//next is by default initialized to null
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static void main(String args[]){
		
		//Start with an empty list
		LinkedList llist = new LinkedList();
		
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		//Link first node to the second node
		llist.head.next = second;
		
		//Link second node to the third
		second.next = third;
		
		//display linkedlist
		printList(llist.head);
	}
	
	static void printList(Node head){
		
		 Node traverse = head;
			
		 if(traverse == null)
		    System.out.println("Empty List");
		else{    
		    while( traverse!= null){
			
	    	System.out.print(traverse.data+" ");
	    	traverse = traverse.next;
	        }
		}
	}
}
